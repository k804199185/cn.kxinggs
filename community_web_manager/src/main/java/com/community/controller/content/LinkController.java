package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.Link;
import com.community.service.content.LinkService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Reference
    private LinkService linkService;

    @GetMapping("/findAll")
    public List<Link> findAll(){
        return linkService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Link> findPage(int page, int size){
        return linkService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Link> findList(@RequestBody Map<String,Object> searchMap){
        return linkService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Link> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  linkService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Link findById(Long linkId){
        return linkService.findById(linkId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Link link){
        linkService.add(link);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Link link){
        linkService.update(link);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long linkId){
        linkService.delete(linkId);
        return new Result();
    }

}
