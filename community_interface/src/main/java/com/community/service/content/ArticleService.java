package com.community.service.content;
import com.community.entity.PageResult;
import com.community.pojo.content.Article;

import java.util.*;

/**
 * article业务逻辑层
 */
public interface ArticleService {


    public List<Article> findAll();


    public PageResult<Article> findPage(int page, int size);


    public List<Article> findList(Map<String,Object> searchMap);


    public PageResult<Article> findPage(Map<String,Object> searchMap,int page, int size);


    public Article findById(Long article_id);

    public void add(Article article);


    public void update(Article article);


    public void delete(Long article_id);


    public void deleteFlag(Long articleId);

}
