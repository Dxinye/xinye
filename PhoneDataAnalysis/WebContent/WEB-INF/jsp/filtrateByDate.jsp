<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
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
	<script type="text/javascript">
		
	
	    
		//表单异步提交，上传文件同时录入数据
		function submitForm(){
			$('#ff').form('submit', {
	    		url:"${pageContext.request.contextPath}/index_sortDataBydate.action",
	   		 	onSubmit: function(){
					add();
	    		},
		    	success:function(data){
		    		$('#win').window('close');
					alert("数据分类成功！");
					 window.location.reload();//刷新当前页面.
		    	}
			});
		}
	    
		//创建进度窗口
		function add(){
			//alert(111);
			$('#win').window({
			    width:200,
			    height:50,
			    title:"进度。。。",
			    modal:true
			});
		}
	
	</script>


<body>

	<div id="toolbar">
		<form id="ff" action="" method="post">
			<span style="color:red">根据时间分类数据：</span>
			开始时间:
			<input class="easyui-datetimebox" name="date1" data-options="required:true,showSeconds:true" style="width:150px">
			结束时间:
			<input class="easyui-datetimebox" name="date2" data-options="required:true,showSeconds:true" style="width:150px">			 
		</form>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
	<!-- 提示窗口 -->
	<div id="win"></div>
</body>
</html>