package com.community.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * dictType实体类
 * @author Administrator
 *
 */
@Table(name="sys_dict_type")
public class DictType implements Serializable{

	@Id
	private Long dictTypeId;//字典类型id


	

	private String code;//字典类型编码

	private String name;//字典类型名称

	private String description;//字典描述

	private String systemFlag;//是否是系统字典，Y-是，N-否

	private String status;//状态(字典)

	private Integer sort;//排序

	private java.util.Date createTime;//添加时间

	private Long createUser;//创建人

	private java.util.Date updateTime;//修改时间

	private Long updateUser;//修改人

	
	public Long getDictTypeId() {
		return dictTypeId;
	}
	public void setDictTypeId(Long dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSystemFlag() {
		return systemFlag;
	}
	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
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
