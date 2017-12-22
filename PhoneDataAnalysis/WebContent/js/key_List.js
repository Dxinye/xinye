var editIndex = undefined;
var edit = false;
$(function(){
	
	//var editIndex = undefined;
	
	
	$('#dg').datagrid({
	    //url:'${pageContext.request.contextPath}/key_findById.action?id=${requestScope.id}',
	    toolbar:'#tb',
	    iconCls: 'icon-edit',
	    rownumbers:true,
	    //singleSelect:false,
	    //鼠标双击事件
	    onDblClickRow : function(rowIndex, rowData){
	    	//console.log(rowData);
	    	if(editIndex != undefined){
	    		$('#dg').datagrid('endEdit',editIndex);
	    	}
	    	if(editIndex == undefined){
	    		$('#dg').datagrid('beginEdit',rowIndex);
	    		editIndex = rowIndex;
	    	}
	    	$('#save').show();
			$('#redo').show();
			
	    },
	    //编辑完成后触发的事件
	    onAfterEdit : function(rowIndex, rowData, changes){
	    	
	    	$('#save').hide();
			$('#redo').hide();
			//console.log(rowData);
			//获取新增的数据
			var inserted = $('#dg').datagrid('getChanges','inserted');
			//获取修改的数据
			var updated = $('#dg').datagrid('getChanges','updated');
			//var key = [];
			
			//新增关键字
			if(inserted.length>0){
				//循环获取数组中的数据
				for(var j =0; j < inserted.length; j++ ){
					var keyValue = inserted[j].keyValue;	//获取增加的关键字值
					var clientAndservice = inserted[j].clientAndservice;	//获取关键字所属对象（客服|客户）
					var isUse = inserted[j].isUse;	//获取禁用状态（1启用|2禁用）
					//控制台输出所传参数
					console.log(keyValue);	
					console.log(clientAndservice);
					console.log(isUse);
				}
				var dataStr = "keyWord.keyValue="+keyValue+"&keyWord.clientAndservice="+clientAndservice+"&keyWord.isUse="+isUse;
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath}/key_addKey.action',
					data:dataStr,
					beforeSend : function(){
						$('#dg').datagrid('loading');	//显示加载状态
					},
					success : function(data){
						if(data=="success"){
							$('#dg').datagrid('loaded');	//影藏加载状态
							$('#dg').datagrid('load');	//加载并显示第一页的行
							$('#dg').datagrid('unselectAll');	//取消所有的选中行
						}else if(data=="fail"){
							alert("数据添加失败！");
						}
					}
				});
			}
			//修改关键字
			if(updated.length>0){
				//循环获取数组中的数据
				for(var j =0; j < updated.length; j++ ){
					var keywordID = updated[j].keywordID;	//获取关键字id
					var indexId = updated[j].indexId;	//获取目录id
					var keyColumn = updated[j].keyColumn;	//获取关键字序号
					var keyValue = updated[j].keyValue;	//获取增加的关键字值
					var clientAndservice = updated[j].clientAndservice;	//获取关键字所属对象（客服|客户）
					var isUse = updated[j].isUse;	//获取禁用状态（1启用|2禁用）
					//控制台输出所传参数
					console.log(keyValue);	
					console.log(clientAndservice);
					console.log(isUse);
				}
				//传回后台的数据
				var dataStr = "keyWord.keywordID="+keywordID+"&keyWord.indexId="+indexId+"&keyWord.keyColumn="+keyColumn+"&keyWord.keyValue="+keyValue+"&keyWord.clientAndservice="+clientAndservice+"&keyWord.isUse="+isUse;
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath}/key_updateKey.action',
					data:dataStr,
					beforeSend : function(){
						$('#dg').datagrid('loading');	//显示加载状态
					},
					success : function(data){
						if(data=="success"){
							$('#dg').datagrid('loaded');	//影藏加载状态
							$('#dg').datagrid('load');	//加载并显示第一页的行
							$('#dg').datagrid('unselectAll');	//取消所有的选中行
							alert('数据修改成功！');
						}else if(data == "fail"){
								alert('数据修改失败！');
						}
					}
				});
			}
			console.log(inserted);
			console.log(updated); 
			editIndex = undefined;
	    },
	    
	    
	    columns:[[
	    	{field:'keywordID',title:'编号',width:'7%',align:'center',
	    		checkbox : true,
			},
			{field:'keyValue',title:'关键字',width:'75%',align:'center',
				editor:{
					type:'validatebox',
					options:{
						required:true,
						},
				},
			},
			{field:'clientAndservice',title:'客户和客服|客服|客户',width:'15%',align:'center',
				/*formatter: function(value,row,index){
					if (row.clientAndservice){
						return row.clientAndservice.text;
					} else {
						return value;
					}
				},*/
				editor:{
					type:'combobox',
					options:{
						valueField:'clientAndservice',
						textField:'text',
						mode:'remote',
						data: [{
								clientAndservice: 1,
								text: '客服'
							},{
								clientAndservice: 2,
								text: '客户'
							},{
								clientAndservice: 3,
								text: '客户和客服'
							}]
					}
				}
			},
			{field:'isUse',title:'启用|禁用',width:'7%',align:'center',
				editor:{
					type:'combobox',
					options:{
						valueField:'id',
						textField:'text',
						data: [{
								id: 1,
								text: '启用'
							},{
								id: 2,
								text: '禁用'
							}]
					}
				}
			}
	    ]]
		
	});
})
	

	//增加的方法
	function append(){
		if(editIndex == undefined){
			$('#dg').datagrid('insertRow',{
				index:0,
				row:{}
			});
			$('#dg').datagrid('beginEdit',0);
			editIndex =0;
		}
		$('#save').show();
		$('#redo').show();
	}

	//保存的方法
	function accept(){
		$('#dg').datagrid('acceptChanges');
		$('#dg').datagrid('endEdit',editIndex);
		
	}

	//取消的方法
	function reject(){
		editIndex = undefined;
		$('#dg').datagrid('rejectChanges');
		$('#save').hide();
		$('#redo').hide();
	}
	
	//删除的方法
	function removeit(){
		var rows = $('#dg').datagrid('getSelections');
		//alert(rows);
		if(rows.length>0){
			$.messager.confirm('提示', '确定要删除所选数据？', function(flag){
				if (flag){
					var ids = [];
					for(var i=0; i<rows.length;i++){
						ids.push(rows[i].keywordID);
						
					}
					console.log(ids.join(','));
					$.ajax({
						type:'post',
						url:'${pageContext.request.contextPath}/key_deleteKey.action',
						data:{
							ids:ids.join(','),
						},
						beforeSend : function(){
							$('#dg').datagrid('loading');	//显示加载状态
						},
						success : function(data){
							if(data){
								$('#dg').datagrid('loaded');	//影藏加载状态
								$('#dg').datagrid('load');	//加载并显示第一页的行
								$('#dg').datagrid('unselectAll');	//取消所有的选中行
								
							}
						}
						
						
					})
					
				}
			});
		}else{
			$.messager.alert('提示','请选择要删除的记录！','info');
		}
	}




