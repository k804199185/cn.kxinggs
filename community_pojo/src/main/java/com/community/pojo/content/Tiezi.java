package com.community.pojo.content;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tiezi实体类
 * @author Administrator
 *
 */
@Table(name="con_tiezi")
public class Tiezi implements Serializable{

	@Id
	private Long pid;//主键id


	

	private String title;//帖子标题

	private String content;//帖子内容

	private java.util.Date publishTime;//发表时间

	private Integer commentCount;//评论数量

	private Integer likeCount;//点赞（喜欢）数量

	private Integer scanCount;//收藏数量

	private String delFlag;//删除标志 0正常 1 删除(屏蔽)

	private Long uid;//发帖人id

	private Long tid;//版块id

	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(java.util.Date publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getScanCount() {
		return scanCount;
	}
	public void setScanCount(Integer scanCount) {
		this.scanCount = scanCount;
	}

	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}


	
}
