package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.DynamicMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.Dynamic;
import com.community.service.content.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    private DynamicMapper dynamicMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Dynamic> findAll() {
        return dynamicMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Dynamic> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Dynamic> dynamics = (Page<Dynamic>) dynamicMapper.selectAll();
        return new PageResult<Dynamic>(dynamics.getTotal(),dynamics.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Dynamic> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return dynamicMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Dynamic> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Dynamic> dynamics = (Page<Dynamic>) dynamicMapper.selectByExample(example);
        return new PageResult<Dynamic>(dynamics.getTotal(),dynamics.getResult());
    }

    /**
     * 根据Id查询
     * @param dynamic_id
     * @return
     */
    public Dynamic findById(Long dynamicId) {
        return dynamicMapper.selectByPrimaryKey(dynamicId);
    }

    /**
     * 新增
     * @param dynamic
     */
    public void add(Dynamic dynamic) {
        dynamicMapper.insert(dynamic);
    }

    /**
     * 修改
     * @param dynamic
     */
    public void update(Dynamic dynamic) {
        dynamicMapper.updateByPrimaryKeySelective(dynamic);
    }

    /**
     *  删除
     * @param dynamicId
     */
    public void delete(Long dynamicId) {
        dynamicMapper.deleteByPrimaryKey(dynamicId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Dynamic.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 动态内容
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }
            // 删除标志 0正常 1 删除(屏蔽)
            if(searchMap.get("delFlag")!=null && !"".equals(searchMap.get("delFlag"))){
                criteria.andLike("delFlag","%"+searchMap.get("delFlag")+"%");
            }
            // 当前地址
            if(searchMap.get("area")!=null && !"".equals(searchMap.get("area"))){
                criteria.andLike("area","%"+searchMap.get("area")+"%");
            }
            // 最后回复时间
            if(searchMap.get("lastReplyTime")!=null && !"".equals(searchMap.get("lastReplyTime"))){
                criteria.andLike("lastReplyTime","%"+searchMap.get("lastReplyTime")+"%");
            }
            // 上传图片路径集合
            if(searchMap.get("picList")!=null && !"".equals(searchMap.get("picList"))){
                criteria.andLike("picList","%"+searchMap.get("picList")+"%");
            }
            // 最后回复人
            if(searchMap.get("lastReplyUserName")!=null && !"".equals(searchMap.get("lastReplyUserName"))){
                criteria.andLike("lastReplyUserName","%"+searchMap.get("lastReplyUserName")+"%");
            }

            // 点赞人数
            if(searchMap.get("likeCount")!=null ){
                criteria.andEqualTo("likeCount",searchMap.get("likeCount"));
            }
            // 评论人数
            if(searchMap.get("commentCount")!=null ){
                criteria.andEqualTo("commentCount",searchMap.get("commentCount"));
            }

        }
        return example;
    }

}
