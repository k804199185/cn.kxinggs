package com.community.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.ArticleMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.Article;
import com.community.service.content.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 返回全部记录
     *
     * @return
     */
    public List<Article> findAll() {
        return articleMapper.selectAll();
    }

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Article> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Article> articles = (Page<Article>) articleMapper.selectAll();
        return new PageResult<Article>(articles.getTotal(), articles.getResult());
    }

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return
     */
    public List<Article> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return articleMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Article> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<Article> articles = (Page<Article>) articleMapper.selectByExample(example);
        return new PageResult<Article>(articles.getTotal(), articles.getResult());
    }

    /**
     * 根据Id查询
     *
     * @param articleId
     * @return
     */
    public Article findById(Long articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    /**
     * 新增
     *
     * @param article
     */
    public void add(Article article) {
        articleMapper.insert(article);
    }

    /**
     * 修改
     *
     * @param article
     */
    public void update(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
    }

    /**
     * 删除
     *
     * @param articleId
     */
    public void delete(Long articleId) {
        articleMapper.deleteByPrimaryKey(articleId);
    }

    /**
     * 逻辑删除，修改删除标记delete_flag
     * @param articleId
     */
    public void deleteFlag(Long articleId) {
        Article article = new Article();
        article.setArticleId(articleId);
        article.setDelFlag("1");
        articleMapper.updateByPrimaryKeySelective(article);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Article.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 文章标题
            if (searchMap.get("articleTitle") != null && !"".equals(searchMap.get("articleTitle"))) {
                criteria.andLike("articleTitle", "%" + searchMap.get("articleTitle") + "%");
            }
            // 文章内容
            if (searchMap.get("articleContent") != null && !"".equals(searchMap.get("articleContent"))) {
                criteria.andLike("articleContent", "%" + searchMap.get("articleContent") + "%");
            }
            // 删除标志 0正常 1 删除(屏蔽)
            if (searchMap.get("delFlag") != null && !"".equals(searchMap.get("delFlag"))) {
                criteria.andLike("delFlag", "%" + searchMap.get("delFlag") + "%");
            }
            // '0为未审核，1为审核'
            if (searchMap.get("status") != null && !"".equals(searchMap.get("status"))) {
                criteria.andLike("status", "%" + searchMap.get("status") + "%");
            }

            // 发布人id
            if (searchMap.get("userId") != null) {
                criteria.andEqualTo("userId", searchMap.get("userId"));
            }
            // 点赞人数
            if (searchMap.get("likeCount") != null) {
                criteria.andEqualTo("likeCount", searchMap.get("likeCount"));
            }
            // 评论人数
            if (searchMap.get("commentCount") != null) {
                criteria.andEqualTo("commentCount", searchMap.get("commentCount"));
            }
            // 浏览人数
            if (searchMap.get("browseCount") != null) {
                criteria.andEqualTo("browseCount", searchMap.get("browseCount"));
            }
            // 收藏人数
            if (searchMap.get("collectionCount") != null) {
                criteria.andEqualTo("collectionCount", searchMap.get("collectionCount"));
            }
            // 标签(标签表查询id)
            if (searchMap.get("label") != null) {
                criteria.andEqualTo("label", searchMap.get("label"));
            }
            // 是否推荐 0 推荐 1不推荐
            if (searchMap.get("isRecommend") != null) {
                criteria.andEqualTo("isRecommend", searchMap.get("isRecommend"));
            }
            // 文章类型id
            if (searchMap.get("contentType") != null) {
                criteria.andEqualTo("contentType", searchMap.get("contentType"));
            }

        }
        return example;
    }


}
