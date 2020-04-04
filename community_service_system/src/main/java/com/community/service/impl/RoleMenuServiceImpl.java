package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.RoleMenuMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.RoleMenu;
import com.community.service.system.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<RoleMenu> findAll() {
        return roleMenuMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<RoleMenu> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<RoleMenu> roleMenus = (Page<RoleMenu>) roleMenuMapper.selectAll();
        return new PageResult<RoleMenu>(roleMenus.getTotal(),roleMenus.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<RoleMenu> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return roleMenuMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<RoleMenu> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<RoleMenu> roleMenus = (Page<RoleMenu>) roleMenuMapper.selectByExample(example);
        return new PageResult<RoleMenu>(roleMenus.getTotal(),roleMenus.getResult());
    }

    /**
     * 根据Id查询
     * @param relation_id
     * @return
     */
    public RoleMenu findById(Long relationId) {
        return roleMenuMapper.selectByPrimaryKey(relationId);
    }

    /**
     * 新增
     * @param roleMenu
     */
    public void add(RoleMenu roleMenu) {
        roleMenuMapper.insert(roleMenu);
    }

    /**
     * 修改
     * @param roleMenu
     */
    public void update(RoleMenu roleMenu) {
        roleMenuMapper.updateByPrimaryKeySelective(roleMenu);
    }

    /**
     *  删除
     * @param relation_id
     */
    public void delete(Long relationId) {
        roleMenuMapper.deleteByPrimaryKey(relationId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(RoleMenu.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){


        }
        return example;
    }

}
