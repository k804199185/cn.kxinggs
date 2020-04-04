package com.community.service.content;
import com.community.entity.PageResult;
import com.community.pojo.content.CommentReply;

import java.util.*;

/**
 * commentReply业务逻辑层
 */
public interface CommentReplyService {


    public List<CommentReply> findAll();


    public PageResult<CommentReply> findPage(int page, int size);


    public List<CommentReply> findList(Map<String,Object> searchMap);


    public PageResult<CommentReply> findPage(Map<String,Object> searchMap,int page, int size);


    public CommentReply findById(Long comment_reply_id);

    public void add(CommentReply commentReply);


    public void update(CommentReply commentReply);


    public void delete(Long comment_reply_id);

}
