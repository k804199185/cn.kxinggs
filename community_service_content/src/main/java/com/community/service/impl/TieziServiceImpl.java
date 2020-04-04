package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.TieziMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.Tiezi;
import com.community.service.content.TieziService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class TieziServiceImpl implements TieziService {

    @Autowired
    private TieziMapper tieziMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Tiezi> findAll() {
        return tieziMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Tiezi> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Tiezi> tiezis = (Page<Tiezi>) tieziMapper.selectAll();
        return new PageResult<Tiezi>(tiezis.getTotal(),tiezis.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Tiezi> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tieziMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Tiezi> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Tiezi> tiezis = (Page<Tiezi>) tieziMapper.selectByExample(example);
        return new PageResult<Tiezi>(tiezis.getTotal(),tiezis.getResult());
    }

    /**
     * 根据Id查询
     * @param pid
     * @return
     */
    public Tiezi findById(Long pid) {
        return tieziMapper.selectByPrimaryKey(pid);
    }

    /**
     * 新增
     * @param tiezi
     */
    public void add(Tiezi tiezi) {
        tieziMapper.insert(tiezi);
    }

    /**
     * 修改
     * @param tiezi
     */
    public void update(Tiezi tiezi) {
        tieziMapper.updateByPrimaryKeySelective(tiezi);
    }

    /**
     *  删除
     * @param pid
     */
    public void delete(Long pid) {
        tieziMapper.deleteByPrimaryKey(pid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Tiezi.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 帖子标题
            if(searchMap.get("title")!=null && !"".equals(searchMap.get("title"))){
                criteria.andLike("title","%"+searchMap.get("title")+"%");
            }
            // 帖子内容
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }
            // 删除标志 0正常 1 删除(屏蔽)
            if(searchMap.get("delFlag")!=null && !"".equals(searchMap.get("delFlag"))){
                criteria.andLike("delFlag","%"+searchMap.get("delFlag")+"%");
            }

            // 评论数量
            if(searchMap.get("commentCount")!=null ){
                criteria.andEqualTo("commentCount",searchMap.get("commentCount"));
            }
            // 点赞（喜欢）数量
            if(searchMap.get("likeCount")!=null ){
                criteria.andEqualTo("likeCount",searchMap.get("likeCount"));
            }
            // 收藏数量
            if(searchMap.get("scanCount")!=null ){
                criteria.andEqualTo("scanCount",searchMap.get("scanCount"));
            }

        }
        return example;
    }

}
