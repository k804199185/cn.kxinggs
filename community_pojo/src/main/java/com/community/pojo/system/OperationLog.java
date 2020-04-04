package com.community.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * operationLog实体类
 * @author Administrator
 *
 */
@Table(name="sys_operation_log")
public class OperationLog implements Serializable{

	@Id
	private Long operationLogId;//主键


	

	private String logType;//日志类型(字典)

	private String logName;//日志名称

	private Long userId;//用户id

	private String className;//类名称

	private String method;//方法名称

	private java.util.Date createTime;//创建时间

	private String succeed;//是否成功(字典)

	private String message;//备注

	
	public Long getOperationLogId() {
		return operationLogId;
	}
	public void setOperationLogId(Long operationLogId) {
		this.operationLogId = operationLogId;
	}

	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
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

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
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


	
}
