package com.community.service.content;

import com.community.entity.PageResult;
import com.community.pojo.content.ArticleType;

import java.util.List;
import java.util.Map;

/**
 * articleType业务逻辑层
 */
public interface ArticleTypeService {

    public List<ArticleType> findAll();


    public PageResult<ArticleType> findPage(int page, int size);


    public List<ArticleType> findList(Map<String,Object> searchMap);


    public PageResult<ArticleType> findPage(Map<String,Object> searchMap,int page, int size);


    public ArticleType findById(Long article_type_id);

    public void add(ArticleType articleType);


    public void update(ArticleType articleType);


    public void delete(Long article_type_id);


}
