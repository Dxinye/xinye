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
		//分页效果
	    $(function(){//加载数据
	        $('#dg').datagrid({loadFilter:pagerFilter}).datagrid('loadData', getData());
	    });
	
	    //表单异步提交，根据时间导出数据
		$('#ff').form({
			//url:'${pageContext.request.contextPath}/filtrate_findByDate.action',			
			success:function(data){
				//add();
				alert("数据成功出道F盘！");
			}
		});
	    
		//导出全部数据
		function outFiltrate(){
			$.ajax({
				url: "${pageContext.request.contextPath}/originalData_outOriginalAll.action",
				//context: document.body,
				success: function(){
					alert("数据成功出道F盘！");
			}});
		};
	
	</script>


<body>

	<table id="dg" title="原数据" class="easyui-datagrid" style="width:90%px;height:90%px"
		url="${pageContext.request.contextPath}/originalData_selectAction.action"
		toolbar="#toolbar"
		rownumbers="true" fitColumns="true" singleSelect="true" pagination="true">
		<thead>
			<tr>
				<th field="serRdNumber">客服流水号</th>
				<th field="acceptNumber">受理号码</th>
				<th field="skillQueue">技能队列</th>
				<th field="workGroup">工作组</th>
				<th field="zuoxiNumber">坐席工号</th>
				<th field="serName">客服姓名</th>
				<!-- <th field="serNickname">客服昵称</th> -->
				<th field="conversationStartTime" width="50">人工对话开始时间</th>
				<!-- <th field="visitWay" width="50">来访渠道</th>
				<th field="visitIp" width="50">来访IP</th>
				<th field="ipProvice" width="50">IP所在省分</th> 
				<th field="businessType" width="50">业务类型</th>-->
				<!-- <th field="clientRank" width="50">客户级别</th>
				<th field="clientBrand" width="50">客户品牌</th>
				<th field="clientProvice" width="50">客户省份</th>
				<th field="clientCity" width="50">客户地市</th> 
				<th field="conversationStartTime" width="50">人工对话开始时间</th>
				<th field="conversationEndTime" width="50">人工对话结束时间</th>
				<th field="email" width="50">对话评估</th>
				<th field="conversationAssess" width="50">人工通话时长</th>
				<th field="conversationTime" width="50">平均回复间隔时长</th>
				<th field="replyIntervalTime" width="50">满意度类型</th>
				<th field="satisfactionType" width="50">Email</th>
				<th field="solveType" width="50">解决情况类型</th>
				<th field="endPerson" width="50">挂机方</th>
				<th field="endReason" width="50">挂机原因</th>
				<th field="clientSpeakFrequency" width="50">用户发言次数</th>
				<th field="serSpeakFrequency" width="50">客服发言次数</th>
				<th field="interactionFrequency" width="50">互动次数</th>
				<th field="isvalidConversation" width="50">是否有效对话</th>
				<th field="comment" width="50">备注</th> -->
				<!-- <th field="conversationContent">人工对话内容</th> -->
				<!-- <th field="robotConversationContent" width="50">机器人对话内容</th>
				<th field="kewordID" width="50">关键字id</th> 
				<th field="service" width="50">客服对话内容</th>
				<th field="client" width="50">客户对话内容</th>-->
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<a class="easyui-linkbutton" href="javascript:outFiltrate()">导出全部数据</a>
		<form id="ff" action="${pageContext.request.contextPath}/originalData_findOriginalByDate.action" method="post">
			<span style="color:red">根据时间导出数据：</span>
			开始时间:
			<input class="easyui-datetimebox" name="date1" data-options="required:true,showSeconds:true" style="width:150px">
			结束时间:
			<input class="easyui-datetimebox" name="date2" data-options="required:true,showSeconds:true" style="width:150px">
			<input type="submit" value="导出"></input>
		</form>
	</div>
</body>
</html>