package com.elite.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.elite.dao.OriginalDataDao;
import com.elite.index.Sort;
import com.elite.index.TreeHelper;
import com.elite.service.DypeService;
import com.elite.service.IndexDataService;
import com.elite.service.IndextableService;
import com.elite.service.OriginalDataService;
import com.elite.util.ExtractMessage;
import com.elite.vo.Dtype;
import com.elite.vo.IndexData;
import com.elite.vo.Indextable;
import com.elite.vo.KeyWord;
import com.elite.vo.OriginalData;

public class OriginalDataServiceImpl implements OriginalDataService{
	//注入originalDataService
	private OriginalDataDao originalDataDao;
	//注入IndextableService
	private IndextableService indextableService;
	//注入IndexDataService
	private IndexDataService indexDataService;
	//注入sort
	private Sort sort;
	//注入Dtype
	private DypeService dtypeService;
	
	
	public DypeService getDtypeService() {
		return dtypeService;
	}
	public void setDtypeService(DypeService dtypeService) {
		this.dtypeService = dtypeService;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	public IndexDataService getIndexDataService() {
		return indexDataService;
	}
	public void setIndexDataService(IndexDataService indexDataService) {
		this.indexDataService = indexDataService;
	}
	public IndextableService getIndextableService() {
		return indextableService;
	}
	public void setIndextableService(IndextableService indextableService) {
		this.indextableService = indextableService;
	}
	public OriginalDataDao getOriginalDataDao() {
		return originalDataDao;
	}
	public void setOriginalDataDao(OriginalDataDao originalDataDao) {
		this.originalDataDao = originalDataDao;
	}
	
	
	//录入数据并将数据的对话内容进行分离
	public void insert(OriginalData originalData) {
		//获取对话内容字段，赋值给字符串part
		String part = originalData.getConversationContent(); 
		//判断数据的模板
		if(part.contains("【下一条】")){
			//根据【下一条】利用spilt方法将客户和客服的对话内容，截取出来并保存到字符串数组中
			String str[] = part.split("【下一条】");
			//创建两个字符串数组保存数据内容
			String partService[] = new String[str.length];
			String partClient[] = new String[str.length];
			
			//循环遍历字符串数据判断数据元素属于哪个对话内容
			for(int i=0;i<str.length;i++){
				//根据“：”判断是否是客服（客服工号固定为5位数）或者就是客户
				if(str[i].indexOf(":") == 5){
					str[i].trim();
					partService[i] = str[i];
					//将字符串设置到对象中保存到数据库
					//originalData.setService(partService);
				}else{
					str[i].trim();
					partClient[i] = str[i];
					//originalData.setClient(partClient[i]);
				}
			}
			//将字符串数组转换成字符串
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < partService.length; i++){ 
				//判断字符串是否为空
				if(!"".equals(partService[i]) && partService[i]!=null){
					sb. append(partService[i]);
				}
				
			}
			String s = sb.toString();
			
			StringBuffer sb1 = new StringBuffer();
			for(int i = 0; i < partClient.length; i++){ 
				if(!"".equals(partClient[i]) && partClient[i]!=null){
					sb1.append(partClient[i]);
				}
			}
			String s1 = sb1.toString();
			//将字符串设置到对应的字段中
			originalData.setService(s);
			originalData.setClient(s1);
			//调用添加数据的方法
			originalDataDao.insert(originalData);
		}else{
			//另一个模板的数据
			//去除字符串中的空格
			String str1 = part.replaceAll(" ", "");
			StringBuilder sb = new StringBuilder(str1);
			int a = -7;
			//在用户前给字符串添加一个断点
			while(sb.indexOf("用户",a+7) != -1){
				a = sb.indexOf("用户",a+7);
				sb.insert(a,"【下一条】");
			}
			//去除第一个断点字符串【下一条】
			sb.replace(0, 5, "");
			//将a值初始化为-7；
			a = -7;
			//在客服前添加一个断点
			while(sb.indexOf("客服",a+7) != -1){
				a = sb.indexOf("客服",a+7);
				sb.insert(a,"【下一条】");
			}
			//将StringBuilder转成String
			String sbString = sb.toString();
			//根据【下一条】来进行截取
			String str2[] = sbString.split("【下一条】");
			//创建两个字符串数组保存数据内容
			String partService1[] = new String[str2.length];
			String partClient1[] = new String[str2.length];
			//循环遍历字符串数据判断数据元素属于哪个对话内容
			for(int i=0;i<str2.length;i++){
				//根据“：”判断是否是客服（客服工号固定为5位数）或者就是客户
				if(str2[i].indexOf("于") == 7){
					str2[i].trim();
					partService1[i] = str2[i];
					//将字符串设置到对象中保存到数据库
					//originalData.setService(partService);
				}else{
					str2[i].trim();
					partClient1[i] = str2[i];
					//originalData.setClient(partClient[i]);
				}
			}
			//将字符串数组转换成字符串（客服）
			StringBuffer sb1 = new StringBuffer();
			for(int i = 0; i < partService1.length; i++){ 
				//判断字符串是否为空
				if(!"".equals(partService1[i]) && partService1[i]!=null){
					sb1.append(partService1[i]);
				}
			}
			String st = sb1.toString();
			//将字符串数组转换成字符串（客户）
			StringBuffer sb2 = new StringBuffer();
			for(int i = 0; i < partClient1.length; i++){ 
				if(!"".equals(partClient1[i]) && partClient1[i]!=null){
					sb2.append(partClient1[i]);
				}
			}
			String st1 = sb2.toString();
			//将字符串设置到对应的字段中
			originalData.setService(st);
			originalData.setClient(st1);
			//调用添加数据的方法
			originalDataDao.insert(originalData);
		}
		
	}
	
