package com.community.pojo.content;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * topic实体类
 * @author Administrator
 *
 */
@Table(name="con_topic")
public class Topic implements Serializable{

	@Id
	private Long tid;//主键id


	

	private String name;//版块名称

	private String delFlag;//删除标志 0 正常 1删除

	private String content;//版块内容(描述)

	private String image;//图片

	private java.util.Date createTime;//创建时间

	
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}


	
}
