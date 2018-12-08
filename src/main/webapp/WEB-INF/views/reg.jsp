<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>通讯录注册页面</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="edge" />
		<link href="${staticPath }/static/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${staticPath }/static/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${staticPath }/static/assets/css/datepicker.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="${staticPath }/static/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<!-- <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" /> -->
		<link rel="stylesheet" href="${staticPath }/static/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${staticPath }/static/assets/css/ace-rtl.min.css" />
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${staticPath }/static/assets/css/ace-ie.min.css" />
		<![endif]-->
		<!--[if lt IE 9]>
		<script src="${staticPath }/static/assets/js/html5shiv.js"></script>
		<script src="${staticPath }/static/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">通讯录</span>
									<span class="white">系统</span>
								</h1>
								<h4 class="blue">&copy; EASY</h4>
							</div>

							<div class="space-6"></div>

							<!-- 提示 -->
							<!-- 模态框（Modal） -->
							<div class="modal fade" id="moneyType" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<div class="titletext">提示</div>
											<!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
												&times;
											</button> -->
										</div>
										<div class="modal-body">
											<h4 class="modal-title" id="myModalLabel">
												<div id="typeNameMes"></div>
											</h4>
										</div>
										<div class="modal-footer">
											<div class="pdapmodal-footer" id="parButton">
												  <button aria-hidden="true" onclick="" data-dismiss="modal" class="btn btn-primary">关闭</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												账号密码登录
											</h4>

											<div class="space-6"></div>

											<form>
												<fieldset>
													<div class="block clearfix">
														<div class="width-25 pull-left">
															<label style="font-size: 20px;">用户名:</label>
														</div>
														<span class="block input-icon input-icon-right width-70 pull-right">
															<input type="text" class="form-control" placeholder="用户名" />
															<i class="icon-user"></i>
														</span>
													</div>

													<div class="block clearfix">
														<div class="width-25 pull-left">
															<label style="font-size: 20px;">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
														</div>
														<span class="block input-icon input-icon-right width-70 pull-right">
															<input type="password" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
													</div>

													<div class="space"></div>

													<div class="clearfix">
														<button type="button" class="width-100 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															登录
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>
											
										</div><!-- /widget-main -->
										
										<div class="toolbar center" style="padding:9px 18px">
											<a style="font-size:14px" href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
												立即注册
												<i class="icon-arrow-right"></i>
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-group blue"></i>
												注册新用户
											</h4>

											<form>
												<fieldset>
													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">手机号码:</label>
														</div>
														<span class="block input-icon input-icon-right width-65 pull-right">
															<input type="text" class="form-control" placeholder="手机号码" />
															<i class="icon-phone-sign"></i>
														</span>
													</div>

													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">用&nbsp;&nbsp;户&nbsp;&nbsp;名:</label>
														</div>
														<span class="block input-icon input-icon-right width-65 pull-right">
															<input type="text" class="form-control" placeholder="登录用户名（最长14位英文字符或数字）" />
															<i class="icon-user"></i>
														</span>
													</div>

													<!-- S 自定义添加字段 -->
													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
														</div>
														<span class="block input-icon input-icon-right width-65 pull-right">
															<input type="text" class="form-control" placeholder="姓名（真实姓名）"/>
															<i class="icon-group" style="font-size: 13px;"></i>
														</span>
													</div>

													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
														</div>
														<span class="block input-icon input-icon-right btn-group dropdown width-65 pull-right">
																<select class="form-control" id="form-field-select-1">
																	<option value="">--请选择--</option>
																	<option value="0">男</option>
																	<option value="1">女</option>
																</select>
														</span>
													</div>
													
													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">出生日期:</label>
														</div>
														<span class="block input-icon input-icon-right width-65 pull-right">
															<input class="form-control date-picker" id="id-date-picker-1" readonly="readonly" type="text" data-date-format="yyyy-mm-dd" />
															<i class="icon-calendar bigger-110"></i>
														</span>
													</div>

													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</label>
														</div>
														<span class="block input-icon input-icon-right width-65 pull-right">
															<select class="form-control" id="form-field-select-1">
																<option value="">--请选择--</option>
																<option value="0">男</option>
																<option value="1">女</option>
															</select>
														</span>
													</div>
													
													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">乡&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;镇:</label>
														</div>
														<span class="block input-icon input-icon-right width-65 pull-right">
															<select class="form-control" id="form-field-select-1">
																<option value="">--请选择--</option>
																<option value="0">男</option>
																<option value="1">女</option>
															</select>
														</span>
													</div>

													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</label>
														</div>
														<span class="block input-icon input-icon-right width-65 pull-right">
															<input type="text" name="address" id="address" class="form-control" placeholder="详细地址" />
															<i class="icon-home" style="font-size: 15px;"></i>
														</span>
													</div>
													<!-- E 自定义添加字段 -->
													
													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">登录密码:</label>
														</div>
														<span class="block input-icon input-icon-right width-65 pull-right">
															<input type="password" class="form-control" placeholder="登录密码（6-16位英文数字或标点符号）" />
															<i class="icon-lock"></i>
														</span>
													</div>
													
													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">重复密码:</label>
														</div>
														<span class="block input-icon input-icon-right clearfix width-65 pull-right">
															<input type="password" class="form-control" placeholder="重复密码" />
															<i class="icon-lock"></i>
														</span>
													</div>
													
													<div class="block clearfix">
														<div class="width-30 pull-left">
															<label style="font-size: 20px;">短信验证:</label>
														</div>
														<button type="reset" id="btnMessage" onclick="sendmessage(this,180);" class="width-30 pull-right btn btn-sm btn-success" value="发送短信">
															发送短信
														</button>
														<div class="width-35 pull-right">
															<input id="shortMessage" name="shortMessage" type="text" class="form-control" placeholder="短信验证" />
														</div>
													</div>
													
													<div class="block clearfix">
														<div class="width-65 pull-right">
															未收到短信？请3分钟后重试！
														</div>
													</div>

													<div class="space"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="icon-refresh"></i>重新填写
														</button>

														<button type="button" onclick="reg()" class="width-65 pull-right btn btn-sm btn-success">
															<i class="icon-arrow-right icon-on-right"></i>注册
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												<i class="icon-arrow-left"></i>返回登录
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /signup-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->
		
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${staticPath }/static/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<!-- <![endif]-->

		<!--[if !IE]> -->
			<script src="${staticPath }/static/assets/js/jquery-2.0.3.min.js"></script>
		<!-- <![endif]-->
		<!--[if IE]>
			<script src="${staticPath }/static/assets/js/jquery-1.10.2.min.js"></script>
		<![endif]-->
		
		<!--[if IE]>
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${staticPath }/static/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->

		<script type="text/javascript" src="${staticPath }/static/assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${staticPath }/static/assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript" src="${staticPath }/static/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
		
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${staticPath }/static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

		<script type="text/javascript">
			$(function() {
				$('.date-picker').datepicker({
					language: 'cn',
					autoclose: true
				}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
			});
		
			function show_box(id) {
				jQuery('.widget-box.visible').removeClass('visible');
				jQuery('#'+id).addClass('visible');
			}
			
			function showDialogMsg(msg) {
				$("#typeNameMes").html(msg);
				$("#moneyType").modal("show");
			}
			
			function reg() {
				var shortMessage = $('#shortMessage').val();
				if (shortMessage) {
					// 验证注册码
					$.ajax({
						
					});
				} else {
					showDialogMsg('请填写短信验证码！');
				}
			}
			
			function sendmessage(obj,second){
				if(sendmessage){
					alert("发送短信");
					countDown(obj,second)
				}
				else{
					alert("错误，虽然永远走不到这里！");
				}
		    }
			function countDown(obj,second){
			    // 如果秒数还是大于0，则表示倒计时还没结束
			    if(second>=0){
			    	// 获取默认按钮上的文字
			        if(typeof buttonDefaultValue === 'undefined' ){
			        	buttonDefaultValue =  obj.defaultValue;
			    	}
			        // 按钮置为不可点击状态
			        obj.disabled = true;            
			        // 按钮里的内容呈现倒计时状态
			        // obj.value = buttonDefaultValue+'('+second+')';
			        $('#btnMessage').text('重新发送('+second+')');
			        // 时间减一
			        second--;
			        // 一秒后重复执行
			        setTimeout(function(){countDown(obj,second);},1000);
			        // 否则，按钮重置为初始状态
		        }else{
			        // 按钮置未可点击状态
			        obj.disabled = false;   
			        // 按钮里的内容恢复初始状态
			        // obj.value = buttonDefaultValue;
			        $('#btnMessage').text('发送短信');
		        }   
		    }
		</script>
</body>
</html>
