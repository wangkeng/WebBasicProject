<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/page/common/script.jsp"%>
<%@ include file="/WEB-INF/page/common/jqGridScript.jsp"%>
    <script src="${ctx}/js/myJs/category/list.js"></script>
</head>

<body style="padding:10px">
<input type="hidden" id="ctxValue" value="${ctx}">

	<h2>用户分类管理</h2>
	<div style="margin-top:20px;margin-bottom: 5px;padding-top:5px;border-top: 1px solid #e7e7e7 ;">
		<button type="button" id="addBtn" class="btn btn-primary">新增</button>
		<button type="button" id="updateBtn" class="btn btn-info">修改</button>
		<button type="button" id="delBtn" class="btn btn-danger">删除</button>
	</div>
	<table id="treeTeable"></table>
	<div class="height-40"></div>
</body>
</html>
