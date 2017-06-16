var ctx ;
$(function() {
	ctx = $('#ctxValue').val();
    $('#cc').combotree({
        url:ctx+'/userCategory/getList.json',
        panelHeight:200
    });
	
	$('#searchBtn').click(function () {  
		refreshTable();  
    });  
	
	$('#cancelBtn').click(function () {  
		$("#searchForm :input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").remove("selected");
		refreshTable();
    });  
	
	$('#addBtn').click(function () {  
		parent.openDialog('first',800,300,'新增用户',ctx+'/index/goPage.view?pathName=user/add');
    });  
	
	$('#delBtn').click(function () {  
		var ids = getIdSelections();
		if(!checkNull(ids)){
			parent.swal({
				title : "确定删除吗？",
				text : "你将无法恢复该信息！",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "确定删除！",
				closeOnConfirm : false
			}, function() {
				$.ajax({
					type : 'POST',
					url : ctx+'/user/deleteBatch.json',
					data : {ids:ids},
					dataType : 'json',
					success : function(result) {
						parent.evalFun('refreshTable()');
						parent.closeDialog('first');
						parent.swal({title: '删除成功', text: '正在刷新数据', type :'success', timer: 1000,showConfirmButton: false  });
					},
					error : function(result) {
						parent.swal({title: '删除失败',text: '服务器傻掉啦~', type :'error', confirmButtonText :'确定' });
					}
				});
			});
		}else{
			parent.swal({title: '操作失败',text: '请选择要删除的内容~', type :'error', confirmButtonText :'确定' });
		}
    });  
	
	//1.初始化Table
	var oTable = new TableInit();
	oTable.Init();
	
});

//跳转到修改页面
function goUpdate(id){
	parent.openDialog('first',800,280,'修改用户',ctx+'/user/update.view?id='+id);
}

//单条删除
function goDelete(id){
	parent.swal({
		title : "确定删除吗？",
		text : "你将无法恢复该信息！",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "确定删除！",
		closeOnConfirm : false
	}, function() {
		$.ajax({
			type : 'POST',
			url : ctx+'/user/deleteById.json',
			data : {id:id},
			dataType : 'json',
			success : function(result) {
				parent.evalFun('refreshTable()');
				parent.closeDialog('first');
				parent.swal({title: '删除成功', text: '正在刷新数据', type :'success', timer: 1000,showConfirmButton: false  });
			},
			error : function(result) {
				parent.swal({title: '删除失败',text: '服务器傻掉啦~', type :'error', confirmButtonText :'确定' });
			}
		});
	});
}


var TableInit = function() {
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function() {
		$('#querylist').bootstrapTable({
			striped : true,//條紋行 
			pagination : true, //是否显示分页（*）
			sortable : false,
			cache: false,
			sidePagination : 'server',
			pageNumber : 1,
			pageSize : 15,
			pageList : [ 15, 30, 50 ],
			queryParams : oTableInit.queryParams,
			uniqueId: "id",
			columns : [ {
                checkbox: true,
                width:100
            }, {
				field : 'name',
				title : '昵称',
				editable : {
					type : 'text',
					validate : function(value) {
						if ($.trim(value) == '') {
							return '测量值不能为空';
						}
					}
				}
			}, {
				field : 'password',
				title : 'password',
				sortable : true
			}, {
				field : 'description',
				title : '描述',
				sortable : true
			}, {
				field : 'createtime',
				title : '创建时间',
				sortable : true
			}, {
				field : 'sex',
				title : '性别',
				sortable : true
			}, {
				field : 'account',
				title : '账号',
				sortable : true
			}, {
				field : 'category',
				title : '分类',
				sortable : true
			}, {
				field : 'autoName',
				title : 'autoName',
				sortable : true
			},{
				field:'id',
				title:'操作',
				align:'center',
				formatter : operateFormatter1,
				edit:false
			}],
			url : ctx+'/user/getList.json',
			queryParams : oTableInit.queryParams,//传递参数（*）
		});
	};

	function operateFormatter1(value){
		return "<a onclick=\"goUpdate('"+value+"')\" style=\"cursor:pointer\">编辑<a/>"+"<a onclick=\"goDelete('"+value+"')\" style=\"cursor:pointer;color:#EE3B3B\">删除<a/>";
	}
	//得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit : params.limit, //页面大小
			offset : params.offset, //页码
			name : $('#name').val(),
			account : $('#account').val()
		};
		return temp;
	};
	return oTableInit;	
};

//刷新表格
function refreshTable(){
	$('#querylist').bootstrapTable('refresh', {url: ctx+'/user/getList.json'});  
}


//获取bootstrapTable选中的checkBox
function getIdSelections() {
    return $.map($('#querylist').bootstrapTable('getSelections'), function(row) {
    	return row.id
    })+"";
}
