package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.NewsMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.News;
import com.community.service.content.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<News> findAll() {
        return newsMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<News> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<News> newss = (Page<News>) newsMapper.selectAll();
        return new PageResult<News>(newss.getTotal(),newss.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<News> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return newsMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<News> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<News> newss = (Page<News>) newsMapper.selectByExample(example);
        return new PageResult<News>(newss.getTotal(),newss.getResult());
    }

    /**
     * 根据Id查询
     * @param new_id
     * @return
     */
    public News findById(Long newId) {
        return newsMapper.selectByPrimaryKey(newId);
    }

    /**
     * 新增
     * @param news
     */
    public void add(News news) {
        newsMapper.insert(news);
    }

    /**
     * 修改
     * @param news
     */
    public void update(News news) {
        newsMapper.updateByPrimaryKeySelective(news);
    }

    /**
     *  删除
     * @param new_id
     */
    public void delete(Long newId) {
        newsMapper.deleteByPrimaryKey(newId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(News.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 标题
            if(searchMap.get("newTitle")!=null && !"".equals(searchMap.get("newTitle"))){
                criteria.andLike("newTitle","%"+searchMap.get("newTitle")+"%");
            }
            // 内容
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }
            // 来源，可以是部门或其他转载
            if(searchMap.get("source")!=null && !"".equals(searchMap.get("source"))){
                criteria.andLike("source","%"+searchMap.get("source")+"%");
            }
            // 配图路径
            if(searchMap.get("imgUrl")!=null && !"".equals(searchMap.get("imgUrl"))){
                criteria.andLike("imgUrl","%"+searchMap.get("imgUrl")+"%");
            }

            // 评论数
            if(searchMap.get("commentCount")!=null ){
                criteria.andEqualTo("commentCount",searchMap.get("commentCount"));
            }
            // 0为未审核，1为审核
            if(searchMap.get("status")!=null ){
                criteria.andEqualTo("status",searchMap.get("status"));
            }

        }
        return example;
    }

}
