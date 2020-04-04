package com.community.pojo.system;

import java.io.Serializable;


/**
 * 封装用户和职位的实体类，用于添加或参数传递
 */
public class UserUnitPost implements Serializable {

    //用户
    private User user;

    //职位id,逗号分隔
    private String postId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
