<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/page/common/script.jsp"%>
<%@ include file="/WEB-INF/page/common/easyuiScript.jsp"%>
<script src="${ctx}/js/myJs/user/add.js"></script>
</head>

<body>
<input type="hidden" id="ctxValue" value="${ctx}">
	<div class="container">
		<form id="defaultForm" style="width:100%""
			class="form-horizontal">
			
			<table style="width:100%">
				<tr>
					<td>
					<!-- 下面这个div必须要有，插件根据这个进行添加提示 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">手机号<span style="color:red">*</span></label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="account" placeholder="请输入您的手机号"/>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
					<!-- 下面这个div必须要有，插件根据这个进行添加提示 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">昵称<span style="color:red">*</span></label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name" placeholder="请输入您的昵称(6-20位数字或字符组成)"/>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-group">
							<label class="col-sm-2 control-label">分类<span style="color:white">*</span></label>
							<div class="col-sm-10">
								  <select id="cc" name="category" class="form-control" style="height:34px;width:100%" />
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
					<!-- 下面这个div必须要有，插件根据这个进行添加提示 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">邮箱<span style="color:white">*</span></label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="mail" placeholder="请输入您的邮箱"/>
							</div>
						</div>
					</td>
				</tr>
			</table>
			


			<div class="row">
				<div style="width:100%; text-align: center;margin-top:20px">
					<div class="form-group" style="margin:0 auto;">
						<button type="button" id="submitBtn" class="btn btn-primary"
							style="width:40%">确定</button>
						<button type="button" id="cancelBtn" class="btn btn-default"
							style="width:40%">取消</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	
</body>
</html>
