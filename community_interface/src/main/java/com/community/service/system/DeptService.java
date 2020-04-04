package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.Dept;

import java.util.*;

/**
 * dept业务逻辑层
 */
public interface DeptService {


    public List<Dept> findAll();


    public PageResult<Dept> findPage(int page, int size);


    public List<Dept> findList(Map<String,Object> searchMap);


    public PageResult<Dept> findPage(Map<String,Object> searchMap,int page, int size);


    public Dept findById(Long dept_id);

    public void add(Dept dept);


    public void update(Dept dept);


    public void delete(Long dept_id);

}
