package com.community.pojo.content;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * comment实体类
 * @author Administrator
 *
 */
@Table(name="tiezi_comment")
public class Comment implements Serializable{

	@Id
	private Long tieziCommentId;//主键id


	

	private Long tieziId;//帖子id

	private String content;//评论内容

	private java.util.Date createTime;//评论时间

	private Integer userId;//评论人id

	private String delFlag;//删除标志 0正常 1 删除(屏蔽)

	private String userAvatar;//评论人头像

	private String userName;//评论人名称

	
	public Long getTieziCommentId() {
		return tieziCommentId;
	}
	public void setTieziCommentId(Long tieziCommentId) {
		this.tieziCommentId = tieziCommentId;
	}

	public Long getTieziId() {
		return tieziId;
	}
	public void setTieziId(Long tieziId) {
		this.tieziId = tieziId;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	
}
