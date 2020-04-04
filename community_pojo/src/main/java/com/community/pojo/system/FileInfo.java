package com.community.pojo.system;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * fileInfo实体类
 * @author Administrator
 *
 */
@Table(name="sys_file_info")
public class FileInfo implements Serializable{

	@Id
	private String fileId;//主键id


	

	private String fileBucket;//文件仓库（oss仓库）

	private String fileName;//文件名称

	private String fileSuffix;//文件后缀

	private Long fileSizeKb;//文件大小kb

	private String finalName;//文件唯一标识id

	private String filePath;//存储路径

	private java.util.Date createTime;//创建时间

	private java.util.Date updateTime;//修改时间

	private Long createUser;//创建用户

	private Long updateUser;//修改用户

	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileBucket() {
		return fileBucket;
	}
	public void setFileBucket(String fileBucket) {
		this.fileBucket = fileBucket;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}
	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public Long getFileSizeKb() {
		return fileSizeKb;
	}
	public void setFileSizeKb(Long fileSizeKb) {
		this.fileSizeKb = fileSizeKb;
	}

	public String getFinalName() {
		return finalName;
	}
	public void setFinalName(String finalName) {
		this.finalName = finalName;
	}

	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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


	
}
