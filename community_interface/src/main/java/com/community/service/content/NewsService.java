package com.community.service.content;
import com.community.entity.PageResult;
import com.community.pojo.content.News;

import java.util.*;

/**
 * news业务逻辑层
 */
public interface NewsService {


    public List<News> findAll();


    public PageResult<News> findPage(int page, int size);


    public List<News> findList(Map<String,Object> searchMap);


    public PageResult<News> findPage(Map<String,Object> searchMap,int page, int size);


    public News findById(Long new_id);

    public void add(News news);


    public void update(News news);


    public void delete(Long new_id);

}
