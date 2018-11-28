;
$(function() {
	$('#formInput').form({
	    url : basePath + '/reg/add',    
	    onSubmit: function() {
			var isValid = $(this).form('validate');
			if (!isValid){
				
			}
			return isValid;	// 返回false终止表单提交
	    },    
	    success : function(result) {
	    	progressClose();
            result = $.parseJSON(result);
            if (result.success) {
            	$.ajax({
                    type: "post",
                    url: basePath+'/login',
                    async: false,
                    data: { "username":$('#loginname').val(),
                    	"password":$('#password').val(),
                    },
//                    success: function (data, status) {
//                        var types = data;
//                        if (types.toString() != "登录成功") {
//                        }
//                        else{
//                        window.location.href = basePath + '/index';
//                        }
//                    },
                    success:function(result){
                        progressClose();
                        result = $.parseJSON(result);
                        if (result.success) {
                            window.location.href = basePath + '/index';
                        }else{
                            $.messager.show({
                                title:'提示',
                                msg:'<div class="light-info"><div class="light-tip icon-tip"></div><div>'+result.msg+'</div></div>',
                                showType:'show'
                            });
                        }
                    },
                    error: function () { alert("用户名密码验证失败") }
                    
                });
            } else {
                parent.$.messager.alert('注册失败 ', result.msg, 'error');
            }
	    },	
	    error:function(){

	    }
	});    
	
});

/**
 * 返回
 * 
 */
function returnMethod(){
	window.location = basePath+'/login';
}

/**
 * 提交表单
 */
function submitForm() {
	$('#formInput').submit();
	
}

/**
 * 验证昵称是否存在
 */
/*function checkloginname(){
	$.ajax({
		url : basePath + "/reg/checkLoginName" ,
		type : "post" ,
		data : {
			"loginname":$('#loginname').val()
		} ,
		dataType : "json",
		success : function(result) {
            //result = $.parseJSON(result);
            //if (result.success) {
            	//parent.$.messager.alert('用户名已存在 ', result.msg, 'error');
            	if (result > 0) {
            		parent.$.messager.alert('提示 ', '用户名已存在', 'error');
            	}
            } else {
            	parent.$.messager.alert('发生错误', result.msg, 'error');
            }
		},
		error : function() {
			alert("注册发生异常");
		}
	});
}*/

/**
 * 验证用户名是否存在
 */
function checkname(){
	
}

