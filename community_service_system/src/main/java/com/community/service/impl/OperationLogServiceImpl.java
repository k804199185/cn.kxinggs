package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.OperationLogMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.OperationLog;
import com.community.service.system.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<OperationLog> findAll() {
        return operationLogMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<OperationLog> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<OperationLog> operationLogs = (Page<OperationLog>) operationLogMapper.selectAll();
        return new PageResult<OperationLog>(operationLogs.getTotal(),operationLogs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<OperationLog> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return operationLogMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<OperationLog> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<OperationLog> operationLogs = (Page<OperationLog>) operationLogMapper.selectByExample(example);
        return new PageResult<OperationLog>(operationLogs.getTotal(),operationLogs.getResult());
    }

    /**
     * 根据Id查询
     * @param operation_log_id
     * @return
     */
    public OperationLog findById(Long operationLogId) {
        return operationLogMapper.selectByPrimaryKey(operationLogId);
    }

    /**
     * 新增
     * @param operationLog
     */
    public void add(OperationLog operationLog) {
        operationLogMapper.insert(operationLog);
    }

    /**
     * 修改
     * @param operationLog
     */
    public void update(OperationLog operationLog) {
        operationLogMapper.updateByPrimaryKeySelective(operationLog);
    }

    /**
     *  删除
     * @param operation_log_id
     */
    public void delete(Long operationLogId) {
        operationLogMapper.deleteByPrimaryKey(operationLogId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(OperationLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 日志类型(字典)
            if(searchMap.get("logType")!=null && !"".equals(searchMap.get("logType"))){
                criteria.andLike("logType","%"+searchMap.get("logType")+"%");
            }
            // 日志名称
            if(searchMap.get("logName")!=null && !"".equals(searchMap.get("logName"))){
                criteria.andLike("logName","%"+searchMap.get("logName")+"%");
            }
            // 类名称
            if(searchMap.get("className")!=null && !"".equals(searchMap.get("className"))){
                criteria.andLike("className","%"+searchMap.get("className")+"%");
            }
            // 方法名称
            if(searchMap.get("method")!=null && !"".equals(searchMap.get("method"))){
                criteria.andLike("method","%"+searchMap.get("method")+"%");
            }
            // 是否成功(字典)
            if(searchMap.get("succeed")!=null && !"".equals(searchMap.get("succeed"))){
                criteria.andLike("succeed","%"+searchMap.get("succeed")+"%");
            }
            // 备注
            if(searchMap.get("message")!=null && !"".equals(searchMap.get("message"))){
                criteria.andLike("message","%"+searchMap.get("message")+"%");
            }


        }
        return example;
    }

}
