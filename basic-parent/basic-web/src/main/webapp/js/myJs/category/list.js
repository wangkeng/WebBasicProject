var ctx;
$(function() {
	ctx = $('#ctxValue').val();

	jQuery("#treeTeable").jqGrid({
		url : ctx + '/userCategory/getTreeList.json',
		datatype : "json",
		width : $(window).width() - 20,
		treeGrid : true,
		forceFit : true,
		treeGridModel : 'adjacency',
		shrinkToFit : true,
		ExpandColumn : 'name',
		colNames : [ 'id', '类型', '标签', '创建时间', '描述' ],
		ExpandColClick : true,
		mtype : "POST",
		colModel : [ {
			name : 'id',
			index : 'id',
			hidden : true
		}, {
			name : 'name',
			index : 'name',
			width : 80,
			align : 'center',
			sortable : false
		}, {
			name : 'tagList',
			index : 'tagList',
			width : 200,
			sortable : false
		}, {
			name : 'createTime',
			index : 'createTime',
			width : 80,
			align : 'center',
			sortable : false
		}, {
			name : 'description',
			index : 'description',
			width : 200,
			sortable : false
		}, ],
		pager : "false",
		jsonReader : {
			root : "jsonObject",
			repeatitems : false
		},
		treeReader : {
			level_field : "level",
			parent_id_field : "rid",
			leaf_field : "isLeaf",
			expanded_field : "expanded"
		},
		height : 'auto'
	});

	$("#treeTeable").closest(".ui-jqgrid-bdiv").css({
		"overflow-x" : "hidden"
	});

	$('#addBtn').click(function() {
		addView();
	});

	$('#updateBtn').click(function() {
		updateView();
	});
});

function addView() {
	var id = jQuery("#treeTeable").jqGrid('getGridParam', 'selrow');
	if (checkNull(id)) {
		parent.swal({
			title : '操作失败',
			text : '请选择父节点',
			type : 'error',
			confirmButtonText : '确定'
		});
	} else {
		parent.openDialog('first', 800, 250, '新增用户', ctx
				+ '/userCategory/addView.view?parentId=' + id);
	}
}

function updateView() {
	var id = jQuery("#treeTeable").jqGrid('getGridParam', 'selrow');
	if (checkNull(id)) {
		parent.swal({
			title : '操作失败',
			text : '请选择父节点',
			type : 'error',
			confirmButtonText : '确定'
		});
	} else {
		parent.openDialog('first', 800, 250, '新增用户', ctx
				+ '/userCategory/updateView.view?id=' + id);
	}
}

function add(postData) {
	var rowData = jQuery("#treeTeable").jqGrid('getRowData',
			jQuery("#treeTeable").jqGrid('getGridParam', 'selrow'));
	$.ajax({
		url : ctx + '/userCategory/add.json',
		type : 'post',
		dataType : 'json',
		data : postData,
		success : function(data) {
			console.info(data);
			jQuery("#treeTeable").jqGrid('addChildNode', data.id, rowData.id,
					data);
			parent.closeDialog('first');
			parent.swal({
				title : '保存成功',
				text : '正在刷新数据',
				type : 'success',
				timer : 1000,
				showConfirmButton : false
			});
		},
		error : function(data) {
			parent.swal({
				title : '保存失败',
				text : '服务器傻掉啦~',
				type : 'error',
				confirmButtonText : '确定'
			});
		}
	});
}

function update(postData) {
	$.ajax({
		url : ctx + '/userCategory/update.json',
		type : 'post',
		dataType : 'json',
		data : postData,
		success : function(data) {
			console.info(data);
			jQuery("#treeTeable").jqGrid('setRowData', data.id, data);
			parent.closeDialog('first');
			parent.swal({
				title : '修改成功',
				text : '正在刷新数据',
				type : 'success',
				timer : 1000,
				showConfirmButton : false
			});
		},
		error : function(data) {
			parent.swal({
				title : '修改失败',
				text : '服务器傻掉啦~',
				type : 'error',
				confirmButtonText : '确定'
			});
		}
	});
}