package com.easy.mapper;

import com.easy.model.FileModel;

public interface FileMapper {

	/**
	 * 插入
	 * @param fileModel
	 */
	void insert(FileModel fileModel);

	FileModel selectByAttachmentId(Long attachmentId);

	int deleteAttachmentById(Long id);

	FileModel selectModelById(Long id);

	void updateByPrimaryKey(FileModel fModel);

}
