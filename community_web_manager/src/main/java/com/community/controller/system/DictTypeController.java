package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.DictType;
import com.community.service.system.DictTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/dictType")
public class DictTypeController {

    @Reference
    private DictTypeService dictTypeService;

    @GetMapping("/findAll")
    public List<DictType> findAll(){
        return dictTypeService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<DictType> findPage(int page, int size){
        return dictTypeService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<DictType> findList(@RequestBody Map<String,Object> searchMap){
        return dictTypeService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<DictType> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  dictTypeService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public DictType findById(Long dictTypeId){
        return dictTypeService.findById(dictTypeId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody DictType dictType){
        dictTypeService.add(dictType);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody DictType dictType){
        dictTypeService.update(dictType);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long dictTypeId){
        dictTypeService.delete(dictTypeId);
        return new Result();
    }

}
