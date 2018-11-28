<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<%--basePath --%>
<c:set var="base" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}" />
<%--静态文件目录 --%>
<c:set var="path" value="${base}" />
<%--项目路径 --%>
<c:set var="staticPath" value="${base}" />

<input type="hidden" id="uploadifyFilePath" />
<div id="fileDialog">
	<iframe id="fileFrame" width="99%" height="99%" frameborder="no"></iframe>
</div>
<script type="text/javascript">
function initUploadFile(fileTypeDesc,fileTypeExts,size,sizeLimit){
	if(sizeLimit==undefined){
		sizeLimit=1000000;
	}
	var str = 'fileTypeDesc='+encodeURI(encodeURI(fileTypeDesc))+
		'&fileTypeExts='+fileTypeExts+'&size='+
		size+'&sizeLimit='+sizeLimit+'&filePath='+encodeURI(encodeURI($('#uploadifyFilePath').val()));
	$('#fileFrame').attr('src', basePath + '/fileHandle/uploadMain?' + str);
	$('#fileDialog').dialog({
		title:'文件上传',
		width:400,
		height:350,
		resizable : false,
		closed : false,
		modal : false,
		buttons : [{
			text:'上传',
			iconCls:'icon-upload',
			handler:function(){
				$('#fileFrame')[0].contentWindow.submitUploadFile();
			}
		}],
		onClose:function(){
			$('#fileFrame').removeAttr('src');
		}
	});
}
/**
 * 打开上传文件弹出框
 */
function openFileDialog(){
	$("#fileDialog").dialog("open");
}
/**
 * 关闭上传文件弹出框
 */
function closeFileDialog(){
	$("#fileDialog").dialog("close");
}
//删除和下载
function Attachment(attachmentId) {
	var obj = new Object();
	obj.attachmentId = attachmentId;
	obj.deleteAttachment = function() {
		var flag = false;
		$.ajax({
			url :basePath + '/fileHandle/deleteFileAndRecord' ,
			async : false,
			type : "post",
			data : {"id" : obj.attachmentId},
			dataType : "json",
			success : function(data){
				flag = true;
			},
			error : function (data){
				flag = false;
			}
		});

		return flag;
	};
	obj.download = function() {
		window.location = basePath + '/fileHandle/download?attachmentId=' + obj.attachmentId;
	};
	return obj;
}
</script>