package com.community.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * userPost实体类
 * @author Administrator
 *
 */
@Table(name="sys_user_post")
public class UserPost implements Serializable{

	@Id
	private Long userPosId;//主键id


	

	private Long userId;//用户id

	private Long posId;//职位id

	
	public Long getUserPosId() {
		return userPosId;
	}
	public void setUserPosId(Long userPosId) {
		this.userPosId = userPosId;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPosId() {
		return posId;
	}
	public void setPosId(Long posId) {
		this.posId = posId;
	}


	
}
