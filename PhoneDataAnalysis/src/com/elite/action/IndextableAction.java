package com.elite.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.elite.excel.ReadExcelIndex;
import com.elite.index.Sort;
import com.elite.index.TreeHelper;
import com.elite.service.IndexDataService;
import com.elite.service.IndextableService;
import com.elite.service.KeyWordService;
import com.elite.service.OriginalDataService;
import com.elite.vo.IndexData;
import com.elite.vo.Indextable;
import com.elite.vo.KeyWord;
import com.elite.vo.OriginalData;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
/**
 * 目录的action方法
 * @author rd
 *
 */
public class IndextableAction extends ActionSupport implements ModelDriven<Indextable>{
	//注入实体类对象
	private Indextable indextable = new Indextable();
	//注入业务层对象
	private IndextableService indextableService;
	//注入keyWordService
	private KeyWordService keyWordService;
	//注入originalDataService
	private OriginalDataService originalDataService;
	//注入sort
	//private Sort sort;
	//注入IndexDataService
	private IndexDataService indexDataService;
	//实体类IndexData
	private IndexData indexData = new IndexData();
	
	
	
	public IndexDataService getIndexDataService() {
		return indexDataService;
	}

	public void setIndexDataService(IndexDataService indexDataService) {
		this.indexDataService = indexDataService;
	}

	public IndexData getIndexData() {
		return indexData;
	}

	public void setIndexData(IndexData indexData) {
		this.indexData = indexData;
	}


	public OriginalDataService getOriginalDataService() {
		return originalDataService;
	}

	public void setOriginalDataService(OriginalDataService originalDataService) {
		this.originalDataService = originalDataService;
	}

