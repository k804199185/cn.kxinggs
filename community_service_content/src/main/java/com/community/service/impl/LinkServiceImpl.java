package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.LinkMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.Link;
import com.community.service.content.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Link> findAll() {
        return linkMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Link> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Link> links = (Page<Link>) linkMapper.selectAll();
        return new PageResult<Link>(links.getTotal(),links.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Link> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return linkMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Link> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Link> links = (Page<Link>) linkMapper.selectByExample(example);
        return new PageResult<Link>(links.getTotal(),links.getResult());
    }

    /**
     * 根据Id查询
     * @param link_id
     * @return
     */
    public Link findById(Long linkId) {
        return linkMapper.selectByPrimaryKey(linkId);
    }

    /**
     * 新增
     * @param link
     */
    public void add(Link link) {
        linkMapper.insert(link);
    }

    /**
     * 修改
     * @param link
     */
    public void update(Link link) {
        linkMapper.updateByPrimaryKeySelective(link);
    }

    /**
     *  删除
     * @param link_id
     */
    public void delete(Long linkId) {
        linkMapper.deleteByPrimaryKey(linkId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Link.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 链接地址
            if(searchMap.get("linkAddr")!=null && !"".equals(searchMap.get("linkAddr"))){
                criteria.andLike("linkAddr","%"+searchMap.get("linkAddr")+"%");
            }
            // 链接标题
            if(searchMap.get("linkTitle")!=null && !"".equals(searchMap.get("linkTitle"))){
                criteria.andLike("linkTitle","%"+searchMap.get("linkTitle")+"%");
            }


        }
        return example;
    }

}
