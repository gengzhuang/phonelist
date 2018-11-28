<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>抓取数据</title>
<script type="text/javascript" src="${staticPath }/static/capture/setCapture.js" charset="utf-8"></script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',title:'全部币种',split:true" style="padding:5px;background:#eee;height:500px;">
    	<table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div data-options="region:'center',title:'已选币种'" style="padding:5px;background:#eee;">
    	<table id="dataGridChoose" data-options="fit:true,border:false"></table>
    </div>
    
    <div id="toolbar">
    	<a onclick="addCoinType();" href="javascript:void(0);" 
    		class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">增加币种</a>
    </div>
    
    <div id="toolbarChoose">
    	<a onclick="delCoinType();" href="javascript:void(0);" 
    		class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-del'">删除币种</a>
    </div>
</body>
</html>