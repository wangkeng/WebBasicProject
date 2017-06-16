<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/page/common/script.jsp"%>
<%@ include file="/WEB-INF/page/common/easyuiScript.jsp"%>
<script src="${ctx}/js/myJs/user/list.js"></script>
</head>

<body class="padding-10">
<input type="hidden" id="ctxValue" value="${ctx}">
	<div class="row">
		<form id="searchForm" class="form-inline" >
			<div class="form-group">
				<label for="account">用户账号：</label> <input type="text"
					class="form-control" id="account" placeholder="注册手机号" value="${userQuery.account}">
			</div>
			<div class="form-group">
				<label for="name">昵称:</label> <input type="text"
					class="form-control" id="name" placeholder="昵称" value="${userQuery.name}">
			</div>
			<div class="form-group">
				<label for="account">类型:</label> 
				 <select id="cc" name="category" class="form-control" style="height:34px;width:196px"></select>
			</div>
			<div class="form-group">
				<button type="button" id="searchBtn" class="btn btn-primary">查询</button>
				<button type="button" id="cancelBtn" class="btn btn-default">取消</button>
			</div>
		</form>
	</div>
	<div style="margin-top:20px;margin-bottom: 5px;padding-top:5px;border-top: 1px solid #e7e7e7 ;">
		<button type="button" id="addBtn" class="btn btn-primary">新增用户</button>
		<button type="button" id="delBtn" class="btn btn-danger">批量删除</button>
	</div>
	<table id="querylist">
	</table>
	<div class="height-40"></div>
 
</body>
</html>
