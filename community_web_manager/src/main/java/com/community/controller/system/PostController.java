package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.Post;
import com.community.service.system.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Reference
    private PostService postService;

    @GetMapping("/findAll")
    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Post> findPage(int page, int size){
        return postService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Post> findList(@RequestBody Map<String,Object> searchMap){
        return postService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Post> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  postService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Post findById(Long postId){
        return postService.findById(postId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Post post){
        postService.add(post);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Post post){
        postService.update(post);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long postId){
        postService.delete(postId);
        return new Result();
    }

}
