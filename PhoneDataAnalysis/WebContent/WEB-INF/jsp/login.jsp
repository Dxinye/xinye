<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>数据分析系统-登录</title>
	<%-- <%@ include file="/common/basePath.jsp"%> --%>
	<link href="${pageContext.request.contextPath}/index/content/css/page/login.css" rel="stylesheet" type="text/css" />
	
 </head>
 
 <body>
 
 	<div style=”color:red”>
  		<s:fielderror />
	</div>
 
 	<div class="second_body">
    	
        	<div class="logo"></div>
            <div class="title-zh">数据分析系统</div>
            <div class="title-en" style="">&nbsp;&nbsp;DAS DataAnalysisSystem</div>
            <div class="message" data-bind="html:message"></div>
        <form action="${pageContext.request.contextPath}/user_loginUser.action" method="post" novalidate="novalidate">
            <table border="0" style="width:300px;">
            	<tr>
                	<td style="white-space:nowrap; padding-bottom: 5px;width:55px;">用户名：</td>
                    <td colspan="2"><input type="text" id="userCode" name="userName"/></td>
                </tr>
                <tr>
                    <td class="lable" style="white-space:nowrap; letter-spacing: 0.5em; vertical-align: middle">密码：</td>
                    <td colspan="2"><input type="password" id="password" name="userPassword"/></td>
                </tr>
               <%--  <tr>
                    <td></td>
                    <td colspan="2"><input type="checkbox" data-bind="checked:form.remember" /><span>系统记住我</span></td>
                </tr> --%>
                <tr>
                    <td colspan="3" style="text-align:center">
                    	
                        <input type="submit" value="登录" class="login_button" />
                       <!--  <input type="button" value="重置" class="reset_botton" data-bind="click:resetClick" /> -->
                        <a class="easyui-linkbutton" href="${pageContext.request.contextPath}/login_JumpRegist.action" >注册</a>
                        <a class="easyui-linkbutton" href="${pageContext.request.contextPath}/index/forget_password.jsp" >忘记密码</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
        
 	
 </body>
</html>