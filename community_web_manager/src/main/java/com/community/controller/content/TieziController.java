package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.Tiezi;
import com.community.service.content.TieziService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tiezi")
public class TieziController {

    @Reference
    private TieziService tieziService;

    @GetMapping("/findAll")
    public List<Tiezi> findAll(){
        return tieziService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Tiezi> findPage(int page, int size){
        return tieziService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Tiezi> findList(@RequestBody Map<String,Object> searchMap){
        return tieziService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Tiezi> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  tieziService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Tiezi findById(Long pid){
        return tieziService.findById(pid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Tiezi tiezi){
        tieziService.add(tiezi);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Tiezi tiezi){
        tieziService.update(tiezi);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long pid){
        tieziService.delete(pid);
        return new Result();
    }

}
