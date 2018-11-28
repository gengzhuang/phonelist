package com.easy.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easy.model.FileModel;

/**
 * 
 * @author GengZhuang
 *
 */
public interface FileService {

	/**
	 * 插入
	 * @param fileModel
	 */
	void insert(FileModel fileModel);

	void download(HttpServletRequest request, HttpServletResponse response, Long attachmentId)  throws Exception;

	//根据id删除附件
	void deleteAttachmentById(Long id) throws Exception;

	FileModel selectModelById(Long id) throws Exception;
	
}
