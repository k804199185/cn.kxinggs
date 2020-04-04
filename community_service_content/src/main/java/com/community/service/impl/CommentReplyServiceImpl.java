package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.CommentReplyMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.CommentReply;
import com.community.service.content.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {

    @Autowired
    private CommentReplyMapper commentReplyMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<CommentReply> findAll() {
        return commentReplyMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<CommentReply> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<CommentReply> commentReplys = (Page<CommentReply>) commentReplyMapper.selectAll();
        return new PageResult<CommentReply>(commentReplys.getTotal(),commentReplys.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<CommentReply> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return commentReplyMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<CommentReply> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<CommentReply> commentReplys = (Page<CommentReply>) commentReplyMapper.selectByExample(example);
        return new PageResult<CommentReply>(commentReplys.getTotal(),commentReplys.getResult());
    }

    /**
     * 根据Id查询
     * @param comment_reply_id
     * @return
     */
    public CommentReply findById(Long commentReplyId) {
        return commentReplyMapper.selectByPrimaryKey(commentReplyId);
    }

    /**
     * 新增
     * @param commentReply
     */
    public void add(CommentReply commentReply) {
        commentReplyMapper.insert(commentReply);
    }

    /**
     * 修改
     * @param commentReply
     */
    public void update(CommentReply commentReply) {
        commentReplyMapper.updateByPrimaryKeySelective(commentReply);
    }

    /**
     *  删除
     * @param comment_reply_id
     */
    public void delete(Long commentReplyId) {
        commentReplyMapper.deleteByPrimaryKey(commentReplyId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(CommentReply.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 回复人头像
            if(searchMap.get("userAvatar")!=null && !"".equals(searchMap.get("userAvatar"))){
                criteria.andLike("userAvatar","%"+searchMap.get("userAvatar")+"%");
            }
            // 回复人名称
            if(searchMap.get("userName")!=null && !"".equals(searchMap.get("userName"))){
                criteria.andLike("userName","%"+searchMap.get("userName")+"%");
            }
            // 回复内容
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }


        }
        return example;
    }

}
