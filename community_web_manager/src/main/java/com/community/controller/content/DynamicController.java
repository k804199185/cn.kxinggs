package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.Dynamic;
import com.community.service.content.DynamicService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Reference
    private DynamicService dynamicService;

    @GetMapping("/findAll")
    public List<Dynamic> findAll(){
        return dynamicService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Dynamic> findPage(int page, int size){
        return dynamicService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Dynamic> findList(@RequestBody Map<String,Object> searchMap){
        return dynamicService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Dynamic> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  dynamicService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Dynamic findById(Long dynamicId){
        return dynamicService.findById(dynamicId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Dynamic dynamic){
        dynamicService.add(dynamic);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Dynamic dynamic){
        dynamicService.update(dynamic);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long dynamicId){
        dynamicService.delete(dynamicId);
        return new Result();
    }

}
