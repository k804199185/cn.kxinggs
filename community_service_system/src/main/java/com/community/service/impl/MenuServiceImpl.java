package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.MenuMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.Menu;
import com.community.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Menu> findAll() {
        return menuMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Menu> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Menu> menus = (Page<Menu>) menuMapper.selectAll();
        return new PageResult<Menu>(menus.getTotal(),menus.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Menu> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return menuMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Menu> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Menu> menus = (Page<Menu>) menuMapper.selectByExample(example);
        return new PageResult<Menu>(menus.getTotal(),menus.getResult());
    }

    /**
     * 根据Id查询
     * @param menu_id
     * @return
     */
    public Menu findById(Long menuId) {
        return menuMapper.selectByPrimaryKey(menuId);
    }

    /**
     * 新增
     * @param menu
     */
    public void add(Menu menu) {
        menuMapper.insert(menu);
    }

    /**
     * 修改
     * @param menu
     */
    public void update(Menu menu) {
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    /**
     *  删除
     * @param menu_id
     */
    public void delete(Long menuId) {
        menuMapper.deleteByPrimaryKey(menuId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 菜单编号
            if(searchMap.get("code")!=null && !"".equals(searchMap.get("code"))){
                criteria.andLike("code","%"+searchMap.get("code")+"%");
            }
            // 菜单父编号
            if(searchMap.get("pcode")!=null && !"".equals(searchMap.get("pcode"))){
                criteria.andLike("pcode","%"+searchMap.get("pcode")+"%");
            }
            // 当前菜单的所有父菜单编号
            if(searchMap.get("pcodes")!=null && !"".equals(searchMap.get("pcodes"))){
                criteria.andLike("pcodes","%"+searchMap.get("pcodes")+"%");
            }
            // 菜单名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 菜单图标
            if(searchMap.get("icon")!=null && !"".equals(searchMap.get("icon"))){
                criteria.andLike("icon","%"+searchMap.get("icon")+"%");
            }
            // url地址
            if(searchMap.get("url")!=null && !"".equals(searchMap.get("url"))){
                criteria.andLike("url","%"+searchMap.get("url")+"%");
            }
            // 是否是菜单(字典)
            if(searchMap.get("menuFlag")!=null && !"".equals(searchMap.get("menuFlag"))){
                criteria.andLike("menuFlag","%"+searchMap.get("menuFlag")+"%");
            }
            // 备注
            if(searchMap.get("description")!=null && !"".equals(searchMap.get("description"))){
                criteria.andLike("description","%"+searchMap.get("description")+"%");
            }
            // 菜单状态(字典)
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }
            // 是否打开新页面的标识(字典)
            if(searchMap.get("newPageFlag")!=null && !"".equals(searchMap.get("newPageFlag"))){
                criteria.andLike("newPageFlag","%"+searchMap.get("newPageFlag")+"%");
            }
            // 是否打开(字典)
            if(searchMap.get("openFlag")!=null && !"".equals(searchMap.get("openFlag"))){
                criteria.andLike("openFlag","%"+searchMap.get("openFlag")+"%");
            }
            // 系统分类(字典)
            if(searchMap.get("systemType")!=null && !"".equals(searchMap.get("systemType"))){
                criteria.andLike("systemType","%"+searchMap.get("systemType")+"%");
            }
            // 是否删除（字典）
            if(searchMap.get("delFlag")!=null && !"".equals(searchMap.get("delFlag"))){
                criteria.andLike("delFlag","%"+searchMap.get("delFlag")+"%");
            }

            // 菜单排序号
            if(searchMap.get("sort")!=null ){
                criteria.andEqualTo("sort",searchMap.get("sort"));
            }
            // 菜单层级
            if(searchMap.get("levels")!=null ){
                criteria.andEqualTo("levels",searchMap.get("levels"));
            }

        }
        return example;
    }

}
