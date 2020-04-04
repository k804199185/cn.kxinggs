package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.CommentReply;
import com.community.service.content.CommentReplyService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/commentReply")
public class CommentReplyController {

    @Reference
    private CommentReplyService commentReplyService;

    @GetMapping("/findAll")
    public List<CommentReply> findAll(){
        return commentReplyService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<CommentReply> findPage(int page, int size){
        return commentReplyService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<CommentReply> findList(@RequestBody Map<String,Object> searchMap){
        return commentReplyService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<CommentReply> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  commentReplyService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public CommentReply findById(Long commentReplyId){
        return commentReplyService.findById(commentReplyId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody CommentReply commentReply){
        commentReplyService.add(commentReply);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody CommentReply commentReply){
        commentReplyService.update(commentReply);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long commentReplyId){
        commentReplyService.delete(commentReplyId);
        return new Result();
    }

}
