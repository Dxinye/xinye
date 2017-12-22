package com.elite.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.elite.excel.OutPutExcelFiltrate;
import com.elite.service.FiltrateService;
import com.elite.service.KeyWordService;
import com.elite.vo.Filtrate;
import com.elite.vo.KeyWord;
import com.elite.vo.OriginalData;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FiltrateAction extends ActionSupport implements ModelDriven<Filtrate>{
	//注入模型驱动
	private Filtrate filtrate;
	//注入service
	private FiltrateService filtrateService;
	//注入keyWordservice
	private KeyWordService keyWordService;
	//接收目录id的值
	private int id;
	//注入outPutExcelFiltrate
	private OutPutExcelFiltrate outPutExcelFiltrate;
	/*//接收时间参数
	private String filtrateDate;
	private String filtrateDate1;*/
	
	/*public String getFiltrateDate() {
		return filtrateDate;
	}
	public void setFiltrateDate(String filtrateDate) {
		this.filtrateDate = filtrateDate;
	}
	public String getFiltrateDate1() {
		return filtrateDate1;
	}
	public void setFiltrateDate1(String filtrateDate1) {
		this.filtrateDate1 = filtrateDate1;
	}*/
	public OutPutExcelFiltrate getOutPutExcelFiltrate() {
		return outPutExcelFiltrate;
	}
	public void setOutPutExcelFiltrate(OutPutExcelFiltrate outPutExcelFiltrate) {
		this.outPutExcelFiltrate = outPutExcelFiltrate;
	}
	public KeyWordService getKeyWordService() {
		return keyWordService;
	}
	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FiltrateService getFiltrateService() {
		return filtrateService;
	}
	public void setFiltrateService(FiltrateService filtrateService) {
		this.filtrateService = filtrateService;
	}
	public Filtrate getFiltrate() {
		return filtrate;
	}
	public void setFiltrate(Filtrate filtrate) {
		this.filtrate = filtrate;
	}

	//模型驱动的方法
	public Filtrate getModel() {
		if(filtrate ==null){
			filtrate = new Filtrate();
		}
		return filtrate;
	}
	/**
	 * 添加分类后数据的方法
	 * @return
	 */
	public String insertFiltrate(){
		return NONE;
	}
	/**
	 * 修改分类后的数据方法
	 * @return
	 */
	public String updateFiltrate(){
		filtrateService.updateFilte(filtrate);
		return NONE;
	}
	/**
	 * 根据目录id查询分类后的数据
	 * @return
	 */
	public String findByIndexID(){
		//根据目录id查询出对应的关键字id
		/*KeyWord keyWord = keyWordService.findById(id);
		//根据关键字id查询分类后对应目录的数据
		List<Filtrate> fList = filtrateService.findByIndexId(keyWord.getKeywordID());*/
		return null;
	}
	
	/**
	 * 查询全部分类后数据的action方法
	 * @return
	 */
	public String findAllFiltrate(){
		List<Filtrate> fList = filtrateService.findAllFiltrate();
		//outPutExcelFiltrate.outExelFiltrate(fList);
		String a = BecomeJson(fList);
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
	 * 导出分类后全部数据方法
	 * @return
	 */
	public String outFiltrate(){
		List<Filtrate> fList = filtrateService.findAllFiltrate();
		//outPutExcelFiltrate.outExelFiltrate(fList);
		return NONE;
	}
	
	/**
	 * 根据时间查询分类后数据
	 * @return
	 */
	public String findByDate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取时间参数
		String filtrateDate = request.getParameter("filtrateDate");
		String filtrateDate1 = request.getParameter("filtrateDate1");
		//根据传回来的时间参数查询数据
		List<Filtrate> list = filtrateService.findByDate(filtrateDate,filtrateDate1);
		//调用方法导出数据
		//outPutExcelFiltrate.outExelFiltrate(list);
		/*String date = BecomeJson(filtrateDate);
		String date1 = BecomeJson(filtrateDate1);*/
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print("已导出时间间隔为"+filtrateDate+"到"+filtrateDate1+"的数据！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
		return NONE;
	}
	
	//跳转到查看数据的action
	public String filtrateList(){
		return "filtrateList";
	}
	
	//跳转到查看数据的页面（等级三）只能查看和录入数据
	public String filtrateListRank3(){
		return "filtrateListRank";
	}
	
	//转换数据成json数据
	public String BecomeJson(Object cDto){
		Gson gson=new Gson();
		String json=gson.toJson(cDto);
		return json;
	}

}
