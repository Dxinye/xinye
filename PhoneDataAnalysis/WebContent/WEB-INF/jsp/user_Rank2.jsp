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
	   	var kkwe;
		$(function(){
			//编辑目录的方法
			$('#tt').etree({
				url: '${pageContext.request.contextPath}/index_indexSelectById.action',	//加载数据的地址
				lines : true,		//展开虚线效果
				animate : true,		//展开动画效果
				//鼠标右击事件
				onContextMenu: function(e, node){
					e.preventDefault();
					// 选择节点
					$('#tt').tree('select', node.target);
					// 实现菜单内容
					$('#menu').menu('show', { 
						left: e.pageX,
						top: e.pageY
			   	 	});
			   	 },
			   //点击事件
	   	 		onClick : function(node){
	   	 		var tid = ($('#tt').tree('getNode', node.target)).id;
	   	 		kkwe = tid;
	   	 		console.log(($('#tt').tree('getNode', node.target)).id);
	   	 		//alert(kkwe);
	   	 		}
			   	 
			});
		});
		//刷新页面
		function Refresh(){
			$(window.top.document).find("#tt").etree('reload');
		};
		
		//添加tabs的方法(关键字页面)
		function addTab(title,url){
			//alert(kkwe);
			if(kkwe != null){
				url = "${pageContext.request.contextPath}/key_findById.action?id="+kkwe;	
			}
			
			//alert(url)
			//jumpNewWeb();
			if ($('#t').tabs('exists', title)){
				$('#t').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				//alert(content);
				$('#t').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}
		//异步提交分类数据地址
		function sort(){
			add();
			//start();
			$.ajax({
				url: "${pageContext.request.contextPath}/index_sortData.action",
				//context: document.body,
				success: function(){
					alert("执行！");
					$('#win').window('close');
					
			}});
		};
		
		//导出数据
		function outFiltrate(){
			add();
			$.ajax({
									
				url: "${pageContext.request.contextPath}/filtrate_findAllFiltrate.action",
				//context: document.body,
				success: function(){
					$('#win').window('close');
					alert("数据成功出道F盘！");
			}});
		};
		
		//进度条方法
		function start(){
			var value = $('#p').progressbar('getValue');
			if (value < 100){
				value += Math.floor(Math.random() * 10);
				$('#p').progressbar('setValue', value);
				setTimeout(arguments.callee, 500);
			}
		};
		//创建进度窗口
		function add(){
			//alert(111);
			$('#win').window({
			    width:200,
			    height:100,
			    title:"进度",
			    modal:true
			});
		}
		
		
	</script>
	
	
</head>
<body class="easyui-layout">
	<!-- easyui布局北面 -->
	<div data-options="region:'north',border:false" style="height:50px;background:#B3DFDA;padding:5px">
		<div class="easyui-panel" style="padding:5px;">	
			<a class="easyui-linkbutton" href="#" onclick="Refresh()">刷新</a>  
			<a class="easyui-linkbutton" href="#" onclick="javascript:$('#tt').etree('create')">添加</a>  
			<a class="easyui-linkbutton" href="#" onclick="javascript:$('#tt').etree('edit')">编辑</a>  
			<a class="easyui-linkbutton" href="#" onclick="javascript:$('#tt').etree('destroy')">删除</a>  
			<a href="#" class="easyui-linkbutton" onclick="addTab('关键字','${pageContext.request.contextPath}/key_findById.action?id=')">关键字</a>
			<%-- <a class="easyui-linkbutton" href="#" onclick="addTab('用户管理','${pageContext.request.contextPath}/user_userList.action')">用户管理</a> --%>
			<a href="#" class="easyui-menubutton" data-options="menu:'#mm2',iconCls:'icon-edit'">数据</a>
			<a href="#" class="easyui-menubutton" data-options="menu:'#mm1',iconCls:'icon-edit'">目录</a>
		<div style="float:right">
			欢迎<span style="color:blue"><s:property value="#session.userLogin.userName"/>！</span>
			<a href="${pageContext.request.contextPath }/user_quit.action">退出</a>
		</div>
		</div>
		
		<div id="mm1" style="width:100px;">
			<div><a class="easyui-linkbutton" href="#" onclick="addTab('录入目录','${pageContext.request.contextPath}/login_fileUploadIndex.action')">录入目录</a></div>
			<div><a class="easyui-linkbutton" href="#" onclick="addTab('录入关键字','${pageContext.request.contextPath}/login_fileUploadKeyWord.action')">录入关键字</a></div>
		</div>
		<div id="mm2" style="width:100px;">
			<!-- <div><a class="easyui-linkbutton" href="javascript:outFiltrate()">导出数据</a></div> -->
			<div><a class="easyui-linkbutton" href="#" onclick="addTab('分类后数据','${pageContext.request.contextPath}/filtrate_filtrateList.action')">分类后数据</a></div>
			<div><a class="easyui-linkbutton" href="#" onclick="addTab('录入数据','${pageContext.request.contextPath}/login_fileUpload.action')">录入数据</a></div>
			<div><a class="easyui-linkbutton" href="#" onclick="addTab('原数据','${pageContext.request.contextPath}/originalData_originalList.action')">原数据</a></div>
			<div><a class="easyui-linkbutton" href="javascript:sort()">分类</a></div>
		</div>
		
	</div>
	<!-- 进度条 -->
	<!-- <div id="p" class="easyui-progressbar" style="width:400px;"></div> -->
	
	<div data-options="region:'west',split:true,title:'目录'" style="width:150px;padding:10px;">
		<ul id="tt" style="float:left"></ul>
		<div id="menu" class="easyui-menu" style="width:120px;">
			<div onclick="javascript:$('#tt').etree('create')" data-options="iconCls:'icon-add'">增加</div>
			<div onclick="javascript:$('#tt').etree('edit')" data-options="iconCls:'icon-remove'">修改</div>
			<div onclick="javascript:$('#tt').etree('destroy')" data-options="iconCls:'icon-edit'">删除</div>
		</div>
	</div>
	<!--布局中间部分  -->
	<div id="main-center" data-options="region:'center',title:'Center'">
		<!-- 创建标签页 -->
		<div id="t" class="easyui-tabs" style="width:100%;height:100%">
		</div>
	</div>
	<!-- 提示窗口 -->
	<div id="win">请等待...</div>
	
	
</body>
</html>