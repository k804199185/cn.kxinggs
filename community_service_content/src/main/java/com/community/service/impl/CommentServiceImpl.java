package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.CommentMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.Comment;
import com.community.service.content.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Comment> findAll() {
        return commentMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Comment> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Comment> comments = (Page<Comment>) commentMapper.selectAll();
        return new PageResult<Comment>(comments.getTotal(),comments.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Comment> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return commentMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Comment> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Comment> comments = (Page<Comment>) commentMapper.selectByExample(example);
        return new PageResult<Comment>(comments.getTotal(),comments.getResult());
    }

    /**
     * 根据Id查询
     * @param tiezi_comment_id
     * @return
     */
    public Comment findById(Long tieziCommentId) {
        return commentMapper.selectByPrimaryKey(tieziCommentId);
    }

    /**
     * 新增
     * @param comment
     */
    public void add(Comment comment) {
        commentMapper.insert(comment);
    }

    /**
     * 修改
     * @param comment
     */
    public void update(Comment comment) {
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    /**
     *  删除
     * @param tiezi_comment_id
     */
    public void delete(Long tieziCommentId) {
        commentMapper.deleteByPrimaryKey(tieziCommentId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 评论内容
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }
            // 删除标志 0正常 1 删除(屏蔽)
            if(searchMap.get("delFlag")!=null && !"".equals(searchMap.get("delFlag"))){
                criteria.andLike("delFlag","%"+searchMap.get("delFlag")+"%");
            }
            // 评论人头像
            if(searchMap.get("userAvatar")!=null && !"".equals(searchMap.get("userAvatar"))){
                criteria.andLike("userAvatar","%"+searchMap.get("userAvatar")+"%");
            }
            // 评论人名称
            if(searchMap.get("userName")!=null && !"".equals(searchMap.get("userName"))){
                criteria.andLike("userName","%"+searchMap.get("userName")+"%");
            }

            // 评论人id
            if(searchMap.get("userId")!=null ){
                criteria.andEqualTo("userId",searchMap.get("userId"));
            }

        }
        return example;
    }

}
