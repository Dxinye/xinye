<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/jquery.etree.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/easyui/demo/demo.css">
		<script src="${pageContext.request.contextPath}/js/key_List.js" type="text/javascript"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>关键字编辑</title>
</head>
<body >
	 
	
		
		<table id="dg" class="easyui-datagrid" style="width:'95%';height:'80%'" data-options="url:'${pageContext.request.contextPath}/key_findById.action?id=${requestScope.id}'"></table>
		<div id="tb" style="height:auto">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">增加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" style="display:none;" id="save" onclick="accept()">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" style="display:none;" id="redo" onclick="reject()">取消</a>
			<!-- <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">获取改变</a> -->
		</div>
		
	
</body>


</html>