	public KeyWordService getKeyWordService() {
		return keyWordService;
	}

	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}

	public Indextable getIndextable() {
		return indextable;
	}

	public void setIndextable(Indextable indextable) {
		this.indextable = indextable;
	}

	public IndextableService getIndextableService() {
		return indextableService;
	}

	public void setIndextableService(IndextableService indextableService) {
		this.indextableService = indextableService;
	}
	
	//模型驱动的返回方法
	@Override
	public Indextable getModel() {
		return indextable;
	}
	//查询全部的节点
	public String indexFindAction(){
		//定义集合保存数据
		List<Indextable> list = new ArrayList<Indextable>();
		//将数据库中取出的目录数据保存到集合中
		list = indextableService.select();
		
		for(Indextable index : list){
			for(int i=0;i<index.getLevel();i++)
			{
				 System.out.print("  ");
			}
			System.out.println(index.getId() + " " + index.getText());
		}
		
		String a = BecomeJson(list);
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return NONE;
	}
	
	
	//根据id查询树节点
	public String indexSelectById(){
		//获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request);
		//从request对象获取id
		String id = request.getParameter("id");
		int tid = 0;	//声明tid
		//判断id是否为空，若不为空则将id转为int
		if(id!=null){
			tid =  Integer.parseInt(id);
		}
		//创建集合保存查询的子节点
		List<Indextable> listById = new ArrayList<>();
		//如果id为空则为第一次加载页面查询根节点，父节点为0
		if(id==null){
			//获取根节点
			listById = indextableService.selectById(0);
		}else{
			//查询子节点，将当前id当父节点进行查询
			listById = indextableService.selectById(tid);
		}
		System.out.println(listById.get(0).getText());
		//设置state属性的值
		for(int i = 0;i<listById.size();i++){
			if(listById!=null){
				listById.get(i).setState("closed");
			}
		}
		//将数据转成json格式输出到客户端
		System.out.println(listById);
		String a = BecomeJson(listById);
		System.out.println(a);
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	
	/**
	 * 更新目录的action方法
	 * @return
	 */
	public String updateIndex(){
		//选根据id查询出该节点的信息并获取该节点的父节点
		Indextable index = indextableService.findById(indextable.getId());
		//将父节点id设置到indextable对象中
		indextable.setParentID(index.getParentID());
		indextableService.updateIndex(indextable);
		return NONE;
	}
	
	/**
	 * 添加目錄的action方法
	 * @return
	 */
	public String insertIndex(){
		//获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("parentId");
		int parentID = Integer.parseInt(id);
		//获取传回来的id
		//int pid = indextable.getId(); 
		indextable.setParentID(parentID);	//将当前id设置为新节点的父节点
		indextable.setText("New Node");		//将新节点内容设置为固定的值
		indextableService.insertIndex(indextable);
		//indexSelectById();
		return NONE;
	}
	
	/** 
	 * 刪除目錄的方法 
	 * @return 
	 */
	public String deleteIndex(){
		//查询要删除的子节点
		List<Indextable> clist = indextableService.selectById(indextable.getId());
		//System.out.println(indextable.getId());
		Indextable index = new Indextable();
		//判断是否有子节点，有进行遍历删除，只能删除其子节点，孙子节点及以下不能
		if(clist.size()>0){
			for(int i = 0;i<clist.size();i++){
				index = clist.get(i);
				//删除子目录
				indextableService.deleteIndex(index); 
				//查询该目录下的子目录是否存在关键字
				List<KeyWord> keyList = keyWordService.findById(index.getId());
				//存在关键字则删除
				if(keyList.size()>0){
					for(int j = 0; j < keyList.size(); j++){
						keyWordService.deleteKey(keyList.get(j));
					}
				}
			}
		}
		//删除返回的id的节点
		indextableService.deleteIndex(indextable);
		//查询该目录是否存在关键字
		List<KeyWord> keyList = keyWordService.findById(indextable.getId());
		if(keyList.size()>0){
			for(int i =0; i < keyList.size();  i++){
				keyWordService.deleteKey(keyList.get(i));
			}
		}
		//查询目录数据关系表是否存在关联，若存在则删除
		List<IndexData> iDList = indexDataService.findByIndexID(indextable.getId());
		//循环调用删除数据
		for(int i = 0; i < iDList.size(); i++){
			indexDataService.delete(iDList.get(i));
		}
		return NONE;
	}
	
	//根据目录遍历进行数据分类
	public String sortData(){
		//sort.sortData1(0);
		//查询所有目录
		List<Indextable> list = indextableService.select();
		//调用创建遍历目录树的方法
		List<Indextable> iList = TreeHelper.getSortedNodes(list);
		//开始从根目录遍历目录进行分类
		for(int i = 0; i < iList.size(); i++){
			//根据目录id查询关键字
			List<KeyWord> keyList = keyWordService.findById(iList.get(i).getId());
			if(keyList.size() > 0){
				//根据关键字模糊查询数据
				List<OriginalData> oList = originalDataService.findAll(keyList);
				//将当前目录id保存到查询出来的数 据中
				for(int j = 0; j < oList.size(); j++){
					Boolean flag = false;
					//根据目录id查询关系表数据
					List<IndexData> list1 = indexDataService.findByDataId(oList.get(j).getId());
					//循环遍历判断该数据是否已经属于该目录，若存在则flag赋值为true；
					for(int k = 0; k < list1.size(); k++){
						if(list1.get(k).getIndexID() == iList.get(i).getId()){
							System.out.println("数据已经存在以这个目录" + iList.get(i).getText());
							flag = true;
							break;
						}
					}
					//flag==false则不在
					if(flag ==false){
						//设置当前目录id的值到关系表
						indexData.setIndexID(iList.get(i).getId());
						//设置当前数据id的值到关系表
						indexData.setdID(oList.get(j).getId());
						//调用业务层的添加数据的方法，保存数据信息
						indexDataService.insert(indexData);
					}
				}
			}
		}
		return NONE;
	}
	
	//根据时间进行数据分类
	public String sortDataBydate(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		//查询所有目录
		List<Indextable> list = indextableService.select();
		//调用创建遍历目录树的方法
		List<Indextable> iList = TreeHelper.getSortedNodes(list);
		//开始从根目录遍历目进行分类
		for(int i = 0; i < iList.size(); i++){
			//根据目录id查询关键字
			List<KeyWord> keyList = keyWordService.findById(iList.get(i).getId());
			if(keyList.size()>0){
				//根据关键字模糊查询数据
				List<OriginalData> oList = originalDataService.findBydate(keyList,date1,date2);
				//将当前目录id保存到查询出来的数 据中
				for(int j = 0; j < oList.size(); j++){
					Boolean flag = false;
					//根据目录id查询关系表数据
					List<IndexData> list1 = indexDataService.findByDataId(oList.get(j).getId());
					//循环遍历判断该数据是否已经属于该目录，若存在测flag赋值为true；
					for(int k = 0; k < list1.size(); k++){
						if(list1.get(k).getIndexID() == iList.get(i).getId()){
							System.out.println("数据已经存在以这个目录" + iList.get(i).getText());
							flag = true;
							break;
						}
					}
					//flag==false则不在
					if(flag ==false){
						
						//设置当前目录id的值到关系表
						indexData.setIndexID(iList.get(i).getId());
						//设置当前数据id的值到关系表
						indexData.setdID(oList.get(j).getId());
						//调用业务层的添加数据的方法，保存数据信息
						indexDataService.insert(indexData);
					}
				}
			}
		}
		
		
		return NONE;
	}
	
	
	
	//转换数据成json数据
	public String BecomeJson(Object cDto){
		Gson gson=new Gson();
		String json=gson.toJson(cDto);
		return json;
	}
}
