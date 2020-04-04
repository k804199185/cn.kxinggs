package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.Dept;
import com.community.service.system.DeptService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Reference
    private DeptService deptService;

    @GetMapping("/findAll")
    public List<Dept> findAll(){
        return deptService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Dept> findPage(int page, int size){
        return deptService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Dept> findList(@RequestBody Map<String,Object> searchMap){
        return deptService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Dept> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  deptService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Dept findById(Long deptId){
        return deptService.findById(deptId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long deptId){
        deptService.delete(deptId);
        return new Result();
    }

}
