package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.Dict;

import java.util.*;

/**
 * dict业务逻辑层
 */
public interface DictService {


    public List<Dict> findAll();


    public PageResult<Dict> findPage(int page, int size);


    public List<Dict> findList(Map<String,Object> searchMap);


    public PageResult<Dict> findPage(Map<String,Object> searchMap,int page, int size);


    public Dict findById(Long dict_id);

    public void add(Dict dict);


    public void update(Dict dict);


    public void delete(Long dict_id);

}
