package com.easy.model;

import java.math.BigDecimal;

/**
 * 
 * @author GengZhuang
 *
 */
public class FileModel {

	private Long id;
	private String fileName;
	private String fileType;
	private String filePath;
	private BigDecimal fileSize;
	private String fileContentType;
	private Long isUse;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public BigDecimal getFileSize() {
		return fileSize;
	}
	public void setFileSize(BigDecimal fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public Long getIsUse() {
		return isUse;
	}
	public void setIsUse(Long isUse) {
		this.isUse = isUse;
	}
}
