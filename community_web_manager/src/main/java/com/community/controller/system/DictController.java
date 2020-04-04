package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.Dict;
import com.community.service.system.DictService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Reference
    private DictService dictService;

    @GetMapping("/findAll")
    public List<Dict> findAll(){
        return dictService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Dict> findPage(int page, int size){
        return dictService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Dict> findList(@RequestBody Map<String,Object> searchMap){
        return dictService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Dict> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  dictService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Dict findById(Long dictId){
        return dictService.findById(dictId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Dict dict){
        dictService.add(dict);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Dict dict){
        dictService.update(dict);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long dictId){
        dictService.delete(dictId);
        return new Result();
    }

}
