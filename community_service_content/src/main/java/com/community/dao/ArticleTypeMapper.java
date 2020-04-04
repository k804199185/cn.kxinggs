package com.community.dao;

import com.community.pojo.content.ArticleType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleTypeMapper extends Mapper<ArticleType> {
    @Select("select * from articleType")
    List<ArticleType> selectAll();
}
