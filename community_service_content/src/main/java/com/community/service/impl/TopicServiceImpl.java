package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.TopicMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.Topic;
import com.community.service.content.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Topic> findAll() {
        return topicMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Topic> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Topic> topics = (Page<Topic>) topicMapper.selectAll();
        return new PageResult<Topic>(topics.getTotal(),topics.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Topic> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return topicMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Topic> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Topic> topics = (Page<Topic>) topicMapper.selectByExample(example);
        return new PageResult<Topic>(topics.getTotal(),topics.getResult());
    }

    /**
     * 根据Id查询
     * @param tid
     * @return
     */
    public Topic findById(Long tid) {
        return topicMapper.selectByPrimaryKey(tid);
    }

    /**
     * 新增
     * @param topic
     */
    public void add(Topic topic) {
        topicMapper.insert(topic);
    }

    /**
     * 修改
     * @param topic
     */
    public void update(Topic topic) {
        topicMapper.updateByPrimaryKeySelective(topic);
    }

    /**
     *  删除
     * @param tid
     */
    public void delete(Long tid) {
        topicMapper.deleteByPrimaryKey(tid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Topic.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 版块名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 删除标志 0 正常 1删除
            if(searchMap.get("delFlag")!=null && !"".equals(searchMap.get("delFlag"))){
                criteria.andLike("delFlag","%"+searchMap.get("delFlag")+"%");
            }
            // 版块内容(描述)
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }
            // 图片
            if(searchMap.get("image")!=null && !"".equals(searchMap.get("image"))){
                criteria.andLike("image","%"+searchMap.get("image")+"%");
            }


        }
        return example;
    }

}
