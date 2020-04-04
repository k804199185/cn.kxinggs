package com.community.service.content;
import com.community.entity.PageResult;
import com.community.pojo.content.Ad;

import java.util.*;

/**
 * ad业务逻辑层
 */
public interface AdService {


    public List<Ad> findAll();


    public PageResult<Ad> findPage(int page, int size);


    public List<Ad> findList(Map<String,Object> searchMap);


    public PageResult<Ad> findPage(Map<String,Object> searchMap,int page, int size);


    public Ad findById(Long ad_id);

    public void add(Ad ad);


    public void update(Ad ad);


    public void delete(Long ad_id);

}
