package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.DeptMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.Dept;
import com.community.service.system.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Dept> findAll() {
        return deptMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Dept> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Dept> depts = (Page<Dept>) deptMapper.selectAll();
        return new PageResult<Dept>(depts.getTotal(),depts.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Dept> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return deptMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Dept> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Dept> depts = (Page<Dept>) deptMapper.selectByExample(example);
        return new PageResult<Dept>(depts.getTotal(),depts.getResult());
    }

    /**
     * 根据Id查询
     * @param dept_id
     * @return
     */
    public Dept findById(Long deptId) {
        return deptMapper.selectByPrimaryKey(deptId);
    }

    /**
     * 新增
     * @param dept
     */
    public void add(Dept dept) {
        deptMapper.insert(dept);
    }

    /**
     * 修改
     * @param dept
     */
    public void update(Dept dept) {
        deptMapper.updateByPrimaryKeySelective(dept);
    }

    /**
     *  删除
     * @param dept_id
     */
    public void delete(Long deptId) {
        deptMapper.deleteByPrimaryKey(deptId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Dept.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 父级ids
            if(searchMap.get("pids")!=null && !"".equals(searchMap.get("pids"))){
                criteria.andLike("pids","%"+searchMap.get("pids")+"%");
            }
            // 部门名称
            if(searchMap.get("deptName")!=null && !"".equals(searchMap.get("deptName"))){
                criteria.andLike("deptName","%"+searchMap.get("deptName")+"%");
            }
            // 描述
            if(searchMap.get("description")!=null && !"".equals(searchMap.get("description"))){
                criteria.andLike("description","%"+searchMap.get("description")+"%");
            }
            // 负责人
            if(searchMap.get("leader")!=null && !"".equals(searchMap.get("leader"))){
                criteria.andLike("leader","%"+searchMap.get("leader")+"%");
            }
            // 联系电话
            if(searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))){
                criteria.andLike("phone","%"+searchMap.get("phone")+"%");
            }
            // 部门状态 (字典)
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }
            // 是否删除（字典）
            if(searchMap.get("delFlag")!=null && !"".equals(searchMap.get("delFlag"))){
                criteria.andLike("delFlag","%"+searchMap.get("delFlag")+"%");
            }

            // 版本（乐观锁保留字段）
            if(searchMap.get("version")!=null ){
                criteria.andEqualTo("version",searchMap.get("version"));
            }
            // 排序
            if(searchMap.get("sort")!=null ){
                criteria.andEqualTo("sort",searchMap.get("sort"));
            }

        }
        return example;
    }

}
