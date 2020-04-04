package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.FileInfo;

import java.util.*;

/**
 * fileInfo业务逻辑层
 */
public interface FileInfoService {


    public List<FileInfo> findAll();


    public PageResult<FileInfo> findPage(int page, int size);


    public List<FileInfo> findList(Map<String,Object> searchMap);


    public PageResult<FileInfo> findPage(Map<String,Object> searchMap,int page, int size);


    public FileInfo findById(String file_id);

    public void add(FileInfo fileInfo);


    public void update(FileInfo fileInfo);


    public void delete(String file_id);

}
