package com.community.service.content;
import com.community.entity.PageResult;
import com.community.pojo.content.Comment;

import java.util.*;

/**
 * comment业务逻辑层
 */
public interface CommentService {


    public List<Comment> findAll();


    public PageResult<Comment> findPage(int page, int size);


    public List<Comment> findList(Map<String,Object> searchMap);


    public PageResult<Comment> findPage(Map<String,Object> searchMap,int page, int size);


    public Comment findById(Long tiezi_comment_id);

    public void add(Comment comment);


    public void update(Comment comment);


    public void delete(Long tiezi_comment_id);

}
