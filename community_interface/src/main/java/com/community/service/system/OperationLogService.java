package com.community.service.system;
import com.community.entity.PageResult;
import com.community.pojo.system.OperationLog;

import java.util.*;

/**
 * operationLog业务逻辑层
 */
public interface OperationLogService {


    public List<OperationLog> findAll();


    public PageResult<OperationLog> findPage(int page, int size);


    public List<OperationLog> findList(Map<String,Object> searchMap);


    public PageResult<OperationLog> findPage(Map<String,Object> searchMap,int page, int size);


    public OperationLog findById(Long operation_log_id);

    public void add(OperationLog operationLog);


    public void update(OperationLog operationLog);


    public void delete(Long operation_log_id);

}
