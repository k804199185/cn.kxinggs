package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.LoginLog;

import java.util.*;

/**
 * loginLog业务逻辑层
 */
public interface LoginLogService {


    public List<LoginLog> findAll();


    public PageResult<LoginLog> findPage(int page, int size);


    public List<LoginLog> findList(Map<String,Object> searchMap);


    public PageResult<LoginLog> findPage(Map<String,Object> searchMap,int page, int size);


    public LoginLog findById(Long login_log_id);

    public void add(LoginLog loginLog);


    public void update(LoginLog loginLog);


    public void delete(Long login_log_id);

}
