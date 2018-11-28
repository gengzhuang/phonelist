var dataGrid;

$(function() {
    dataGrid = $('#dataGrid').datagrid({
        url : basePath + '/anjian/dataGrid',
        fit : true,
        striped : true,
        rownumbers : true,
        pagination : true,
        singleSelect : true,
        idField : 'id',
        sortName : 'sort',
        sortOrder : 'asc',
        pageSize : 20,
        pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
        columns : [ [ {
            width : '120',
            title : '文件名称',
            field : 'fileName'
        }, {
            width : '80',
            title : '文件类别',
            field : 'fileType'
        }, {
            width : '80',
            title : '上传时间',
            field : 'uptimeStr',
            align : 'center'
        }, {
            width : '100',
            title : '上传机构',
            field : 'orgName',
        }, {
            width : '80',
            title : '文件大小',
            field : 'fileSize',
        }, {
            width : '100',
            title : '上传人',
            field : 'userName',
            align : 'center'
        }, {
            field : 'action',
            title : '操作',
            width : 130,
            formatter : function(value, row, index) {
                var str = '';
            	var edit = $('#edit');
            	var deleted = $('#deleted');
            	str += $.formatString('<a href="javascript:void(0)" class="user-easyui-linkbutton-download" data-options="plain:true,iconCls:\'icon-save\'" onclick="editFun(\'{0}\');" >下载</a>', row.id);
            	str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
            	str += $.formatString('<a href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.id);
                str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                str += $.formatString('<a href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.id);
                return str;
            }
        }] ],
        onLoadSuccess:function(data){
        	$('.user-easyui-linkbutton-download').linkbutton({text:'下载',plain:true,iconCls:'icon-save'});
            $('.user-easyui-linkbutton-edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
            $('.user-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
        },
        toolbar : '#toolbar'
    });
});
    
/***************************************** 函数 *************************************************/

/**
 * 添加
 * 
 */
function addFun() {
	parent.$.modalDialog({
        title : '添加',
        width : 500,
        height : 300,
        href : basePath + '/dict/addPage',
        buttons : [ {
            text : '添加',
            handler : function() {
                parent.$.modalDialog.openner_dataGrid = dataGrid; //因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                var f = parent.$.modalDialog.handler.find('#dictAddForm');
                f.submit();
            }
        } ]
    });
}

/**
 * 删除
 * 
 * @param id
 */
function deleteFun(id) {
    parent.$.messager.confirm('询问', '您是否要删除当前数据？', function(b) {
        if (b) {
        	progressLoad();
            $.post(basePath + '/anjian/delete', {
                id : id
            }, function(result) {
                if (result.success) {
                	easyShow(result.msg);
                    dataGrid.datagrid('reload');
                }
                progressClose();
            }, 'JSON');
        }
    });
}

/**
 * 编辑页面
 * 
 * @param id
 */
function editFun(id) {
    parent.$.modalDialog({
        title : '编辑',
        width : 500,
        height : 300,
        href : basePath + '/anjian/editPage?id=' + id,
        buttons : [ {
            text : '确定',
            handler : function() {
                parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                var f = parent.$.modalDialog.handler.find('#dictAddForm');
                f.submit();
            }
        } ]
    });
}

/**
 * 上传
 * 
 */
function uploadFun() {
	$('#uploadifyFilePath').val("/indexExcel");
	initUploadFile('请选择Excel文件','*.xls',1);
}

/**
 * Excel导入回调函数
 * 
 * @param data
 */
uploadFileFunc = function(data) {
	progressLoad()
	$.ajax({
		url : 'uploadDatasource',
		data : {
			id : data.id
		},
		dataType : 'json',
		type : 'post',
		success : function(data) {
			progressClose();
			easyShow(data.message);
		},
		error : function() {
			progressClose();
			easyShow("请求失败");
		}
	});
}
