package com.community.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.community.dao.UserPostMapper;
import com.community.pojo.system.UserPost;
import com.community.pojo.system.UserUnitPost;
import com.community.utils.BCrypt;
import com.community.utils.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.UserMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.User;
import com.community.service.system.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserPostMapper userPostMapper;

    /**
     * 返回全部记录
     *
     * @return
     */
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<User> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<User> users = (Page<User>) userMapper.selectAll();
        return new PageResult<User>(users.getTotal(), users.getResult());
    }

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return
     */
    public List<User> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return userMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<User> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<User> users = (Page<User>) userMapper.selectByExample(example);
        return new PageResult<User>(users.getTotal(), users.getResult());
    }

    /**
     * 根据Id查询
     *
     * @param user_id
     * @return
     */
    public User findById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 修改
     *
     * @param user
     */
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }





    /**
     * 新增管理员
     *
     * @param userUnitPost
     */
    @Transactional
    public int add(UserUnitPost userUnitPost) {

        int i=0;
        //保存用户信息
        User user = userUnitPost.getUser();
        //判断账号是否存在
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",user.getAccount());
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()>0){
            throw new RuntimeException("账号已存在！");
        }
        //完善账号信息
        user.setUserId(idWorker.nextId());//主键id
        //密码盐
        String salt = BCrypt.gensalt();
        user.setSalt(salt);
        //密码加密
        user.setPassword(BCrypt.hashpw(user.getPassword(),salt));
        //创建时间
        user.setCreateTime(new Date());
        //更新时间
        user.setUpdateTime(new Date());
        //创建人 由于现在未使用安全框架，所以想给个固定值 admin
        //user.setCreateUser();
        //user.setUpdateUser();
        //添加用户
        userMapper.insert(user);

        //添加职位关联
        //获取职位id(多个按逗号分隔)
        String postId = userUnitPost.getPostId();
        if(postId!=null || postId!=""){
        String[] splitArr = postId.split(",");
        for(String split:splitArr){
            //添加到用户职位中间表
            UserPost userPost =new UserPost();
            userPost.setUserPosId(idWorker.nextId());
            userPost.setUserId(user.getUserId());
            userPost.setPosId(Long.parseLong(split));
            //添加到数据库
             i = userPostMapper.insert(userPost);
        }
        }
        return i;
    }




    /**
     * 修改用户信息
     * @param userUnitPost
     */
    @Transactional
    public int updateUserUnitPost(UserUnitPost userUnitPost){
        int i=0;
        //先根据用户id删除用户和角色的中间表信息
        User user = userUnitPost.getUser();
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",user.getUserId());
        userPostMapper.deleteByExample(example);

        //进行一些用户信息修改
        user.setUpdateTime(new Date());
        //user.setUpdateUser()
        //保存用户信息修改
        i = userMapper.updateByPrimaryKeySelective(user);

        //保存用户和职位的中间表
        //添加职位关联
        //获取职位id(多个按逗号分隔)
        String postId = userUnitPost.getPostId();
        if(postId!=null || postId!=""){
            String[] splitArr = postId.split(",");
            for(String split:splitArr){
                //添加到用户职位中间表
                UserPost userPost =new UserPost();
                userPost.setUserPosId(idWorker.nextId());
                userPost.setUserId(user.getUserId());
                userPost.setPosId(Long.parseLong(split));
                //添加到数据库
                userPostMapper.insert(userPost);
            }
        }
        return i;
    }



    /**
     *  /*
     *      * 根据id查找
     *      * @param id
     *      * @return
     *     * /
     * @param id
     * @return
     */
    public UserUnitPost findByUserUnitPostId(Long id) {
        //新建组合实体类，用于返回
        UserUnitPost userUnitPost=new UserUnitPost();
        //获取用户对像
        User user = userMapper.selectByPrimaryKey(id);
        //根据用户id查询职位id
        Example example=new Example(UserPost.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",user.getUserId());
        List<UserPost> userPostList = userPostMapper.selectByExample(example);
        //将职位id重新追加为String返回
        String s = userPostList.get(0).getPosId().toString();
        StringBuilder postId =new StringBuilder(s);
        for(int i=1;i<userPostList.size();i++){
            postId.append(","+userPostList.get(i).getPosId());
        }

        //添加到组合实体类
        userUnitPost.setUser(user);
        userUnitPost.setPostId(postId.toString());
        return userUnitPost;
    }


    /**
     * 逻辑删除
     * @param userId
     */
    @Transactional
    public int isDelete(Long userId) {
        User user=new User();
        user.setUserId(userId);
        user.setDelFlag("Y");
        user.setUpdateTime(new Date());
        //user.setUpdateUser();
        return userMapper.updateByPrimaryKeySelective(user);
    }


    /**
     * 物理删除
     * userId
     */
    @Transactional
    public int delete(Long userId) {
        //删除职位关联
        Example example=new Example(UserPost.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        userPostMapper.deleteByExample(example);
        //删除用户信息
        return userMapper.deleteByPrimaryKey(userId);
    }


    /**
     * 批量逻辑删除
     * @param ids
     */
    @Transactional
    public int deleteUsers(Long[] ids) {
        User user=new User();
        user.setDelFlag("Y");
        user.setUpdateTime(new Date());
        //user.setUpdateUser();
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("userId", Arrays.asList(ids));
        return userMapper.updateByExampleSelective(user, example);
    }


    /**
     * 修改账号状态
     * @param userId
     * @return
     */
    public int updateStatus(Long userId) {
       User user =new User();
       user.setUserId(userId);
       user.setStatus("DISABLE");
       user.setUpdateTime(new Date());
       //user.setUpdateUser();
        return userMapper.updateByPrimaryKeySelective(user);

    }


    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 头像路径
            if (searchMap.get("avatar") != null && !"".equals(searchMap.get("avatar"))) {
                criteria.andLike("avatar", "%" + searchMap.get("avatar") + "%");
            }
            // 账号
            if (searchMap.get("account") != null && !"".equals(searchMap.get("account"))) {
                criteria.andLike("account", "%" + searchMap.get("account") + "%");
            }
            // 密码
            if (searchMap.get("password") != null && !"".equals(searchMap.get("password"))) {
                criteria.andLike("password", "%" + searchMap.get("password") + "%");
            }
            // md5密码盐
            if (searchMap.get("salt") != null && !"".equals(searchMap.get("salt"))) {
                criteria.andLike("salt", "%" + searchMap.get("salt") + "%");
            }
            // 名字
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }
            // 性别(字典)
            if (searchMap.get("sex") != null && !"".equals(searchMap.get("sex"))) {
                criteria.andLike("sex", "%" + searchMap.get("sex") + "%");
            }
            // 电子邮件
            if (searchMap.get("email") != null && !"".equals(searchMap.get("email"))) {
                criteria.andLike("email", "%" + searchMap.get("email") + "%");
            }
            // 电话
            if (searchMap.get("phone") != null && !"".equals(searchMap.get("phone"))) {
                criteria.andLike("phone", "%" + searchMap.get("phone") + "%");
            }
            // 角色id(多个逗号隔开)
            if (searchMap.get("roleId") != null && !"".equals(searchMap.get("roleId"))) {
                criteria.andLike("roleId", "%" + searchMap.get("roleId") + "%");
            }
            // 状态(字典)
            if (searchMap.get("status") != null && !"".equals(searchMap.get("status"))) {
                criteria.andLike("status", "%" + searchMap.get("status") + "%");
            }
            // 是否删除（字典）
            if (searchMap.get("delFlag") != null && !"".equals(searchMap.get("delFlag"))) {
                criteria.andLike("delFlag", "%" + searchMap.get("delFlag") + "%");
            }

            // 乐观锁
            if (searchMap.get("version") != null) {
                criteria.andEqualTo("version", searchMap.get("version"));
            }

        }
        return example;
    }

}
