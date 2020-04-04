package com.community.pojo.content;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * ad实体类
 * @author Administrator
 *
 */
@Table(name="con_ad")
public class Ad implements Serializable{

	@Id
	private Long adId;//主键id


	

	private String adName;//名称

	private String picUrl;//广告图片

	private java.util.Date endTime;//结束时间

	private String remark;//备注

	private java.util.Date beginTime;//开始时间

	private String adHref;//广告跳转链接

	private Integer postion;//广告位置 0 首页banner 1 列表页 2 详情页

	
	public Long getAdId() {
		return adId;
	}
	public void setAdId(Long adId) {
		this.adId = adId;
	}

	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public java.util.Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getAdHref() {
		return adHref;
	}
	public void setAdHref(String adHref) {
		this.adHref = adHref;
	}

	public Integer getPostion() {
		return postion;
	}
	public void setPostion(Integer postion) {
		this.postion = postion;
	}


	
}
