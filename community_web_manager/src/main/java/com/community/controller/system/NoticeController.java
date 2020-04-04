package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.Notice;
import com.community.service.system.NoticeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Reference
    private NoticeService noticeService;

    @GetMapping("/findAll")
    public List<Notice> findAll(){
        return noticeService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Notice> findPage(int page, int size){
        return noticeService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Notice> findList(@RequestBody Map<String,Object> searchMap){
        return noticeService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Notice> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  noticeService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Notice findById(Long noticeId){
        return noticeService.findById(noticeId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Notice notice){
        noticeService.add(notice);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Notice notice){
        noticeService.update(notice);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long noticeId){
        noticeService.delete(noticeId);
        return new Result();
    }

}
