<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看数据</title>
<script type="text/javascript" src="${staticPath }/static/capture/lookData.js" charset="utf-8"></script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',title:'已选币种',split:true" style="padding:5px;background:#eee;height:500px;">
    	<table id="dataGridChoose" data-options="fit:true,border:false"></table>
    </div>
    <div data-options="region:'center',title:'详情'" style="padding:5px;background:#eee;">
    	<table id="dataGridDetail" data-options="fit:true,border:false"></table>
    </div>
</body>
</html>