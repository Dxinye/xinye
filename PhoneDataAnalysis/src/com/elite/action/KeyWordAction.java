package com.elite.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.elite.service.FiltrateService;
import com.elite.service.IndexDataService;
import com.elite.service.KeyWordService;
import com.elite.service.OriginalDataService;
import com.elite.vo.Filtrate;
import com.elite.vo.IndexData;
import com.elite.vo.KeyWord;
import com.elite.vo.OriginalData;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class KeyWordAction extends ActionSupport implements ModelDriven<KeyWord>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//引进模型驱动
	private KeyWord keyWord = new KeyWord();
	//注入keyWordService
	private KeyWordService keyWordService;
	//注入OriginalDataService
	private OriginalDataService originalDataService;
	//注入FiltrateServie
	private FiltrateService filtrateService;
	//注入IndexDataService
	private IndexDataService indexDataService;
	//接收目录id
	private Integer id;
	//接收keywordID
	/*private Integer keywordID;
	

	public Integer getKeywordID() {
		return keywordID;
	}

	public void setKeywordID(Integer keywordID) {
		this.keywordID = keywordID;
	}*/
	
	public Integer getId() {
		return id;
	}

	public IndexDataService getIndexDataService() {
		return indexDataService;
	}

	public void setIndexDataService(IndexDataService indexDataService) {
		this.indexDataService = indexDataService;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public KeyWord getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(KeyWord keyWord) {
		this.keyWord = keyWord;
	}

	public OriginalDataService getOriginalDataService() {
		return originalDataService;
	}

	public void setOriginalDataService(OriginalDataService originalDataService) {
		this.originalDataService = originalDataService;
	}

	public FiltrateService getFiltrateService() {
		return filtrateService;
	}

	public void setFiltrateService(FiltrateService filtrateService) {
		this.filtrateService = filtrateService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public KeyWordService getKeyWordService() {
		return keyWordService;
	}

	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}


	//模型驱动的方法
	public KeyWord getModel() {
		// TODO Auto-generated method stub
		return keyWord;
	}
	
	//根据目录id查询关键字的方法
	public String findById(){
		//从request对象中获取目录id
		HttpServletRequest request  = ServletActionContext.getRequest();
		String tid = request.getParameter("id");
		int id = Integer.parseInt(tid);		//将id转换成整型
		System.out.println("关键字id："+id);
		//从数据库查询关键字,将结果保存到keyWord对象中
		System.out.println(id);
		List<KeyWord> list =  keyWordService.findById(id);
		String a = BecomeJson(list);
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print(a);
			System.out.println(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	
	
	
	//修改关键字的方法
	public String updateKey(){
		String result = "";
		result = keyWordService.updateKey(keyWord);
		//关键字修改后，关系表中的数据以会改变，因此需要删除该目录下的分类数据
		List<IndexData> dataList= indexDataService.findByIndexID(keyWord.getIndexId());
		for(int i = 0; i < dataList.size(); i++){
			indexDataService.delete(dataList.get(i));
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8"); 
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	
	//增加关键字
	public String addKey(){
		String result = "";
		HttpServletRequest request  = ServletActionContext.getRequest();
		//从session中获取目录id
		String indexId = request.getSession().getAttribute("indexId").toString(); 
		int indexid = Integer.valueOf(indexId);
		//将目录id保存到keyWord对象中
		keyWord.setIndexId(indexid);
		keyWord.setKeyColumn(1);
		//判断禁用关键字和关键字所属是否为空，若为空则默认为禁用和全部对话
		if(keyWord.getIsUse() == null){
			keyWord.setIsUse(1);
		}
		if(keyWord.getClientAndservice() == null){
			keyWord.setClientAndservice(3);
		}
		result = keyWordService.insertKey(keyWord);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8"); 
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	
	//删除关键字
	public String deleteKey(){
		String result = "";
		HttpServletRequest request  = ServletActionContext.getRequest();
		String tid = request.getParameter("ids");
		//将数据去除空格和转成字符串数据
		String id[] = tid.split(",");
		int idi[] = new int[id.length];
		//将字符串数组转int数组
		for(int i = 0; i < id.length; i++){
			idi[i] = Integer.valueOf(id[i].trim());
			System.out.println(idi[i]);
		}
		System.out.println(idi.length);
		int iID = 0;
		for(int j = 0; j < idi.length; j++){
			KeyWord key = keyWordService.findId(idi[j]);	//根据id查询关键字信息
			iID = key.getIndexId();
			result = keyWordService.deleteKey(key);	//删除关键字信息
		}
		if(result.equals("删除成功！")){
			//删除该目录绑定的数据（关键字修改后分后后数据信息也要相应的删除）根据目录id查询数据
			List<IndexData> dList = indexDataService.findByIndexID(iID);
			if(dList.size()>0){
				//循环删除关系表的数据
				for(int k = 0; k < dList.size(); k++){
					indexDataService.delete(dList.get(k));
				}
			}
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8"); 
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		
		return NONE;
	}
	
	//跳转到关键字页面
	public String keyFirst(){
		HttpServletRequest request  = ServletActionContext.getRequest();
		String tid = request.getParameter("id");
		int indexId = Integer.parseInt(tid);
		// 将获取到的目录id存入到session中，供添加关键字是用
		ServletActionContext.getRequest().getSession().setAttribute("indexId", indexId);
		return "keyFirst";
	}
	

	//转换数据成json数据
	public String BecomeJson(Object cDto){
		Gson gson=new Gson();
		String json=gson.toJson(cDto);
		return json;
	}

}
