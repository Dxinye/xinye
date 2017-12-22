<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script> -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/index/easyui/jquery.etree.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/easyui/demo/demo.css">
		<meta http-equiv="content-type" content="text/html;charset=UTF-8" /> 
	
	<script type="text/javascript">
	   //实现前台分页代码
	    function pagerFilter(data){
	        if (typeof data.length == 'number' && typeof data.splice == 'function'){    // 判断数据是否是数组
	            data = {
	                total: data.length,
	                rows: data
	            }
	        }
	        var dg = $(this);
	        var opts = dg.datagrid('options');
	        var pager = dg.datagrid('getPager');
	        pager.pagination({
	            onSelectPage:function(pageNum, pageSize){
	                opts.pageNumber = pageNum;
	                opts.pageSize = pageSize;
	                pager.pagination('refresh',{
	                    pageNumber:pageNum,
	                    pageSize:pageSize
	                });
	                dg.datagrid('loadData',data);
	            }
	        });
	        if (!data.originalRows){
	            data.originalRows = (data.rows);
	        }
	        var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
	        var end = start + parseInt(opts.pageSize);
	        data.rows = (data.originalRows.slice(start, end));
	        return data;
	    }
	
	   
	    
	    //编辑用户信息
	    function editUser(){
	    	var row = $('#dg').datagrid('getSelected');
	    	if (row){
	    		$('#dlg').dialog('open').dialog('setTitle','Edit User');
	    		$('#fm').form('load',row);
	    		//url = 'update_user.php?id='+row.id;
	    	}
	    }
	    
	    
	    //删除用户信息
	    function destroyUser(){
	    	var row = $('#dg').datagrid('getSelected');
	    	//alert(row);
	    	if (row){
	    		$.messager.confirm('提示','您确定要删除该用户？',function(r){
	    			if (r){
	    				$.post('${pageContext.request.contextPath}/user_destroyUser.action',{userName:row.userName},function(result){
	    					if (result == "success"){
	    						$('#dg').datagrid('reload');	// reload the user data
	    						alert("删除成功！");
	    					} else {
	    						alert("删除失败！");
	    					}
	    				});
	    			}
	    		});
	    	}
	    }
	    
	    //保存用户信息
	   function saveUser(){
			$('#fm').form('submit',{
				url: '${pageContext.request.contextPath}/user_updateUser.action',
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					//var result = eval('('+result+')');
					if (result == "修改成功"){
						$('#dlg').dialog('close');		// close the dialog
						$('#dg').datagrid('reload');	// reload the user data
						alert(result);
					} else {
						//$('#dlg').dialog('close');
						alert(result);
					}
				}
			});
		}
		
	</script>
	
	
</head>
<body>
	
	<table id="dg" title="用户列表" class="easyui-datagrid" style="width:90%px;height:90%px"
		url="${pageContext.request.contextPath}/user_findAllUser.action"
		toolbar="#toolbar"
		rownumbers="true" fitColumns="true" singleSelect="true" pagination="true">
		<thead>
			<tr>
				<th field="userName" width="50">用户名</th>
				<th field="userPassword" width="50">密码</th>
				<th field="realName" width="50">真实姓名</th>
				<th field="userRank" width="50">用户等级</th>
				<th field="userIsActivate" width="50">是否启用</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a> -->
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">管理用户</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除用户</a>
	</div>
	
	<!-- 创建表单对话框 -->
	<div id="dlg" class="easyui-dialog" style="width:380px;height:400px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
		<!-- <div class="ftitle">用户信息</div> -->
		<form id="fm" method="post">
			<div style="margin-bottom:20px">
				<div>用户名:</div>
				<input name="userName" class="easyui-textbox" style="width:100%">
			</div>
		
			<div style="margin-bottom:20px">
				<div>密码:</div>
				<input name="userPassword" class="easyui-textbox" style="width:100%">
			</div>
			
			<div style="margin-bottom:20px">
				<div>真实姓名:</div>
				<input name="realName" class="easyui-textbox" style="width:100%">
			</div>
			
			<!-- <div style="margin-bottom:20px">
				<div>用户等级:</div>
				<input name="userRank" class="easyui-textbox" style="width:100%">
			</div> -->
			<div style="margin-bottom:20px">
			<div>用户等级:</div>
			<select id="cc" class="easyui-combobox" name="userRank" style="width:200px;">
			    <option value="1">超级管理员</option>
			    <option value="2">能读取用户</option>
			    <option value="3">只能读用户</option>
			</select>
			</div>
			<div style="margin-bottom:20px">
				<div>是否启用:</div>
				<select id="cc1" class="easyui-combobox" name="userIsActivate" style="width:200px;">
				    <option value="0">禁用</option>
				    <option value="1">启用</option>
				</select>
			</div>
			<!-- <input id="cc" class="easyui-combobox" name="userIsActivate" data-options="valueField:'id',textField:'text',url:'get_data.php'"> -->
			
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	
	
	
	
	
</body>
</html>