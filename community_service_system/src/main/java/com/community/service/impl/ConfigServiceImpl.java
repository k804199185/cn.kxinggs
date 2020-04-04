package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.ConfigMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.Config;
import com.community.service.system.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Config> findAll() {
        return configMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Config> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Config> configs = (Page<Config>) configMapper.selectAll();
        return new PageResult<Config>(configs.getTotal(),configs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Config> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return configMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Config> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Config> configs = (Page<Config>) configMapper.selectByExample(example);
        return new PageResult<Config>(configs.getTotal(),configs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Config findById(Long id) {
        return configMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param config
     */
    public void add(Config config) {
        configMapper.insert(config);
    }

    /**
     * 修改
     * @param config
     */
    public void update(Config config) {
        configMapper.updateByPrimaryKeySelective(config);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Long id) {
        configMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Config.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 属性编码标识
            if(searchMap.get("code")!=null && !"".equals(searchMap.get("code"))){
                criteria.andLike("code","%"+searchMap.get("code")+"%");
            }
            // 是否是字典中的值
            if(searchMap.get("dictFlag")!=null && !"".equals(searchMap.get("dictFlag"))){
                criteria.andLike("dictFlag","%"+searchMap.get("dictFlag")+"%");
            }
            // 属性值，如果是字典中的类型，则为dict的code
            if(searchMap.get("value")!=null && !"".equals(searchMap.get("value"))){
                criteria.andLike("value","%"+searchMap.get("value")+"%");
            }
            // 备注
            if(searchMap.get("remark")!=null && !"".equals(searchMap.get("remark"))){
                criteria.andLike("remark","%"+searchMap.get("remark")+"%");
            }


        }
        return example;
    }

}
