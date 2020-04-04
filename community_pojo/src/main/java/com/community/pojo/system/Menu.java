package com.community.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * menu实体类
 * @author Administrator
 *
 */
@Table(name="sys_menu")
public class Menu implements Serializable{

	@Id
	private Long menuId;//主键id


	

	private String code;//菜单编号

	private String pcode;//菜单父编号

	private String pcodes;//当前菜单的所有父菜单编号

	private String name;//菜单名称

	private String icon;//菜单图标

	private String url;//url地址

	private Integer sort;//菜单排序号

	private Integer levels;//菜单层级

	private String menuFlag;//是否是菜单(字典)

	private String description;//备注

	private String status;//菜单状态(字典)

	private String newPageFlag;//是否打开新页面的标识(字典)

	private String openFlag;//是否打开(字典)

	private String systemType;//系统分类(字典)

	private java.util.Date createTime;//创建时间

	private java.util.Date updateTime;//修改时间

	private Long createUser;//创建人

	private Long updateUser;//修改人

	private String delFlag;//是否删除（字典）

	
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPcodes() {
		return pcodes;
	}
	public void setPcodes(String pcodes) {
		this.pcodes = pcodes;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	public String getMenuFlag() {
		return menuFlag;
	}
	public void setMenuFlag(String menuFlag) {
		this.menuFlag = menuFlag;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getNewPageFlag() {
		return newPageFlag;
	}
	public void setNewPageFlag(String newPageFlag) {
		this.newPageFlag = newPageFlag;
	}

	public String getOpenFlag() {
		return openFlag;
	}
	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}

	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Long getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}


	
}
