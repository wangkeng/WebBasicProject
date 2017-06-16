<%@page language="java" pageEncoding="UTF-8"%>
<link href="${ctx}/css/jqGrid/ui.jqgrid.css" rel="stylesheet" />
<link href="${ctx}/css/jqGrid/jquery-ui.css" rel="stylesheet" />
<script src="${ctx}/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="${ctx}/js/jqGrid/grid.treegrid.js"></script>
<script src="${ctx}/js/jqGrid/grid.locale-cn.js"></script>

 <style type="text/css">
	.ui-jqgrid tr.jqgrow td {
    font-weight: normal;
    overflow: hidden;
    white-space: pre;
    height: 42px;
    padding: 0 2px 0 2px;
    border-bottom-width: 1px;
    border-bottom-color: inherit;
    border-bottom-style: solid;
	}
	.ui-jqgrid .ui-jqgrid-htable th div {
    overflow: hidden;
    position: relative;
    text-align:center;
    height: 43px;
    line-height:43px;   
	}
	.ui-icon, .ui-widget-content .ui-icon {
    background-image: url("${ctx}/css/jqGrid/images/ui-icons_444444_256x240.png");
    margin-top: 2px;
	}
	</style>