<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/jquery.etree.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/easyui/demo/demo.css">
		<meta http-equiv="content-type" content="text/html;charset=UTF-8" /> 
</head>
<body bgcolor="#OOFFFF">
	
<div style="width:600px;margin-left:auto;margin-right:auto;">
	<h2>用户注册界面</h2>
		<form id="ff" action="${pageContext.request.contextPath}/or/user_userRegist.action" method="post" novalidate="novalidate">
			<div style="margin:20px 0;"></div>
			<div class="easyui-panel" title="Register" style="width:400px;padding:10px 60px 20px 60px">
				<table cellpadding="5">
					<tr>
						<td>用户名:</td>
						<td><input id="un" name="userName" class="easyui-validatebox textbox" data-options="prompt:'Enter User Name.',required:true" onblur="isUse()">
							<div id="showResult"></div>
						</td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input id="pwd" name="userPassword" type="password" class="easyui-validatebox textbox" data-options="required:true"></td>
					</tr>
					<tr>
						<td>确认密码:</td>
						<td><input id="rpwd" name="rpwd" type="password" class="easyui-validatebox textbox" required="required" validType="equals['#pwd']"></td>
					</tr>
					<tr>
						<td>真实姓名:</td>
						<td><input name="realName" class="easyui-validatebox textbox" data-options="prompt:'Enter real Name.',required:true"></td>
					</tr>
					<!-- <tr>
						<td>手机:</td>
						<td><input class="easyui-validatebox textbox" data-options="prompt:'Enter your phone number.',required:true"></td>
					</tr> -->
						
				</table>
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="注册" style="width:80%;height:32px"/>					
		</form>
</div>	

	<style scoped="scoped">
		.textbox{
			height:20px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>
	<script>
		
		/* $('#ff').form({
			success:function(data){
				$.messager.alert('Info', data, 'info');
			}
		}); */
		
		//异步校验用户名是否重复
		function isUse(){
			 var inputUserNameObj = $("#un");   //将获取ID为uname的控件的对象  
			    
			    $("#un").blur(function(){   //当该控件失去焦点时发生  
			  
			        var text = inputUserNameObj.val();   //获得用户输入的用户名  
			        $.post("${pageContext.request.contextPath}/user_findUserName.action?userName="+text,null,function(response){      
			                   //以POST方式跳转到action里面的方法中进行处理，并返回处理结果response  
			  
			             if(response=="用户名已经存在"){ //根据返回值进行处理  
			                          
			                document.getElementById("un").focus();//用户名输入控件获得焦点  
			                             
			                    document.getElementById("showResult").innerHTML="<font color='red'>"+response+"</font>";   
			                                //在div中提示用户该用户名已经存在  
			  
			             }else{
			                if(document.getElementById("un").value=="") //判断用户名是否为空  
			                {  
			                document.getElementById("showResult").innerHTML="<font color='red'>"+"用户名不为空"+"</font>";  
			                                 //在div中提示用户该用户名不能为空  
			  
			                document.getElementById("un").focus();//用户名输入控件获得焦点  
			  
			                }else{  
			  
			                         document.getElementById("showResult").innerHTML="<font color='blue'>"+response+"</font>";   
			                                 //在div中提示用户该用户名可用  
			                     }  
			            }  
			        });    
			    });
		}
	
	
		//验证确认密码框
		$.extend($.fn.validatebox.defaults.rules, {
		    equals: {
				validator: function(value,param){
					return value == $(param[0]).val();
				},
				message: 'Field do not match.'
		    }
		});
		//验证
		$(function(){
			$('input.easyui-validatebox').validatebox({
				tipOptions: {	// the options to create tooltip
					showEvent: 'mouseenter',
					hideEvent: 'mouseleave',
					showDelay: 0,
					hideDelay: 0,
					zIndex: '',
					onShow: function(){
						if (!$(this).hasClass('validatebox-invalid')){
							if ($(this).tooltip('options').prompt){
								$(this).tooltip('update', $(this).tooltip('options').prompt);
							} else {
								$(this).tooltip('tip').hide();
							}
						} else {
							$(this).tooltip('tip').css({
								color: '#000',
								borderColor: '#CC9933',
								backgroundColor: '#FFFFCC'
							});
						}
					},
					onHide: function(){
						if (!$(this).tooltip('options').prompt){
							$(this).tooltip('destroy');
						}
					}
				}
			}).tooltip({
				position: 'right',
				content: function(){
					var opts = $(this).validatebox('options');
					return opts.prompt;
				},
				onShow: function(){
					$(this).tooltip('tip').css({
						color: '#000',
						borderColor: '#CC9933',
						backgroundColor: '#FFFFCC'
					});
				}
			});
		});
	</script>


</body>
</html>