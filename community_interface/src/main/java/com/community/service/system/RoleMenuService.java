package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.RoleMenu;

import java.util.*;

/**
 * roleMenu业务逻辑层
 */
public interface RoleMenuService {


    public List<RoleMenu> findAll();


    public PageResult<RoleMenu> findPage(int page, int size);


    public List<RoleMenu> findList(Map<String,Object> searchMap);


    public PageResult<RoleMenu> findPage(Map<String,Object> searchMap,int page, int size);


    public RoleMenu findById(Long relation_id);

    public void add(RoleMenu roleMenu);


    public void update(RoleMenu roleMenu);


    public void delete(Long relation_id);

}
