<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>关键字编辑</title>
</head>
<body>
	
	<div style="padding:3px 2px;border-bottom:1px solid #ccc">关键字</div>
	<form id="ff" action="../or/key_updateKey.action" method="post">
		<table>
			<%-- <tr>
				<td><input name="keywordID" value="<s:property value="model.keywordID"/>" type="text"></input></td></td>
			</tr> --%>
			
			<tr>
				<td>关键字1:</td>
				<td><input name="keyword1" value="<s:property value="model.keyword1"/>" type="text"></input></td>
			</tr>
			<tr>
				<td>关键字2:</td>
				<td><input name="keyword2" value="<s:property value="model.keyword2"/>" type="text"></input></td>
			</tr>
			<tr>
				<td>关键字3:</td>
				<td><input name="keyword3" value="<s:property value="model.keyword3"/>" type="text"></input></td>
			</tr>
			<tr>
				<td>关键字4:</td>
				<td><input name="keyword4" value="<s:property value="model.keyword4"/>" type="text"></input></td>
			</tr>
			<tr>
				<td>关键字5:</td>
				<td><input name="keyword5" value="<s:property value="model.keyword5"/>" type="text"></input></td>
			</tr>
			<tr>
				<td>关键字6:</td>
				<td><input name="keyword6" value="<s:property value="model.keyword6"/>" type="text"></input></td>
			</tr>
			<tr>
				<td>关键字7:</td>
				<td><input name="keyword7" value="<s:property value="model.keyword7"/>" type="text"></input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="确定"></input></td>
			</tr>
		</table>
	</form>
	
	
	
</body>


</html>