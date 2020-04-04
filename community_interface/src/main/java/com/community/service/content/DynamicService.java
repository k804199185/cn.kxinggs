package com.community.service.content;
import com.community.entity.PageResult;
import com.community.pojo.content.Dynamic;

import java.util.*;

/**
 * dynamic业务逻辑层
 */
public interface DynamicService {


    public List<Dynamic> findAll();


    public PageResult<Dynamic> findPage(int page, int size);


    public List<Dynamic> findList(Map<String,Object> searchMap);


    public PageResult<Dynamic> findPage(Map<String,Object> searchMap,int page, int size);


    public Dynamic findById(Long dynamic_id);

    public void add(Dynamic dynamic);


    public void update(Dynamic dynamic);


    public void delete(Long dynamic_id);

}
