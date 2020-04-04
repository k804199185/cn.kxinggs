package com.community.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.community.dao.ArticleTypeMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.ArticleType;
import com.community.service.content.ArticleTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public List<ArticleType> findAll() {
        return articleTypeMapper.selectAll();
    }

    @Override
    public PageResult<ArticleType> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<ArticleType> articleTypes = (Page<ArticleType>) articleTypeMapper.selectAll();
        return new PageResult<ArticleType>(articleTypes.getTotal(), articleTypes.getResult());
    }

    @Override
    public List<ArticleType> findList(Map<String, Object> searchMap) {
        return null;
    }

    @Override
    public PageResult<ArticleType> findPage(Map<String, Object> searchMap, int page, int size) {
        return null;
    }

    @Override
    public ArticleType findById(Long article_type_id) {
        return null;
    }

    @Override
    public void add(ArticleType articleType) {

    }

    @Override
    public void update(ArticleType articleType) {

    }

    @Override
    public void delete(Long article_type_id) {

    }

}
