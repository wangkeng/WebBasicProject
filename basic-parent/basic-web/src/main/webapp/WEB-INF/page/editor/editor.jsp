<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>后台管理</title>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <link href="${ctx}/css/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>

<body style="padding:10px;">

	<form action="${ctx}/ueditor/testUeditor.html" method="post">
	    <div  id="container" name="content" type="text/plain" style="height:200px"></div>
	    
	    <input type="submit" value="go"  id="button" name="button"/>
    </form>
    <script src="${ctx}/js/jquery/jquery.min.js"></script>
	<script src="${ctx}/js/bootstrap/bootstrap.min.js"></script>
    <!-- 配置文件 -->
    <script src="${ctx}/plugins/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script src="${ctx}/plugins/ueditor/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script>
        var ue = UE.getEditor('container');
        
        $(function(){
        	$('#button').click(function(){
        		var html = ue.getContent();
            	//获取纯文本内容
            	var text = ue.getContentTxt();
            	
            	console.info(html);
            	console.info("-----------------");
            	console.info(text);
        	});
        });
    </script>
</body>
</html>
