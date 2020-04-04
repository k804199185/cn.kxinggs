package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.FileInfo;
import com.community.service.system.FileInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/fileInfo")
public class FileInfoController {

    @Reference
    private FileInfoService fileInfoService;

    @GetMapping("/findAll")
    public List<FileInfo> findAll(){
        return fileInfoService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<FileInfo> findPage(int page, int size){
        return fileInfoService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<FileInfo> findList(@RequestBody Map<String,Object> searchMap){
        return fileInfoService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<FileInfo> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  fileInfoService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public FileInfo findById(String fileId){
        return fileInfoService.findById(fileId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody FileInfo fileInfo){
        fileInfoService.add(fileInfo);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody FileInfo fileInfo){
        fileInfoService.update(fileInfo);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String fileId){
        fileInfoService.delete(fileId);
        return new Result();
    }

}
