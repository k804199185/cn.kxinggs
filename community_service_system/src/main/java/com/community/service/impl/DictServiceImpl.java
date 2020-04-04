package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.DictMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.Dict;
import com.community.service.system.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Dict> findAll() {
        return dictMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Dict> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Dict> dicts = (Page<Dict>) dictMapper.selectAll();
        return new PageResult<Dict>(dicts.getTotal(),dicts.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Dict> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return dictMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Dict> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Dict> dicts = (Page<Dict>) dictMapper.selectByExample(example);
        return new PageResult<Dict>(dicts.getTotal(),dicts.getResult());
    }

    /**
     * 根据Id查询
     * @param dict_id
     * @return
     */
    public Dict findById(Long dictId) {
        return dictMapper.selectByPrimaryKey(dictId);
    }

    /**
     * 新增
     * @param dict
     */
    public void add(Dict dict) {
        dictMapper.insert(dict);
    }

    /**
     * 修改
     * @param dict
     */
    public void update(Dict dict) {
        dictMapper.updateByPrimaryKeySelective(dict);
    }

    /**
     *  删除
     * @param dict_id
     */
    public void delete(Long dictId) {
        dictMapper.deleteByPrimaryKey(dictId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Dict.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 字典编码
            if(searchMap.get("code")!=null && !"".equals(searchMap.get("code"))){
                criteria.andLike("code","%"+searchMap.get("code")+"%");
            }
            // 字典名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 所有上级id
            if(searchMap.get("parentIds")!=null && !"".equals(searchMap.get("parentIds"))){
                criteria.andLike("parentIds","%"+searchMap.get("parentIds")+"%");
            }
            // 状态（字典）
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }
            // 字典的描述
            if(searchMap.get("description")!=null && !"".equals(searchMap.get("description"))){
                criteria.andLike("description","%"+searchMap.get("description")+"%");
            }

            // 排序
            if(searchMap.get("sort")!=null ){
                criteria.andEqualTo("sort",searchMap.get("sort"));
            }

        }
        return example;
    }

}
