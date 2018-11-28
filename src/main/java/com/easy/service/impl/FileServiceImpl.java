package com.easy.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easy.commons.utils.FileUtils;
import com.easy.mapper.FileMapper;
import com.easy.model.FileModel;
import com.easy.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileMapper fileMapper;

	@Override
	public void insert(FileModel fileModel) {
		fileMapper.insert(fileModel);
	}

	@Override
	public void download(HttpServletRequest request, HttpServletResponse response, Long attachmentId) throws Exception {
		FileModel attachmentModel = fileMapper.selectByAttachmentId(attachmentId);
	    FileUtils.download(request, response, attachmentModel.getFilePath(), attachmentModel.getFileName(),attachmentModel.getFileContentType());
	}

	@Override
	public void deleteAttachmentById(Long id) throws Exception {
		FileModel attachmentModel = fileMapper.selectByAttachmentId(id);
		FileUtils.deleteFileByName(attachmentModel.getFilePath());
		int delete = fileMapper.deleteAttachmentById(id);
		if (delete != 1) {
			throw new Exception("删除附件失败");
		}
	}

	@Override
	public FileModel selectModelById(Long id) throws Exception {
		return fileMapper.selectByAttachmentId(id);
	}
	
}
