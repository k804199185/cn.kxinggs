package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.Label;
import com.community.service.content.LabelService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Reference
    private LabelService labelService;

    @GetMapping("/findAll")
    public List<Label> findAll(){
        return labelService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Label> findPage(int page, int size){
        return labelService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Label> findList(@RequestBody Map<String,Object> searchMap){
        return labelService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Label> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  labelService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Label findById(Long labelId){
        return labelService.findById(labelId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Label label){
        labelService.update(label);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long labelId){
        labelService.delete(labelId);
        return new Result();
    }

}
