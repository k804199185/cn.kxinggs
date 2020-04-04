package com.community.pojo.content;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "article_type")
public class ArticleType implements Serializable {
    /*
  `article_type_id` bigint(20) NOT NULL COMMENT '文章类型id',
  `article_type_name` varchar(255) DEFAULT NULL COMMENT '文章类型名称',
  `delete_flag` char(1) DEFAULT NULL COMMENT '删除标志 0 正常 1删除',
  `des` varchar(255) DEFAULT NULL COMMENT '文章类型描述内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`article_type_id`)
     */
    @Id
    private Long articleTypeId;//文章类型id

    private String articleTypeName;//文章类型名称

    private String deleteFlag;//删除标志 0 正常 1删除

    private String des;//文章类型描述内容

    private Date createTime;//创建时间

    private Long createUser;//创建人

    public Long getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Long articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }
}
