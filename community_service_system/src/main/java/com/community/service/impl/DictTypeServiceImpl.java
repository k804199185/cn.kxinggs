package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.DictTypeMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.DictType;
import com.community.service.system.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class DictTypeServiceImpl implements DictTypeService {

    @Autowired
    private DictTypeMapper dictTypeMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<DictType> findAll() {
        return dictTypeMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<DictType> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<DictType> dictTypes = (Page<DictType>) dictTypeMapper.selectAll();
        return new PageResult<DictType>(dictTypes.getTotal(),dictTypes.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<DictType> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return dictTypeMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<DictType> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<DictType> dictTypes = (Page<DictType>) dictTypeMapper.selectByExample(example);
        return new PageResult<DictType>(dictTypes.getTotal(),dictTypes.getResult());
    }

    /**
     * 根据Id查询
     * @param dict_type_id
     * @return
     */
    public DictType findById(Long dictTypeId) {
        return dictTypeMapper.selectByPrimaryKey(dictTypeId);
    }

    /**
     * 新增
     * @param dictType
     */
    public void add(DictType dictType) {
        dictTypeMapper.insert(dictType);
    }

    /**
     * 修改
     * @param dictType
     */
    public void update(DictType dictType) {
        dictTypeMapper.updateByPrimaryKeySelective(dictType);
    }

    /**
     *  删除
     * @param dict_type_id
     */
    public void delete(Long dictTypeId) {
        dictTypeMapper.deleteByPrimaryKey(dictTypeId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(DictType.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 字典类型编码
            if(searchMap.get("code")!=null && !"".equals(searchMap.get("code"))){
                criteria.andLike("code","%"+searchMap.get("code")+"%");
            }
            // 字典类型名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 字典描述
            if(searchMap.get("description")!=null && !"".equals(searchMap.get("description"))){
                criteria.andLike("description","%"+searchMap.get("description")+"%");
            }
            // 是否是系统字典，Y-是，N-否
            if(searchMap.get("systemFlag")!=null && !"".equals(searchMap.get("systemFlag"))){
                criteria.andLike("systemFlag","%"+searchMap.get("systemFlag")+"%");
            }
            // 状态(字典)
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }

            // 排序
            if(searchMap.get("sort")!=null ){
                criteria.andEqualTo("sort",searchMap.get("sort"));
            }

        }
        return example;
    }

}
