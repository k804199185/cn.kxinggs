package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.controller.entity.LayuiArtVo;
import com.community.controller.entity.LayuiResult;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.Article;
import com.community.service.content.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Reference
    private ArticleService articleService;

    @GetMapping("/findAll")
    public List<Article> findAll() {
        return articleService.findAll();
    }


    @GetMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        LayuiResult result = new LayuiResult();
        PageResult<Article> pageResult = articleService.findPage(page, size);
        List<Article> rows = pageResult.getRows();
        List<LayuiArtVo> data = new ArrayList<>();
        for (Article article : rows) {
            LayuiArtVo artvo = new LayuiArtVo();
            artvo.setArticle_id(article.getArticleId());
            artvo.setArticle_title(article.getArticleTitle());
            artvo.setCreate_time(article.getCreateTime().toString());
            artvo.setUser_id(article.getUserId());
            artvo.setDel_flag(article.getDelFlag());
            artvo.setDel_text("测试");
            artvo.setLike_count(article.getLikeCount());
            artvo.setComment_count(article.getCommentCount());
            artvo.setBrowse_count(article.getBrowseCount());
            artvo.setStatus(article.getStatus());
            artvo.setIs_recommend(article.getIsRecommend());
            artvo.setCollection_count(article.getCollectionCount());
//            artvo.setContent_type(articleTypeService.findById(article.getContentType()).getArticleTypeName());

            //添加到data集合中
            data.add(artvo);
        }
        result.setCount(pageResult.getTotal());
        result.setData(data);
        return result;
    }

    @PostMapping("/findList")
    public List<Article> findList(@RequestBody Map<String, Object> searchMap) {
        return articleService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Article> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return articleService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public Result findById(Long articleId) {
        LayuiResult result = new LayuiResult();
        Article article = articleService.findById(articleId);
        List<LayuiArtVo> data = new ArrayList<>();
        LayuiArtVo artvo = new LayuiArtVo();
        artvo.setArticle_id(article.getArticleId());
        artvo.setCreate_time(article.getCreateTime().toString());
        artvo.setUser_id(article.getUserId());
        artvo.setDel_flag(article.getDelFlag());
        artvo.setDel_text("测试");
        artvo.setLike_count(article.getLikeCount());
        artvo.setComment_count(article.getCommentCount());
        artvo.setBrowse_count(article.getBrowseCount());
        artvo.setStatus(article.getStatus());
        artvo.setIs_recommend(article.getIsRecommend());
        artvo.setCollection_count(article.getCollectionCount());
//        artvo.setContent_type(articleTypeService.findById(article.getContentType()).getArticleTypeName());

        //添加到data集合中
        data.add(artvo);
        result.setData(data);

        return result;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Article article) {
        articleService.update(article);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long articleId) {
        articleService.delete(articleId);
        return new Result();
    }

    @GetMapping("/deleteFlag")
    public Result deleteFlag(Long articleId) {
        articleService.deleteFlag(articleId);
        return new Result();
    }


}
