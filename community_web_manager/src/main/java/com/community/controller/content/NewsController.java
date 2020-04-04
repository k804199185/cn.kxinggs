package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.News;
import com.community.service.content.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Reference
    private NewsService newsService;

    @GetMapping("/findAll")
    public List<News> findAll(){
        return newsService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<News> findPage(int page, int size){
        return newsService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<News> findList(@RequestBody Map<String,Object> searchMap){
        return newsService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<News> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  newsService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public News findById(Long newId){
        return newsService.findById(newId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody News news){
        newsService.add(news);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody News news){
        newsService.update(news);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long newId){
        newsService.delete(newId);
        return new Result();
    }

}
