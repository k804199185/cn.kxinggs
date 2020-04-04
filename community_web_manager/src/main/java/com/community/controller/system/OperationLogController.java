package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.OperationLog;
import com.community.service.system.OperationLogService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/operationLog")
public class OperationLogController {

    @Reference
    private OperationLogService operationLogService;

    @GetMapping("/findAll")
    public List<OperationLog> findAll(){
        return operationLogService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<OperationLog> findPage(int page, int size){
        return operationLogService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<OperationLog> findList(@RequestBody Map<String,Object> searchMap){
        return operationLogService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<OperationLog> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  operationLogService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public OperationLog findById(Long operationLogId){
        return operationLogService.findById(operationLogId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody OperationLog operationLog){
        operationLogService.add(operationLog);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody OperationLog operationLog){
        operationLogService.update(operationLog);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long operationLogId){
        operationLogService.delete(operationLogId);
        return new Result();
    }

}
