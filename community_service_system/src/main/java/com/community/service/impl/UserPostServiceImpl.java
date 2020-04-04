package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.UserPostMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.UserPost;
import com.community.service.system.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class UserPostServiceImpl implements UserPostService {

    @Autowired
    private UserPostMapper userPostMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<UserPost> findAll() {
        return userPostMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<UserPost> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<UserPost> userPosts = (Page<UserPost>) userPostMapper.selectAll();
        return new PageResult<UserPost>(userPosts.getTotal(),userPosts.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<UserPost> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return userPostMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<UserPost> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<UserPost> userPosts = (Page<UserPost>) userPostMapper.selectByExample(example);
        return new PageResult<UserPost>(userPosts.getTotal(),userPosts.getResult());
    }

    /**
     * 根据Id查询
     * @param user_pos_id
     * @return
     */
    public UserPost findById(Long userPosId) {
        return userPostMapper.selectByPrimaryKey(userPosId);
    }

    /**
     * 新增
     * @param userPost
     */
    public void add(UserPost userPost) {
        userPostMapper.insert(userPost);
    }

    /**
     * 修改
     * @param userPost
     */
    public void update(UserPost userPost) {
        userPostMapper.updateByPrimaryKeySelective(userPost);
    }

    /**
     *  删除
     * @param user_pos_id
     */
    public void delete(Long userPosId) {
        userPostMapper.deleteByPrimaryKey(userPosId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(UserPost.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){


        }
        return example;
    }

}
