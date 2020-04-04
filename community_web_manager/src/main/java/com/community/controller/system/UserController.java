package com.community.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.community.entity.PageResult;
import com.community.entity.Result;
import com.community.pojo.system.User;
import com.community.pojo.system.UserUnitPost;
import com.community.service.system.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<User> findPage(int page, int size) {
        return userService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<User> findList(@RequestBody Map<String, Object> searchMap) {
        return userService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<User> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return userService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public User findById(Long userId) {
        return userService.findById(userId);
    }


    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return new Result();
    }


    @PostMapping("/add")
    public Result add(@RequestBody UserUnitPost UserUnitPost) {
        int i = userService.add(UserUnitPost);
        if (i > 0) {
            return new Result(0, "添加用户成功");
        } else {
            return new Result(1, "添加用户失败");
        }
    }


    @PostMapping("/updateUserUnitPost")
    public Result updateUserUnitPost(@RequestBody UserUnitPost UserUnitPost) {
        int i = userService.updateUserUnitPost(UserUnitPost);
        if (i > 0) {
            return new Result(0, "修改用户信息成功");
        } else {
            return new Result(1, "修改失败");
        }
    }


    @GetMapping("/findByUserUnitPostId")
    public UserUnitPost findByUserUnitPostId(Long userId) {
        return userService.findByUserUnitPostId(userId);
    }

    @GetMapping("/isDelete")
    public Result isDelete(Long userId) {
        int i = userService.isDelete(userId);
        if (i > 0) {
            return new Result(0, "删除成功");
        } else {
            return new Result(1, "删除失败");
        }
    }

    @GetMapping("/delete")
    public Result delete(Long userId) {
        int i = userService.delete(userId);
        if (i > 0) {
            return new Result(0, "删除成功");
        } else {
            return new Result(1, "删除失败");
        }
    }


    @GetMapping("/deleteUsers")
    public Result deleteUsers(@RequestBody Long[] ids) {
        int i = userService.deleteUsers(ids);
        if (i > 0) {
            return new Result(0, "批量删除成功");
        } else {
            return new Result(1, "批量删除失败");
        }
    }


    @GetMapping("/updateStatus")
    public Result updateStatus(Long userId){
       int i= userService.updateStatus(userId);
        if (i > 0) {
            return new Result(0, "状态修改成功");
        } else {
            return new Result(1, "修改失败");
        }
    }




}

