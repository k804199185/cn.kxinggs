package com.community.pojo.content;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * news实体类
 * @author Administrator
 *
 */
@Table(name="con_news")
public class News implements Serializable{

	@Id
	private Long newId;//主键


	

	private String newTitle;//标题

	private String content;//内容

	private String source;//来源，可以是部门或其他转载

	private Integer commentCount;//评论数

	private String imgUrl;//配图路径

	private Integer status;//0为未审核，1为审核

	private java.util.Date createTime;//发布时间

	
	public Long getNewId() {
		return newId;
	}
	public void setNewId(Long newId) {
		this.newId = newId;
	}

	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}


	
}
