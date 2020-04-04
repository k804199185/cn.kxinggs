package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.Topic;
import com.community.service.content.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Reference
    private TopicService topicService;

    @GetMapping("/findAll")
    public List<Topic> findAll(){
        return topicService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Topic> findPage(int page, int size){
        return topicService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Topic> findList(@RequestBody Map<String,Object> searchMap){
        return topicService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Topic> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  topicService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Topic findById(Long tid){
        return topicService.findById(tid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Topic topic){
        topicService.add(topic);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Topic topic){
        topicService.update(topic);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long tid){
        topicService.delete(tid);
        return new Result();
    }

}
