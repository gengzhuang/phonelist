package com.easy.model;

public class DatasourceResultModel extends Datasource {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1925733984472270979L;
	
	private String fileName;
	private String fileType;
	private String uptimeStr;
	private Integer fileSize;
	private String userName;
	private String orgName;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getUptimeStr() {
		return uptimeStr;
	}
	public void setUptimeStr(String uptimeStr) {
		this.uptimeStr = uptimeStr;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
