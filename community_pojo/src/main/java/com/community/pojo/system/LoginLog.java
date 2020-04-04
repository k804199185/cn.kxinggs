package com.community.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * loginLog实体类
 * @author Administrator
 *
 */
@Table(name="sys_login_log")
public class LoginLog implements Serializable{

	@Id
	private Long loginLogId;//主键


	

	private String logName;//日志名称

	private Long userId;//管理员id

	private java.util.Date createTime;//创建时间

	private String succeed;//登录状态（0成功 1失败）

	private String message;//具体消息

	private String ipAddress;//登录ip

	private String loginLocation;//登录地点

	private String browser;//浏览器类型

	
	public Long getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(Long loginLogId) {
		this.loginLogId = loginLogId;
	}

	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getSucceed() {
		return succeed;
	}
	public void setSucceed(String succeed) {
		this.succeed = succeed;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getLoginLocation() {
		return loginLocation;
	}
	public void setLoginLocation(String loginLocation) {
		this.loginLocation = loginLocation;
	}

	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}


	
}
