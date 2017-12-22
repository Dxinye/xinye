package com.elite.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.elite.excel.OutPutExcel;
import com.elite.excel.OutPutExcelFiltrate;
import com.elite.excel.ReadExcel;
import com.elite.excel.ReadFilePath;
import com.elite.service.OriginalDataService;
import com.elite.vo.OriginalData;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author rd
 *
 */
public class OriginalDataAction extends ActionSupport implements ModelDriven<OriginalData> {
	//注入实体类对象
	private OriginalData originalData ;
	//注入service层对象
	private OriginalDataService originalDataService;
	
	private String fileName;
	//注入OutPutExcel
	private OutPutExcel outPutExcel;
	//注入OutPutExcelFiltrate
	private OutPutExcelFiltrate outPutExcelFiltrate;
	
	
	
	public OutPutExcelFiltrate getOutPutExcelFiltrate() {
		return outPutExcelFiltrate;
	}
	public void setOutPutExcelFiltrate(OutPutExcelFiltrate outPutExcelFiltrate) {
		this.outPutExcelFiltrate = outPutExcelFiltrate;
	}
	public OutPutExcel getOutPutExcel() {
		return outPutExcel;
	}
	public void setOutPutExcel(OutPutExcel outPutExcel) {
		this.outPutExcel = outPutExcel;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public OriginalData getOriginalData() {
		return originalData;
	}
	public void setOriginalData(OriginalData originalData) {
		this.originalData = originalData;
	}
	public OriginalDataService getOriginalDataService() {
		return originalDataService;
	}
	public void setOriginalDataService(OriginalDataService originalDataService) {
		this.originalDataService = originalDataService;
	}
	
	//模型驱动的方法
	@Override
	public OriginalData getModel() {
		if(originalData==null){
			originalData = new OriginalData();
		}
		return originalData;
	}
	
	/**
	 * 查询全部数据
	 * @return
	 */
	public String selectAction(){
		List<OriginalData> oList = new ArrayList<OriginalData>();
		oList = originalDataService.findByAll();
		String a = BecomeJson(oList);
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(oList.size());
		return NONE;
	}
	
	//根据对话开始时间查询数据并导出excel表（原数据）
	public String findOriginalByDate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		List<OriginalData> oList = originalDataService.findOriginalByDate(date1,date2);
		//将查询出来的数据存到集合当参数传给createExcel（）方法导出excel表
		outPutExcel.createExel(oList);
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print("已导出时间间隔为"+date1+"到"+date2+"的数据！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	//导出全部数据
	public String outOriginalAll(){
		List<OriginalData> oList = originalDataService.findByAll();
		outPutExcel.createExel(oList);
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print("已导出全部数据！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	//导出分类后全部数据
	public String filtrateData(){
		List<OriginalData> oList = originalDataService.select();
		outPutExcelFiltrate.outExelFiltrate(oList);
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print("已导出全部数据！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	//根据时间导出分类后的数据
	public String filtrateByDate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String filtrateDate = request.getParameter("filtrateDate");
		String filtrateDate1 = request.getParameter("filtrateDate1");
		List<OriginalData> oList = originalDataService.findOriginalByDate(filtrateDate,filtrateDate1);
		//将查询出来的数据存到集合当参数传给createExcel（）方法导出excel表
		outPutExcelFiltrate.outExelFiltrate(oList);
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print("已导出时间间隔为"+filtrateDate+"到"+filtrateDate1+"的数据到F盘！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	
	/**
	 * 模糊查询的action方法
	 * @return
	 */
	public String findAllAction(){
		
		return null;
	}
	/**
	 * 分离客户客服对话内容
	 * @return
	 */
	public String partData(){
		
		return "";
	}
	//跳转到原数据页面
	public String originalList(){
		return "originalList";
	}
	
	//跳转到原数据（等级为3，只能查看、导入，不能导出）
	public String originalListRank3(){
		return "originalListRank";
	}
	
	//转换数据成json数据
	public String BecomeJson(Object cDto){
		Gson gson=new Gson();
		String json=gson.toJson(cDto);
		return json;
	}
	
}
