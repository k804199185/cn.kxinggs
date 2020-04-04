package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.Notice;

import java.util.*;

/**
 * notice业务逻辑层
 */
public interface NoticeService {


    public List<Notice> findAll();


    public PageResult<Notice> findPage(int page, int size);


    public List<Notice> findList(Map<String,Object> searchMap);


    public PageResult<Notice> findPage(Map<String,Object> searchMap,int page, int size);


    public Notice findById(Long notice_id);

    public void add(Notice notice);


    public void update(Notice notice);


    public void delete(Long notice_id);

}
