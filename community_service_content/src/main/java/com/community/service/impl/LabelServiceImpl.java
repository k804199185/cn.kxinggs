package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.LabelMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.Label;
import com.community.service.content.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Label> findAll() {
        return labelMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Label> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Label> labels = (Page<Label>) labelMapper.selectAll();
        return new PageResult<Label>(labels.getTotal(),labels.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Label> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return labelMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Label> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Label> labels = (Page<Label>) labelMapper.selectByExample(example);
        return new PageResult<Label>(labels.getTotal(),labels.getResult());
    }

    /**
     * 根据Id查询
     * @param label_id
     * @return
     */
    public Label findById(Long labelId) {
        return labelMapper.selectByPrimaryKey(labelId);
    }

    /**
     * 新增
     * @param label
     */
    public void add(Label label) {
        labelMapper.insert(label);
    }

    /**
     * 修改
     * @param label
     */
    public void update(Label label) {
        labelMapper.updateByPrimaryKeySelective(label);
    }

    /**
     *  删除
     * @param label_id
     */
    public void delete(Long labelId) {
        labelMapper.deleteByPrimaryKey(labelId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Label.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 标签名称
            if(searchMap.get("labelName")!=null && !"".equals(searchMap.get("labelName"))){
                criteria.andLike("labelName","%"+searchMap.get("labelName")+"%");
            }
            // 删除标志 0正常 1 删除(屏蔽)
            if(searchMap.get("delFlag")!=null && !"".equals(searchMap.get("delFlag"))){
                criteria.andLike("delFlag","%"+searchMap.get("delFlag")+"%");
            }


        }
        return example;
    }

}
