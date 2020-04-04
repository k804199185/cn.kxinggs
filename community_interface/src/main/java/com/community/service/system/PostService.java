package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.Post;

import java.util.*;

/**
 * post业务逻辑层
 */
public interface PostService {


    public List<Post> findAll();


    public PageResult<Post> findPage(int page, int size);


    public List<Post> findList(Map<String,Object> searchMap);


    public PageResult<Post> findPage(Map<String,Object> searchMap,int page, int size);


    public Post findById(Long post_id);

    public void add(Post post);


    public void update(Post post);


    public void delete(Long post_id);

}
