package com.community.pojo.content;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * label实体类
 * @author Administrator
 *
 */
@Table(name="con_label")
public class Label implements Serializable{

	@Id
	private Long labelId;//主键id


	

	private String labelName;//标签名称

	private String delFlag;//删除标志 0正常 1 删除(屏蔽)

	
	public Long getLabelId() {
		return labelId;
	}
	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}


	
}
