package com.easy.commons.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author GengZhuang
 *
 */
public class FileUtils {
	
	private static final String uploadDir;
	private static Properties ps = new Properties();
	
	static {
		try { 
			String dir = FileUtils.class.getResource("/").getPath()+"settings.properties";
			if (org.apache.commons.lang3.StringUtils.isNotEmpty(dir) && dir.startsWith("/")) {
				dir = dir.substring(1);
			}
			ps.load(new FileInputStream(new File(dir)));
			uploadDir = getSeparator(ps.getProperty("Upload.path"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("读取资源文件失败！");
		}
	}
	
	public static Properties getProperties() {
		return ps;
	}
	
	public static String getUploaddir() {
		return uploadDir;
	}
	
	private static String getSeparator(String path)
			throws Exception
	{
		if (path != null) {
			path = path.replace("/", File.separator);
			path = path.replace("\\", File.separator);
			return path;
		}
		return null;
	}
	
	public static void download(HttpServletRequest request,
			HttpServletResponse response, String storeName, String realName,
			String fileContentType) throws Exception {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		realName = new String(realName.getBytes("GBK"),"ISO-8859-1");
		//URLDecoder.decode(realName,"utf-8");
		String ctxPath = uploadDir;
		String downLoadPath = ctxPath +"/"+ storeName;

		long fileLength = new File(downLoadPath).length();
		String contentType = fileContentType+";charset=UTF-8";
		response.setContentType(contentType);
		response.setHeader("Content-disposition", "attachment; filename=" + 
				realName);
		response.setHeader("Content-Length", String.valueOf(fileLength));

		bis = new BufferedInputStream(new FileInputStream(downLoadPath));
		bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[2048];
		int bytesRead = 0;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}
	
	/**
	 * 处理上传
	 * @param fileMap
	 * @param path
	 * @return
	 */
	public static Map<String,Object>uploadFiles(Map<String,MultipartFile> fileMap,
			String path,HttpServletRequest request) {
		String fileType = null;
		String fileName = null;
		String filePath = null;
		String fileSize = null;
		String fileContentType = null;
		String realName = null;
		for(Map.Entry<String, MultipartFile> entity : fileMap.entrySet()){
			MultipartFile mf = entity.getValue();
			Date date = new Date();
			String timeStr = new SimpleDateFormat("HHmmssSSS").format(date);
			realName = mf.getOriginalFilename();
			fileName = timeStr+mf.getOriginalFilename().substring(mf.getOriginalFilename().indexOf("."));
			fileType = fileName.substring(fileName.indexOf(".")+1);
			fileSize = mf.getSize()+"";
			filePath = path + "/" + fileName;
			fileContentType = mf.getContentType();
			InputStream in = null;
			try {
				in = mf.getInputStream();
				File disfile = new File(uploadDir + "/" + path);
				if(!disfile.exists()){
					disfile.mkdirs();
				}
				FileOutputStream fs=new FileOutputStream(uploadDir + "/"+ filePath);
				//FileCopyUtils.copy(in, fs);
				byte[] buffer =new byte[1024*1024];
				@SuppressWarnings("unused")
				int bytesum = 0;
				int byteread = 0;
				while ((byteread=in.read(buffer))!=-1){
					bytesum+=byteread;
					fs.write(buffer,0,byteread);
					fs.flush();
				} 
				fs.close();
				in.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Map存储文件信息
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("fileName", realName);
		resultMap.put("fileType", fileType);
		resultMap.put("fileSize", fileSize);
		resultMap.put("filePath", filePath);
		resultMap.put("fileContentType", fileContentType);

		return resultMap;
	}
	
	public static void deleteFileByName(String path) throws Exception {
		File file = new File(uploadDir + path);
		if (!file.exists()) {
			throw new Exception("要删除的文件不存在！");
		} else {  
			file.delete(); 
		}
	}
	
	public static void deleteFileByPathAndName(String path) throws Exception {
		File file = new File(path);
		if (!file.exists()) {
			throw new Exception("要删除的文件不存在！");
		} else {  
			file.delete(); 
		}
	}
	
}
