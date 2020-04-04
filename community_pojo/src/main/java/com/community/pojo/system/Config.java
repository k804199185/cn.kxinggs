package com.community.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * config实体类
 * @author Administrator
 *
 */
@Table(name="sys_config")
public class Config implements Serializable{

	@Id
	private Long id;//主键


	

	private String name;//名称

	private String code;//属性编码标识

	private String dictFlag;//是否是字典中的值

	private Long dictTypeId;//字典类型的编码

	private String value;//属性值，如果是字典中的类型，则为dict的code

	private String remark;//备注

	private java.util.Date createTime;//创建时间

	private Long createUser;//创建人

	private java.util.Date updateTime;//更新时间

	private Long updateUser;//更新人

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getDictFlag() {
		return dictFlag;
	}
	public void setDictFlag(String dictFlag) {
		this.dictFlag = dictFlag;
	}

	public Long getDictTypeId() {
		return dictTypeId;
	}
	public void setDictTypeId(Long dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}


	
}
