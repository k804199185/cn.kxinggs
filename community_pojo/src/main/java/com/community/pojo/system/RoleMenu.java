package com.community.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * roleMenu实体类
 * @author Administrator
 *
 */
@Table(name="sys_role_menu")
public class RoleMenu implements Serializable{

	@Id
	private Long relationId;//主键


	

	private Long menuId;//菜单id

	private Long roleId;//角色id

	
	public Long getRelationId() {
		return relationId;
	}
	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	
}
