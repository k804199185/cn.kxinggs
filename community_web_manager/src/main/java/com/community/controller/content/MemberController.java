package com.community.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.content.Member;
import com.community.service.content.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Reference
    private MemberService memberService;

    @GetMapping("/findAll")
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Member> findPage(int page, int size){
        return memberService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Member> findList(@RequestBody Map<String,Object> searchMap){
        return memberService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Member> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  memberService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Member findById(Long memberId){
        return memberService.findById(memberId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Member member){
        memberService.add(member);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Member member){
        memberService.update(member);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long memberId){
        memberService.delete(memberId);
        return new Result();
    }

}
