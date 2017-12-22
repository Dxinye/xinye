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
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>关键字编辑</title>
</head>
<body >
	
	<!-- <div style="padding:3px 2px;border-bottom:1px solid #ccc">关键字</div> -->
		<form id="ff" action="${pageContext.request.contextPath}/key_updateKey.action?id=${requestScope.id}" method="post">
			<table>
				<%-- <tr>
					<td><input name="keywordID" value="<s:property value="model.keywordID"/>" type="text"></input></td></td>
				</tr> --%>
				
				<tr>
					<td>关键字:</td>
					<td><input style="width:600px" class="easyui-textbox" name="keyValue" value="<s:property value="model.keyValue"/>" type="text"></input></td>
					<td></td>
				</tr>
				
				
				<tr>
					<td>关键字2:</td>
					<td><input style="width:100%" class="easyui-textbox" name="keyword2" value="<s:property value="model.keyword2"/>" type="text"></input></td>
				</tr>
				<tr>
					<td>关键字3:</td>
					<td><input style="width:100%" class="easyui-textbox" name="keyword3" value="<s:property value="model.keyword3"/>" type="text"></input></td>
				</tr>
				<tr>
					<td>关键字4:</td>
					<td><input style="width:100%" class="easyui-textbox" name="keyword4" value="<s:property value="model.keyword4"/>" type="text"></input></td>
				</tr>
				<tr>
					<td>关键字5:</td>
					<td><input style="width:100%" class="easyui-textbox" name="keyword" value="<s:property value="model.keyword5"/>" type="text"></input></td>
				</tr>
				<tr>
					<td>关键字6:</td>
					<td><input style="width:100%" class="easyui-textbox" name="keyword" value="<s:property value="model.keyword6"/>" type="text"></input></td>
				</tr>
				<tr>
					<td>关键字7:</td>
					<td><input style="width:100%" class="easyui-textbox" name="keyword" value="<s:property value="model.keyword7"/>" type="text"></input></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input style="width:120px" class="easyui-linkbutton" type="submit" value="确定"></input></td>
				</tr>
			</table>
		</form>
		<div style="margin-left: 56.5px">
			<form id="f" action="${pageContext.request.contextPath}/key_deleteKey.action?id=${requestScope.id}" method="post">
				<input style="width:120px;background: red" class="easyui-linkbutton" type="submit" value="删除"></input>
			</form>
		</div>
	<div id="org"></div>
	<!-- <input type="button" onclick="add1();" value="添加" /> -->
	
	
	<script type="text/javascript">
		/* 动态创建文本框标签 */
		function add1(){
		    var input1 = document.createElement('input');
		    input1.setAttribute('type', 'text');
		    input1.setAttribute('name', 'organizers[]');
		    input1.setAttribute('class', 'git');
		    
		    var btn1 = document.getElementById("org");
		    btn1.insertBefore(input1,null);
		}
		
		
	
	</script>
	
	
</body>


</html>