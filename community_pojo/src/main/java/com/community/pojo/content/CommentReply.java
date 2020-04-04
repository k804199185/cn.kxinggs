package com.community.pojo.content;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * commentReply实体类
 * @author Administrator
 *
 */
@Table(name="tiezi_comment_reply")
public class CommentReply implements Serializable{

	@Id
	private Long commentReplyId;//评论回复ID


	

	private Long commentId;//帖子评论ID

	private Long userId;//回复用户ID

	private String userAvatar;//回复人头像

	private String userName;//回复人名称

	private String content;//回复内容

	private java.util.Date createTime;//创建时间

	
	public Long getCommentReplyId() {
		return commentReplyId;
	}
	public void setCommentReplyId(Long commentReplyId) {
		this.commentReplyId = commentReplyId;
	}

	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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


	
}
