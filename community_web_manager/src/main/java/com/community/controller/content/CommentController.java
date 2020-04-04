package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.Comment;
import com.community.service.content.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Reference
    private CommentService commentService;

    @GetMapping("/findAll")
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Comment> findPage(int page, int size){
        return commentService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Comment> findList(@RequestBody Map<String,Object> searchMap){
        return commentService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Comment> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  commentService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Comment findById(Long tieziCommentId){
        return commentService.findById(tieziCommentId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Comment comment){
        commentService.add(comment);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Comment comment){
        commentService.update(comment);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long tieziCommentId){
        commentService.delete(tieziCommentId);
        return new Result();
    }

}