	//查询全部数据的方法，并实现分类后显示数据所属类别
	public List<OriginalData> select() {
		//调用dao层方法查询全部数据
		List<OriginalData> list = originalDataDao.showOriginalData();
		for(int i = 0; i<list.size(); i++){
			//根据数据id查询关系表中目录信息
			List<IndexData> dataList = indexDataService.findByDataId(list.get(i).getId());
			//根据目录id获取该数据所属的类别
			for(int j=0; j<dataList.size();j++){
				if(sort.leaf(dataList.get(j).getIndexID()) == true){
					//当前目录的所有父目录
					sort.findParent(dataList.get(j).getIndexID());
					//查询数据所属类别
					List<Dtype> dtypeList = dtypeService.findAll();
					//OriginalData originalData = originalDataDao.findDataById(list.get(i).getId());
					System.out.println(list.get(i).getDatatype());
					if("".equals(list.get(i).getDatatype())||list.get(i).getDatatype()==null){
						list.get(i).setDatatype(dtypeList.get(0).getDataType());
						System.out.println(list.get(i).getDatatype());
					}else{
						String str =list.get(i).getDatatype() + "\n" + dtypeList.get(0).getDataType();
						list.get(i).setDatatype(str);
						System.out.println(list.get(i).getDatatype());
					}
					Dtype dtype = new Dtype();
					dtype.setTypeId(1);
					dtype.setDataType("");
					dtypeService.update(dtype);
				}
			}
		}
		return list;
	}
	
	//查询全部数据的方法
	public List<OriginalData> findByAll(){
		List<OriginalData> list = originalDataDao.showOriginalData();
		return list;
	}
	
	//根据流水号查询是否存在数据
	public List<OriginalData> selectOne(OriginalData o) {
		List<OriginalData> oList = new ArrayList<OriginalData>();
		//拼接sql语句
		String serviceRdnumber = " from OriginalData where 1=1";
		if(o!=null){
			//判断客服流水号是否为空
			if(o.getSerRdNumber()!=null&&!"".equals(o.getSerRdNumber())){
				serviceRdnumber = serviceRdnumber + " and ser_rdNumber="+"'"+o.getSerRdNumber()+"'";
				oList = originalDataDao.selectById(serviceRdnumber);
				System.out.println(oList);
				}
		}
		return oList;
	}
	@Override
	/**
	 * 关键字若不为空则关键字已不能为空否则查询出来的是全部数据
	 * 此方法根据关键字查询数据
	 */
	public List<OriginalData> findAll(List<KeyWord> keyList) {
		//创建一个数组保存关键字的值，长度为关键字的总数
		String strValue[] = new String[keyList.size()];
		//创建一个数组存关键字的启用状态
		int strUse[] = new int[keyList.size()];
		//拼接sql语句
		String hql = "from OriginalData o where 1=1 ";
		for(int i = 0; i < keyList.size(); i++){
			//获取关键字字段属性保存到数组中；
			strValue[i] = keyList.get(i).getKeyValue();
			//获取关键字的启用状态
			strUse[i] = keyList.get(i).getIsUse();
			//判断关键字是否启用
			if(strUse[i] == 1){
				if(i == 0){
					hql = hql + "and (";
				}
				//利用extractMessage方法提取中括号中的内容，返回一个list集合；
				List<String> list = ExtractMessage.extractMessage(strValue[i]);
				//循环读取每条关键字中的每个关键字；
				for(int j = 0; j < list.size(); j++){
					//判断每个关键字中的或关系
					if(list.get(j).contains("|")){
						//将关键字按|拆分成字符串数组
						String str[] = list.get(j).split("|");
						//判断第一个关键字是否是非的关系
						if(!(str[0].contains("?") || str[0].contains("？"))){
							hql = hql + "o.conversationContent like '%" +str[0]+ "%' ";
						}
						//循环遍历数组拼接sql语句，脑残需求，不需要这非条件都行，非要这傻逼需求增加程序复杂度；
						for(int k = 1; k < str.length; k++){
							if(!(str[k].contains("?") || str[k].contains("？"))){
								hql = hql + "or o.conversationContent like '%"+str[k]+"%' ";
							}
						}
					}else{
						if(j==0){
							if(!(list.get(0).contains("?") || list.get(j).contains("？"))){
								hql = hql + "o.conversationContent like '%"+list.get(0)+"%' ";
							}
						}else{
							if(!(list.get(j).contains("?") || list.get(j).contains("？"))){
								hql = hql + "and o.conversationContent like '%"+list.get(j)+"%' ";
							}
						}
					}
				}
				if(i == keyList.size()-1){
					hql = hql + ")";
				}else{
					hql = hql + ")" + "or (";
				}
			}
			
		}
		System.out.println(hql);
		List<OriginalData> oList = originalDataDao.findAll(hql);
		return oList;
	}

