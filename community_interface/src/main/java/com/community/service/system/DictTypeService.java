package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.DictType;

import java.util.*;

/**
 * dictType业务逻辑层
 */
public interface DictTypeService {


    public List<DictType> findAll();


    public PageResult<DictType> findPage(int page, int size);


    public List<DictType> findList(Map<String,Object> searchMap);


    public PageResult<DictType> findPage(Map<String,Object> searchMap,int page, int size);


    public DictType findById(Long dict_type_id);

    public void add(DictType dictType);


    public void update(DictType dictType);


    public void delete(Long dict_type_id);

}
