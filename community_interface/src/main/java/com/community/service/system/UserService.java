package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.User;
import com.community.pojo.system.UserUnitPost;

import java.util.*;

/**
 * user业务逻辑层
 */
public interface UserService {


    public List<User> findAll();


    public PageResult<User> findPage(int page, int size);


    public List<User> findList(Map<String,Object> searchMap);


    public PageResult<User> findPage(Map<String,Object> searchMap,int page, int size);


    public User findById(Long user_id);

    public void update(User user);



    public int updateUserUnitPost(UserUnitPost userUnitPost);

    public int add(UserUnitPost userUnitPost);

    public UserUnitPost findByUserUnitPostId(Long id);

    public int isDelete(Long userId);

    public int delete(Long user_id);

    public int deleteUsers(Long[] ids);

    public int updateStatus(Long userId);

}
