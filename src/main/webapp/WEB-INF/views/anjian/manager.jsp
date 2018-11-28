<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据源录入</title>
<script type="text/javascript" src="${staticPath }/static/anjian/manager.js" charset="utf-8"></script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<input type="hidden" id="edit" />
	<input type="hidden" id="deleted" />
    
    <div data-options="region:'center',border:true" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    
    <div id="toolbar">
        <a onclick="uploadFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">上传</a>
    </div>
    <%@ include file="/commons/uploadify.jsp"%>
</body>
</html>