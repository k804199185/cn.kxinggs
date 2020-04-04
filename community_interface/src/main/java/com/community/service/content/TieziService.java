package com.community.service.content;
import com.community.entity.PageResult;
import com.community.pojo.content.Tiezi;

import java.util.*;

/**
 * tiezi业务逻辑层
 */
public interface TieziService {


    public List<Tiezi> findAll();


    public PageResult<Tiezi> findPage(int page, int size);


    public List<Tiezi> findList(Map<String,Object> searchMap);


    public PageResult<Tiezi> findPage(Map<String,Object> searchMap,int page, int size);


    public Tiezi findById(Long pid);

    public void add(Tiezi tiezi);


    public void update(Tiezi tiezi);


    public void delete(Long pid);

}
