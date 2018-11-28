<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<html>
<head>	
    <title>系统注册</title>
    <%@ include file="/commons/basejs.jsp" %>
    <link rel="stylesheet" type="text/css" href="${staticPath }/static/style/css/reg.css" />
    <script type="text/javascript" src="${staticPath }/static/reg/manager.js" charset="utf-8"></script>
    <script type="text/javascript" src="${staticPath }/static/reg/md5.js" charset="utf-8"></script>
    <script type="text/javascript" src="${staticPath }/static/reg/jquery.i18n.properties-1.0.9.js" charset="utf-8"></script>
    <script type="text/javascript" src="${staticPath }/static/reg/jquery.validate.js" charset="utf-8"></script>
    <script type="text/javascript" src="${staticPath }/static/reg/page_regist.js?lang=zh" charset="utf-8"></script>
    <script type="text/javascript" src="${staticPath }/static/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<style type="text/css">
	tr th{
		text-align: right;
	}
	table{
		border: 0;
		margin-top: 10px;
	}
</style>
<body class="loginbody">
	<div class="dataEye">
		<div class="loginbox registbox">
			<div class="login-content reg-content">
				<div class="loginbox-title">
					<h3>注册</h3>
				</div>
				<form id="formInput" method="post">
					<div class="login-error"></div>
						<div class="row">
							<label class="field" for="loginname">用户名：</label>
							<input type="text" id="loginname" name="loginname"
								class="input-text-user noPic input-click easyui-validatebox" validType="loginname" data-options="required:true"/>
						</div>
						<div class="row">
							<label class="field" for="password1">密码：</label>
							<input id="password1" name="password1" validType="length[4,32]" 
							class="input-text-user noPic input-click easyui-validatebox" required="true" type="password" />
						</div>
						<div class="row">
							<label class="field" for="password">确认密码：</label>
							<input type="password" name="password" id="password" required="true" class="input-text-user noPic input-click easyui-validatebox" 
							 validType="equalTo['#password1']" />
						</div>
						<div class="row">
							<label>性别：</label>
							<input type="radio" id="sex1" value="0" name="sex"/>男
							<input type="radio" id="sex2" value="1" name="sex"/>女
						</div>
						<div class="row">
							<label class="field" for="phone">手机号码：</label>
							<input type="text" id="phone" name="phone" 
								class="input-text-user noPic input-click easyui-ValidateBox" validtype="mobile" data-options="required:true"/>
						</div>
						<div class="row">
							<td colspan="2" >
								<button type="button" onClick="submitForm();">注册</button>
								<button class="submit_3" type="reset" onclick="javascript:;">重置</button>
								<button class="submit_2" type="button" onclick="returnMethod();">返回</button>
							</td>
						</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>