package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.UserPost;

import java.util.*;

/**
 * userPost业务逻辑层
 */
public interface UserPostService {


    public List<UserPost> findAll();


    public PageResult<UserPost> findPage(int page, int size);


    public List<UserPost> findList(Map<String,Object> searchMap);


    public PageResult<UserPost> findPage(Map<String,Object> searchMap,int page, int size);


    public UserPost findById(Long user_pos_id);

    public void add(UserPost userPost);


    public void update(UserPost userPost);


    public void delete(Long user_pos_id);

}
