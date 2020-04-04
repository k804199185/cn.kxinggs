package com.community.service.content;
import com.community.entity.PageResult;
import com.community.pojo.content.Link;

import java.util.*;

/**
 * link业务逻辑层
 */
public interface LinkService {


    public List<Link> findAll();


    public PageResult<Link> findPage(int page, int size);


    public List<Link> findList(Map<String,Object> searchMap);


    public PageResult<Link> findPage(Map<String,Object> searchMap,int page, int size);


    public Link findById(Long link_id);

    public void add(Link link);


    public void update(Link link);


    public void delete(Long link_id);

}
