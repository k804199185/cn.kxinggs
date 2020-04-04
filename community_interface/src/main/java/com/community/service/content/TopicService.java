package com.community.service.content;
import com.community.entity.PageResult;
import com.community.pojo.content.Topic;

import java.util.*;

/**
 * topic业务逻辑层
 */
public interface TopicService {


    public List<Topic> findAll();


    public PageResult<Topic> findPage(int page, int size);


    public List<Topic> findList(Map<String,Object> searchMap);


    public PageResult<Topic> findPage(Map<String,Object> searchMap,int page, int size);


    public Topic findById(Long tid);

    public void add(Topic topic);


    public void update(Topic topic);


    public void delete(Long tid);

}
