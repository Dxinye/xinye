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
		
		<title>文件上传</title>
		 
</head>
		
<body>

		<form id="ff" action="" method="post" enctype="multipart/form-data">
			 <!-- <input type="file" name="fs"  multiple ><br> -->
			 <div style="margin-bottom:20px">
				<input type="file" name="fs">
			</div>
			 
			<!-- <input type="submit"   value="上传"><br> -->
		</form>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	<!-- 提示窗口 -->
	<div id="win"></div>    
	    
    <script type="text/javascript">
    
	  	//创建进度窗口
		function add(){
			//alert(111);
			$('#win').window({
			    width:200,
			    height:100,
			    title:"数据录",
			    modal:true
			});
		}
    	
		//表单异步提交，上传文件同时录入数据
		function submitForm(){
			$('#ff').form('submit', {
	    		url:"${pageContext.request.contextPath}/fileupload_fileOriginalData.action",
	   		 	onSubmit: function(){
					add();
	    		},
		    	success:function(data){
		    		$('#win').window('close');
					alert("数据录入成功！");
					 window.location.reload();//刷新当前页面.
		    	}
			});
		}
	  	
	   
		
    
    </script>

</body>
</html>