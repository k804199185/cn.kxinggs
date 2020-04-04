package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.Config;
import com.community.service.system.ConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Reference
    private ConfigService configService;

    @GetMapping("/findAll")
    public List<Config> findAll(){
        return configService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Config> findPage(int page, int size){
        return configService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Config> findList(@RequestBody Map<String,Object> searchMap){
        return configService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Config> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  configService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Config findById(Long id){
        return configService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Config config){
        configService.add(config);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Config config){
        configService.update(config);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long id){
        configService.delete(id);
        return new Result();
    }

}
