<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
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

    <link href="${ctx}/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/sb-admin-2/sb-admin-2.css" rel="stylesheet">
    <link href="${ctx}/css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href= "${ctx}/plugins/sweetalert-master/dist/sweetalert.css" rel="stylesheet"></link>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    
    	.modal.in .modal-dialog{-webkit-transform:translate(0,-50%);-ms-transform:translate(0,-50%);-o-transform:translate(0,-50%);transform:translate(0,-50%)}
    	@media (min-width:768px){.modal-dialog{width:600px}
    </style>
</head>

<body>
<input type="hidden" id="ctxValue" value="${ctx}">
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" id="menuButton" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">后台管理</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i>个人中心</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i>设置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html" style="color:red"><i class="fa fa-sign-out fa-fw"></i>退出</a>
                        </li>
                    </ul>
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                        </li>
                        <li>
                            <a href="${ctx}/index/goPage.view?pathName=user/category/list" target="content" class="active" id="MenutopIten"><i class="fa fa-dashboard fa-fw"></i>首页</a>
                        </li>
                        <li>
                            <a href="#" id="MenutopIten"><i class="fa fa-bar-chart-o fa-fw"></i>用户管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
		                            <a href="${ctx}/index/goPage.view?pathName=user/list" target="content" id="menuItem"><i class="fa fa-user"></i>用户管理</a>
		                        </li>
                                <li>
                                    <a href="${ctx}/index/goPage.view?pathName=user/category/list" target="content" id="menuItem"><i class="fa fa-cubes"></i>用户分类管理</a>
                                </li>
                                
                                 <li>
                                    <a href="${ctx}/index/goPage.view?pathName=editor/editor" target="content" id="menuItem">ueditor</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="page-wrapper">
        	<iframe  src="${ctx}/index/goPage.view?pathName=user/category/list"  scrolling="auto" name="content" id="content"  onload="changeFrameHeight()" style="width:100%;border:0px"></iframe>
        </div>
        <!-- /#page-wrapper -->
        
        
        
	    <div class="modal fade" id="firstDialogModal" tabindex="-1" role="dialog" aria-labelledby="firstDialogLabel" >  
		    <div class="modal-dialog" role="document" id="firstDialog" style="position:absolute;width:auto;margin:10px auto;left:0;right:0;top:40%">  
		        <div class="modal-content">  
		            <div class="modal-header">  
		                <button type="button" class="close" data-dismiss="modal" aria-label="Close">  
		                    <span aria-hidden="true">×</span>  
		                </button>  
		                <h4 class="modal-title" id="firstDialogLabel"></h4>  
		            </div>  
		            <div class="modal-body" id="firstDialogBody">  
		               	<iframe  src="${ctx}/index/goPage.view?pathName=blank" id="firstDialogFrame"  style="width:100%;border:0px"></iframe>
		       		</div>  
		        </div>  
		    </div>  
		</div> 

    </div>
    <!-- /#wrapper -->

    <script src="${ctx}/js/jquery/jquery.min.js"></script>

    <script src="${ctx}/js/bootstrap/bootstrap.min.js"></script>

    <script src="${ctx}/js/metisMenu/metisMenu.min.js"></script>
    
    <script src="${ctx}/js/sb-admin-2/sb-admin-2.js"></script>
    
    <script src="${ctx}/js/myJs/index.js"></script>
    
    <script src="${ctx}/plugins/sweetalert-master/dist/sweetalert.min.js"></script>

</body>
</html>
