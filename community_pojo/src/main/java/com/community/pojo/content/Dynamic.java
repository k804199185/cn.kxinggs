package com.community.pojo.content;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * dynamic实体类
 * @author Administrator
 *
 */
@Table(name="con_dynamic")
public class Dynamic implements Serializable{

	@Id
	private Long dynamicId;//主键id


	

	private Long userId;//发表用户id

	private String content;//动态内容

	private java.util.Date createTime;//发表时间

	private Integer likeCount;//点赞人数

	private Integer commentCount;//评论人数

	private String delFlag;//删除标志 0正常 1 删除(屏蔽)

	private String area;//当前地址

	private String lastReplyTime;//最后回复时间

	private String picList;//上传图片路径集合

	private String lastReplyUserName;//最后回复人

	
	public Long getDynamicId() {
		return dynamicId;
	}
	public void setDynamicId(Long dynamicId) {
		this.dynamicId = dynamicId;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public String getLastReplyTime() {
		return lastReplyTime;
	}
	public void setLastReplyTime(String lastReplyTime) {
		this.lastReplyTime = lastReplyTime;
	}

	public String getPicList() {
		return picList;
	}
	public void setPicList(String picList) {
		this.picList = picList;
	}

	public String getLastReplyUserName() {
		return lastReplyUserName;
	}
	public void setLastReplyUserName(String lastReplyUserName) {
		this.lastReplyUserName = lastReplyUserName;
	}


	
}
