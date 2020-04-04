package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.UserPost;
import com.community.service.system.UserPostService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/userPost")
public class UserPostController {

    @Reference
    private UserPostService userPostService;

    @GetMapping("/findAll")
    public List<UserPost> findAll(){
        return userPostService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<UserPost> findPage(int page, int size){
        return userPostService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<UserPost> findList(@RequestBody Map<String,Object> searchMap){
        return userPostService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<UserPost> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  userPostService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public UserPost findById(Long userPosId){
        return userPostService.findById(userPosId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody UserPost userPost){
        userPostService.add(userPost);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserPost userPost){
        userPostService.update(userPost);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long userPosId){
        userPostService.delete(userPosId);
        return new Result();
    }

}
