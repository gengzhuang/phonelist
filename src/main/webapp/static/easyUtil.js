function getObjToIds(arr) {
	var array = new Array();
	if (arr && arr.length > 0) {
		for (var i = 0, j = arr.length; i < j; i++) {
			array[i] = arr[i].id;
		}
	}
	return array;
}
/**
 * 消息提示
 */
function easyShow(msg) {
	$.messager.show({
        title:'提示',
        msg:'<div class="light-info"><div class="light-tip icon-tip"></div><div>' + msg + '</div></div>',
        showType:'slide',
        timeout : 2000
    });
	/*
	$.messager.show({
		title : '消息提示',
		msg : msg,
		timeout : 2000,
		showType : 'slide'
	});*/
}
/**
 * 宽度百分比
 */
function fixWidth(percent) {
	return document.body.clientWidth * percent; // 这里你可以自己做调整
}
/**
 * easyui dialog封装 seltor 例如："#id" ".class" buttonId(不写也可) 例如："#id" 或是数组 [ {
 * text : "新增", iconCls : 'icon-add', handler : function() {
 * $('#win').window('open'); } }]
 * 
 */

function easyDialog(seltor, title, width, height, buttonId,obj) {
	$(seltor).css("display", "block");
	$(seltor).dialog({
		title : title,
		width : width,
		height : height,
		resizable : false,
		// maximizable : true,
		// minimizable : true,
		// collapsible : true,
		closed : true,
		modal : true,
		buttons : buttonId,
		onOpen:function(){
			if(obj){
				if(obj.openFunc){
					obj.openFunc();
				}
			}
		},
		onClose:function(){
			if(obj){
				if(obj.func){
					obj.func();
				}
			}
		}
	});
}
/**
 * 扩展validatebox，添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules, {
	eqPassword : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '密码不一致！'
	}
});

/**
 * 转换tree数据
 * @param rows
 * @param name
 * @param id
 * @param pId
 * @returns {Array}
 */
function convertTree(rows,name,id,pId){  
	if(name==null){
		name="name";
	}
	
	if(id==null){
		id="id";
	}
	if(pId==null){
		pId="parentId";
	}
	
    function exists(rows, parentId){  
        for(var i=0; i<rows.length; i++){  
            if (JSON.parse(JSON.stringify(rows[i]))[id] == parentId) return true;  
        }  
        return false;  
    }  
      
    var nodes = [];  
    // 得到顶层节点
    for(var i=0; i<rows.length; i++){  
        var row = rows[i];  
        if (!exists(rows, JSON.parse(JSON.stringify(row))[pId])){  
        	row.text = JSON.parse(JSON.stringify(row))[name];
            nodes.push(row);  
        }  
    }  
    var toDo = [];  
    for(var i=0; i<nodes.length; i++){  
        toDo.push(nodes[i]);  
    }  
    while(toDo.length){  
        var node = toDo.shift();    // 父节点 
        // 得到子节点 
        for(var i=0; i<rows.length; i++){  
            var row = rows[i];  
            if (JSON.parse(JSON.stringify(row))[pId] == JSON.parse(JSON.stringify(node))[id]){ 
            	row.text = JSON.parse(JSON.stringify(row))[name];
                if (node.children){  
                    node.children.push(row);  
                } else {  
                    node.children = [row];  
                }  
                toDo.push(row);  
            }  
        }  
    }  
    return nodes;  
}  
/**
* EasyUI DataGrid根据字段动态合并单元格
* 参数 tableID 要合并table的id
* 参数 colList 要合并的列,用逗号分隔(例如："name,department,office");
*/
function mergeCellsByField(tableID, colList) {
    var ColArray = colList.split(",");
    var tTable = $("#" + tableID);
    var TableRowCnts = tTable.datagrid("getRows").length;
    var tmpA;
    var tmpB;
    var PerTxt = "";
    var CurTxt = "";
    var alertStr = "";
    for (j = ColArray.length - 1; j >= 0; j--) {
        PerTxt = "";
        tmpA = 1;
        tmpB = 0;

        for (i = 0; i <= TableRowCnts; i++) {
            if (i == TableRowCnts) {
                CurTxt = "";
            }
            else {
                CurTxt = tTable.datagrid("getRows")[i][ColArray[j]];
            }
            if (PerTxt == CurTxt&&CurTxt != null&&CurTxt != "") {
                tmpA += 1;
            }
            else {
                tmpB += tmpA;
               
                tTable.datagrid("mergeCells", {
                    index: i - tmpA,
                    field: ColArray[j],//合并字段
                    rowspan: tmpA,
                    colspan: null
                });
                tTable.datagrid("mergeCells", { //根据ColArray[j]进行合并
                    index: i - tmpA,
                    field: "Ideparture",
                    rowspan: tmpA,
                    colspan: null
                });
              
                tmpA = 1;
            }
            PerTxt = CurTxt;
        }
    }
}
/**
 * easyui datagrid 行移动
 * 
 */
function gridRowsort(gridname,index,type){  
	if(type){
		 var todown = $('#'+gridname).datagrid('getData').rows[index];  
         var toup = $('#'+gridname).datagrid('getData').rows[index+1];  
         $('#'+gridname).datagrid('getData').rows[index+1] = todown;  
         $('#'+gridname).datagrid('getData').rows[index] = toup;  
         $('#'+gridname).datagrid('refreshRow',index);  
         $('#'+gridname).datagrid('refreshRow',index+1);  
         $('#'+gridname).datagrid('selectRow',index+1);  
	}else{
		var toup = $('#'+gridname).datagrid('getData').rows[index];  
        var todown = $('#'+gridname).datagrid('getData').rows[index-1];  
        $('#'+gridname).datagrid('getData').rows[index] = todown;  
        $('#'+gridname).datagrid('getData').rows[index-1] = toup;  
        $('#'+gridname).datagrid('refreshRow',index);  
        $('#'+gridname).datagrid('refreshRow',index-1);  
        $('#'+gridname).datagrid('selectRow',index-1); 
	}
}  
/**
 * 防止panel/window/dialog组件超出浏览器边界
 * @param left
 * @param top
 */
var easyuiPanelOnMove = function(left, top) {
	var l = left;
	var t = top;
	if (l < 1) {
		l = 1;
	}
	if (t < 1) {
		t = 1;
	}
	var width = parseInt($(this).parent().css('width')) + 14;
	var height = parseInt($(this).parent().css('height')) + 14;
	var right = l + width;
	var buttom = t + height;
	var browserWidth = $(window).width();
	var browserHeight = $(window).height();
	if (right > browserWidth) {
		l = browserWidth - width;
	}
	if (buttom > browserHeight) {
		t = browserHeight - height;
	}
	$(this).parent().css({/* 修正面板位置 */
		left : l,
		top : t
	});
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;