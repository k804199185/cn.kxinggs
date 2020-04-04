package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.LoginLogMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.LoginLog;
import com.community.service.system.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<LoginLog> findAll() {
        return loginLogMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<LoginLog> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<LoginLog> loginLogs = (Page<LoginLog>) loginLogMapper.selectAll();
        return new PageResult<LoginLog>(loginLogs.getTotal(),loginLogs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<LoginLog> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return loginLogMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<LoginLog> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<LoginLog> loginLogs = (Page<LoginLog>) loginLogMapper.selectByExample(example);
        return new PageResult<LoginLog>(loginLogs.getTotal(),loginLogs.getResult());
    }

    /**
     * 根据Id查询
     * @param login_log_id
     * @return
     */
    public LoginLog findById(Long loginLogId) {
        return loginLogMapper.selectByPrimaryKey(loginLogId);
    }

    /**
     * 新增
     * @param loginLog
     */
    public void add(LoginLog loginLog) {
        loginLogMapper.insert(loginLog);
    }

    /**
     * 修改
     * @param loginLog
     */
    public void update(LoginLog loginLog) {
        loginLogMapper.updateByPrimaryKeySelective(loginLog);
    }

    /**
     *  删除
     * @param login_log_id
     */
    public void delete(Long loginLogId) {
        loginLogMapper.deleteByPrimaryKey(loginLogId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(LoginLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 日志名称
            if(searchMap.get("logName")!=null && !"".equals(searchMap.get("logName"))){
                criteria.andLike("logName","%"+searchMap.get("logName")+"%");
            }
            // 登录状态（0成功 1失败）
            if(searchMap.get("succeed")!=null && !"".equals(searchMap.get("succeed"))){
                criteria.andLike("succeed","%"+searchMap.get("succeed")+"%");
            }
            // 具体消息
            if(searchMap.get("message")!=null && !"".equals(searchMap.get("message"))){
                criteria.andLike("message","%"+searchMap.get("message")+"%");
            }
            // 登录ip
            if(searchMap.get("ipAddress")!=null && !"".equals(searchMap.get("ipAddress"))){
                criteria.andLike("ipAddress","%"+searchMap.get("ipAddress")+"%");
            }
            // 登录地点
            if(searchMap.get("loginLocation")!=null && !"".equals(searchMap.get("loginLocation"))){
                criteria.andLike("loginLocation","%"+searchMap.get("loginLocation")+"%");
            }
            // 浏览器类型
            if(searchMap.get("browser")!=null && !"".equals(searchMap.get("browser"))){
                criteria.andLike("browser","%"+searchMap.get("browser")+"%");
            }


        }
        return example;
    }

}
