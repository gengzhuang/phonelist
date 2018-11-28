package com.easy.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.easy.commons.base.BaseController;
import com.easy.commons.model.ReturnMessage;
import com.easy.commons.utils.FileUtils;
import com.easy.model.FileModel;
import com.easy.service.FileService;

/**
 * 
 * @author GengZhuang
 *
 */
@Controller
@RequestMapping("fileHandle")
public class FileHandleController extends BaseController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/uploadMain")
	@ResponseBody
	public ModelAndView upload(String fileTypeDesc, String fileTypeExts, Integer size, Long sizeLimit, String filePath)
			throws UnsupportedEncodingException {
		ModelAndView result = new ModelAndView("/commons/upload");
		Boolean multi = Boolean.valueOf(true);
		if (StringUtils.isEmpty(fileTypeDesc)) {
			fileTypeDesc = "所有类型";
		}
		if (StringUtils.isEmpty(fileTypeExts)) {
			fileTypeExts = "*.*";
		}
		if (size.intValue() == 0) {
			multi = Boolean.valueOf(false);
		}
		if (sizeLimit != null) {
			sizeLimit = Long.valueOf(sizeLimit.longValue() * 1024L);
		}
		result.addObject("fileTypeDesc",
				java.net.URLDecoder.decode(java.net.URLDecoder.decode(fileTypeDesc, "UTF-8"), "UTF-8"));
		result.addObject("fileTypeExts", fileTypeExts);
		result.addObject("size", size);
		result.addObject("multi", multi);
		result.addObject("sizeLimit", sizeLimit);
		result.addObject("filePath", filePath);
		return result;
	}

	/**
	 * 上传
	 * 
	 * @param request
	 * @param response
	 * @param path
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Object upload(HttpServletRequest request, HttpServletResponse response, String path) {
		// 转型成MultipartHttpServletRequest
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获得文件到map容器中
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		// 文件上传并返回map容器，map存储了文件信息
		Map<String, Object> resultMap = null;

		resultMap = FileUtils.uploadFiles(fileMap, path, request);
		String fileName = (String) resultMap.get("fileName");
		String fileType = (String) resultMap.get("fileType");
		String filePath = (String) resultMap.get("filePath");
		String fileContentType = (String) resultMap.get("fileContentType");
		BigDecimal fileSize = new BigDecimal(resultMap.get("fileSize").toString());
		FileModel fileModel = new FileModel();
		fileModel.setFileType(fileType);
		fileModel.setFileName(fileName);
		fileModel.setFilePath(filePath);
		fileModel.setFileSize(fileSize);
		fileModel.setFileContentType(fileContentType);
		fileService.insert(fileModel);
		resultMap.put("id", fileModel.getId());
		return JSONUtils.toJSONString(resultMap);

	}

	/**
	 * 下载
	 */
	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response, Long attachmentId) {
		ModelAndView result = new ModelAndView();
		logger.debug("开始下载文件");
		try {
			fileService.download(request, response, attachmentId);
			result.addObject("success", Boolean.valueOf(true));
		} catch (Exception e) {
			logger.error("发生未知的异常:", e);
			result.addObject("msg", "发生未知的异常");
			result.addObject("success", Boolean.valueOf(false));
		}
	}

	/**
	 * 删除附件
	 */
	@RequestMapping("/deleteFileAndRecord")
	@ResponseBody
	public ReturnMessage deleteFileAndRecord(Long id){
		logger.debug("删除附件");
		try {
			fileService.deleteAttachmentById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ReturnMessage(false, e.getMessage());
		}
		return new ReturnMessage("删除附件成功！");
	}
}
