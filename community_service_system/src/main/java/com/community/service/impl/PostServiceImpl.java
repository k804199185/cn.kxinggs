package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.PostMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.Post;
import com.community.service.system.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Post> findAll() {
        return postMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Post> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Post> posts = (Page<Post>) postMapper.selectAll();
        return new PageResult<Post>(posts.getTotal(),posts.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Post> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return postMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Post> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Post> posts = (Page<Post>) postMapper.selectByExample(example);
        return new PageResult<Post>(posts.getTotal(),posts.getResult());
    }

    /**
     * 根据Id查询
     * @param post_id
     * @return
     */
    public Post findById(Long postId) {
        return postMapper.selectByPrimaryKey(postId);
    }

    /**
     * 新增
     * @param post
     */
    public void add(Post post) {
        postMapper.insert(post);
    }

    /**
     * 修改
     * @param post
     */
    public void update(Post post) {
        postMapper.updateByPrimaryKeySelective(post);
    }

    /**
     *  删除
     * @param post_id
     */
    public void delete(Long postId) {
        postMapper.deleteByPrimaryKey(postId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Post.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 职位名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 职位编码
            if(searchMap.get("code")!=null && !"".equals(searchMap.get("code"))){
                criteria.andLike("code","%"+searchMap.get("code")+"%");
            }
            // 状态(字典)
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }
            // 备注
            if(searchMap.get("remark")!=null && !"".equals(searchMap.get("remark"))){
                criteria.andLike("remark","%"+searchMap.get("remark")+"%");
            }
            // 是否删除(字典)
            if(searchMap.get("delFlag")!=null && !"".equals(searchMap.get("delFlag"))){
                criteria.andLike("delFlag","%"+searchMap.get("delFlag")+"%");
            }

            // 顺序
            if(searchMap.get("sort")!=null ){
                criteria.andEqualTo("sort",searchMap.get("sort"));
            }

        }
        return example;
    }

}