	//分离对话内容方法
	public String partData(OriginalData o) {
		
		return null;
	}
	
	//根据时间查询数据信息
	public List<OriginalData> findOriginalByDate(String date1, String date2) {
		List<OriginalData> oList = originalDataDao.findOriginalByDate(date1,date2);
		
		for(int i = 0; i<oList.size(); i++){
			//根据数据id查询关系表中目录信息
			List<IndexData> dataList = indexDataService.findByDataId(oList.get(i).getId());
			//根据目录id获取该数据所属的类别
			for(int j=0; j<dataList.size();j++){
				if(sort.leaf(dataList.get(j).getIndexID()) == true){
					//当前目录的所有父目录
					sort.findParent(dataList.get(j).getIndexID());
					//查询数据所属类别
					List<Dtype> dtypeList = dtypeService.findAll();
					//OriginalData originalData = originalDataDao.findDataById(list.get(i).getId());
					System.out.println(oList.get(i).getDatatype());
					if("".equals(oList.get(i).getDatatype())||oList.get(i).getDatatype()==null){
						oList.get(i).setDatatype(dtypeList.get(0).getDataType());
					}else{
						String str =oList.get(i).getDatatype() + "\n" + dtypeList.get(0).getDataType();
						oList.get(i).setDatatype(str);
					}
					Dtype dtype = new Dtype();
					dtype.setTypeId(1);
					dtype.setDataType("");
					dtypeService.update(dtype);
				}
			}
		}
		
		return oList;
	}
	//修改数据的方法
	public void updateOriginalData(OriginalData originalData) {
		originalDataDao.updateOriginalData(originalData);
	}

	//根据时间和关键字进行分类的业务层方法
	public List<OriginalData> findBydate(List<KeyWord> keyList, String date1, String date2) {
		
		//创建一个数组保存关键字的值，长度为关键字的总数
		String strValue[] = new String[keyList.size()];
		//创建一个数组存关键字的启用状态
		int strUse[] = new int[keyList.size()];
		//拼接sql
		String hql = "from OriginalData o where conversation_startTime >= '" +date1+ "' and conversation_startTime <= '" +date2+"'";
		for(int i = 0; i < keyList.size(); i++){
			//获取关键字字段属性保存到数组中；
			strValue[i] = keyList.get(i).getKeyValue();
			//获取关键字的启用状态
			strUse[i] = keyList.get(i).getIsUse();
			//判断关键字是否启用
			if(strUse[i] == 1){
				if(i == 0){
					hql = hql + "and (";
				}
				//利用extractMessage方法提取中括号中的内容，返回一个list集合；
				List<String> list = ExtractMessage.extractMessage(strValue[i]);
				//循环读取每条关键字中的每个关键字；
				for(int j = 0; j < list.size(); j++){
					//判断每个关键字中的或关系
					if(list.get(j).contains("|")){
						//将关键字按|拆分成字符串数组
						String str[] = list.get(j).split("|");
						//判断第一个关键字是否是非的关系
						if(!(str[0].contains("?") || str[0].contains("？"))){
							hql = hql + "o.conversationContent like '%" +str[0]+ "%' ";
						}
						//循环遍历数组拼接sql语句，脑残需求，不需要这非条件都行，非要这傻逼需求增加程序复杂度；
						for(int k = 1; k < str.length; k++){
							if(!(str[k].contains("?") || str[k].contains("？"))){
								hql = hql + "or o.conversationContent like '%"+str[k]+"%' ";
							}
						}
					}else{
						if(j==0){
							if(!(list.get(0).contains("?") || list.get(j).contains("？"))){
								hql = hql + "o.conversationContent like '%"+list.get(0)+"%' ";
							}
						}else{
							if(!(list.get(j).contains("?") || list.get(j).contains("？"))){
								hql = hql + "and o.conversationContent like '%"+list.get(j)+"%' ";
							}
						}
					}
				}
				if(i == keyList.size()-1){
					hql = hql + ")";
				}else{
					hql = hql + ")" + "or (";
				}
			}
			
		}
		System.out.println(hql);
		List<OriginalData> oList = originalDataDao.findAll(hql);
		return oList;
		
	}
	

}
