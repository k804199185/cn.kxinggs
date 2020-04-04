package com.community.controller.content;

import com.community.controller.entity.LayuiResult;
import com.community.entity.Result;
import com.community.pojo.content.ArticleType;
import com.community.service.content.ArticleTypeService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articleType")
public class ArticleTypeController {

    @Reference
    private ArticleTypeService articleTypeService;

    @GetMapping("/findAll")
    public Result findAll(){
        List<ArticleType> list = articleTypeService.findAll();
        LayuiResult result = new LayuiResult();
        result.setData(list);
        result.setMessage("测试articleType方法");
        return result;

    }

}
