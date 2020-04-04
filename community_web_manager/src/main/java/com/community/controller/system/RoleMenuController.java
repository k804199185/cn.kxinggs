package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.RoleMenu;
import com.community.service.system.RoleMenuService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {

    @Reference
    private RoleMenuService roleMenuService;

    @GetMapping("/findAll")
    public List<RoleMenu> findAll(){
        return roleMenuService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<RoleMenu> findPage(int page, int size){
        return roleMenuService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<RoleMenu> findList(@RequestBody Map<String,Object> searchMap){
        return roleMenuService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<RoleMenu> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  roleMenuService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public RoleMenu findById(Long relationId){
        return roleMenuService.findById(relationId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody RoleMenu roleMenu){
        roleMenuService.add(roleMenu);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody RoleMenu roleMenu){
        roleMenuService.update(roleMenu);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Long relationId){
        roleMenuService.delete(relationId);
        return new Result();
    }

}
