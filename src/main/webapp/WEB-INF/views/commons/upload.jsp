<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>
<%@ include file="/commons/basejs.jsp"%>
<script type="text/javascript">
    var basePath = "${staticPath }";
</script>
<link href="${base }/static/plugins/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base }/static/plugins/uploadify/jquery.uploadify.js"></script>
<script type="text/javascript">
var uploadFileNum =0;
var uploadFileQueue=0;
var realPath;
var realname;
var uploadFileFunc;
$(function(){
	$("#uploadFileFunc").uploadify({
		'formData' : {'path': '${filePath}'},    	
	    'swf' : basePath + '/static/plugins/uploadify/uploadify.swf',
	    'uploader' : basePath + '/fileHandle/upload;jsessionid=' + $('#sessionId').val(),
	    'cancelImg' : basePath + '/static/plugins/uploadify/uploadify-cancel.png',
	    'buttonText' : '浏览文件',
	    'queueID' : 'fileQueue',
	    'auto' : false,
	    'fileTypeDesc' : '${fileTypeDesc}',
		'fileTypeExts' : '${fileTypeExts}',  
	    'width' : '60',
	    'height' : '24',
	    'queueSizeLimit' : '${size}',
	    'multi':'${multi}',
	    'removeTimeout' : 0.6,
	    'sizeLimit' : '${sizeLimit}',
	    'debug' : false,
	    'onUploadStart' : function(file) {
	    	$("#uploadFileFunc").uploadify("settings", "formData",{'path': '${filePath}'});
	    },
	    'onUploadSuccess' : function(file, data, response) {
	    	uploadFileNum++;
	    	data = JSON.parse(data);
	    	onUploadSuccess(data, uploadFileFunc);
	    	if(!response){
	    		//window.parent.easyShow('上传失败');
	    	}else{
		    	//window.parent.easyShow('上传成功');
		    	uploadFileNum = 0;
	    		window.parent.closeFileDialog();
	    	}
	    }
	});
});
/**
 * 执行上传文件
 */
function submitUploadFile() {
	if($('#fileQueue>div').length!=0){
		fileQueue=$('#fileQueue>div').length;
		$('#uploadFileFunc').uploadify('upload','*');
	}else{
		window.parent.easyShow('请添加附件!');
	}
}

/**
 * 上传成功回调函数
 */
function onUploadSuccess(data, uploadFileFunc) {
	parent.uploadFileFunc(data);
}
</script>
</head>
<body class="easyui-layout">
<input id="sessionId" type="hidden" value="${pageContext.session.id}"/>  
	<div data-options="region:'center',border:false">
		<div id="fileQueue" style="width:100%;height:90%"></div>
	</div>
	<div data-options="region:'south',border:false" style="height:27px;border-top:1px solid #DDDDDD">
		<input id="uploadFileFunc" name="uploadFileFunc" type="file" multiple="true" />
	</div>
</body>
</html>