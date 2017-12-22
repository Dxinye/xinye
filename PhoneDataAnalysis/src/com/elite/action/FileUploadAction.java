package com.elite.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.elite.excel.DeleteFile;
import com.elite.excel.ReadExcel;
import com.elite.excel.ReadExcelIndex;
import com.elite.excel.ReadFilePath;
import com.elite.service.IndextableService;
import com.elite.service.KeyWordService;
import com.elite.service.OriginalDataService;
import com.elite.util.POIUtil;
import com.elite.vo.Indextable;
import com.elite.vo.KeyWord;
import com.elite.vo.OriginalData;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	//注入originalDataService
	private OriginalDataService originalDataService;
	//注入IndextableService
	private IndextableService indextableService;
	//注入
	private KeyWordService keyWordService;
	//注入POIUtil
	private POIUtil poiUtil;
	
	
	private String name;//
	private File[] fs; // 文件名
	private String[] fsFileName;
	private String[] fsContentType;// 文件类型

	private String path;// 文件路径
	private int size; // 文件大小
	// private ServletContext ctx;
	
	
	
	public String getName() {
		return name;
	}

	public POIUtil getPoiUtil() {
		return poiUtil;
	}

	public void setPoiUtil(POIUtil poiUtil) {
		this.poiUtil = poiUtil;
	}

	public KeyWordService getKeyWordService() {
		return keyWordService;
	}

	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}

	public IndextableService getIndextableService() {
		return indextableService;
	}

	public void setIndextableService(IndextableService indextableService) {
		this.indextableService = indextableService;
	}

	public OriginalDataService getOriginalDataService() {
		return originalDataService;
	}

	public void setOriginalDataService(OriginalDataService originalDataService) {
		this.originalDataService = originalDataService;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File[] getFs() {
		return fs;
	}

	public void setFs(File[] fs) {
		this.fs = fs;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String[] getFsFileName() {
		return fsFileName;
	}

	public void setFsFileName(String[] fsFileName) {
		this.fsFileName = fsFileName;
	}

	public String[] getFsContentType() {
		return fsContentType;
	}

	public void setFsContentType(String[] fsContentType) {
		this.fsContentType = fsContentType;
	}

	/*
	 * public void setServletContext(ServletContext ctx) { this.ctx=ctx; }
	 */

	// 文件上传并录入到数据库（原数据）
	public String fileOriginalData() throws Exception {
		// 获取文件的保存路径
		String p = ServletActionContext.getServletContext().getRealPath(path);
		File f = new File(p);
		if (!f.exists()) {
			f.mkdirs();
		}
		for (int i = 0; i < fs.length; i++) {
			System.out.println(path);
			System.out.println(p);
			System.out.println(size);
			System.out.println(fs[i].length());
			System.out.println("------------");

			/*
			 * 如果文件大于上传限定值
			 */
			if (fs[i].length() < size) {
				FileUtils.copyFile(fs[i], new File(f, fsFileName[i]));
			}
		}
		
		try {
			//调用读取excel表的方法
			List<String[]> dataList = poiUtil.readExcel(p);
			for(int i = 0; i<dataList.size(); i++){
				String[] data = dataList.get(i);
				OriginalData originalData = new OriginalData();
				//将数据保存到列表中
				originalData.setSerRdNumber(data[0]);
				originalData.setAcceptNumber(data[1]);
				originalData.setSkillQueue(data[2]);
				originalData.setWorkGroup(data[3]);
				originalData.setZuoxiNumber(data[4]);
				originalData.setSerName(data[5]);
				originalData.setSerNickname(data[6]);
				originalData.setVisitWay(data[7]);
				originalData.setVisitIp(data[8]);
				originalData.setIpProvice(data[9]);
				originalData.setBusinessType(data[10]);
				originalData.setClientRank(data[11]);
				originalData.setClientBrand(data[12]);
				originalData.setClientProvice(data[13]);
				originalData.setClientCity(data[14]);
				originalData.setConversationStartTime(data[15]);
				originalData.setConversationEndTime(data[16]);
				originalData.setConversationAssess(data[17]);
				originalData.setConversationTime(data[18]);
				originalData.setReplyIntervalTime(data[19]);
				originalData.setSatisfactionType(data[20]);
				originalData.setSolveType(data[21]);
				originalData.setEndPerson(data[22]);
				originalData.setEndReason(data[23]);
				originalData.setClientSpeakFrequency(data[24]);
				originalData.setSerSpeakFrequency(data[25]);
				originalData.setInteractionFrequency(data[26]);
				originalData.setIsvalidConversation(data[27]);
				originalData.setComment(data[28]);
				originalData.setConversationContent(data[29]);
				originalData.setRobotConversationContent(data[30]);
				List<OriginalData> or = originalDataService.selectOne(originalData);
				if (or.size() != 0) {
					System.out.println("数据已存在！");
					// 数据已存在则遍历结果集
					  /* for(int j=0;j<or.size();j++){ oo = or.get(j); //将结果赋值给实体类对象
					   if(oo.getSerRdNumber().equals(originalData.getSerRdNumber()))
					   { System.out.println("数据已存在！"); } }*/
				} else {
					// 调用service层方法录入数据
					originalDataService.insert(originalData);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 删除该上传文件
		DeleteFile.delAllFile(p);
		return NONE;
	}
	
	//目录的文件上传和导入数据
	public String uploadIndex(){
		// 获取文件的保存路径
		String p = ServletActionContext.getServletContext().getRealPath(path);
		File f = new File(p);
		if (!f.exists()) {
			f.mkdirs();
		}
		for (int i = 0; i < fs.length; i++) {
			System.out.println(path);
			System.out.println(p);
			System.out.println(size);
			System.out.println(fs[i].length());
			System.out.println("------------");

			/*
			 * 如果文件大于上传限定值
			 */
			if (fs[i].length() < size) {
				try {
					FileUtils.copyFile(fs[i], new File(f, fsFileName[i]));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			//调用读取excel表数据的方法
			 List<String[]> indexList = poiUtil.readExcel(p);
			//int b = indexList.size();
			 
			//循环遍历集合保存到数据库
			for(int i = 0;i < indexList.size();i++){
				//将数据保存到数组中
				String []index1 = indexList.get(i);
				Indextable index2 = new Indextable();
				double a = Double.parseDouble(index1[0]);
				index2.setParentID((int)a);		//将数组元素中的信息设置到对象中
				index2.setText(index1[1]);
				//调用业务层方法添加到数据库中
				indextableService.insertIndex(index2);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 删除该上传文件
		DeleteFile.delAllFile(p);
		return null;
	}
	
	/**
	 * 上传关键字文件，并保存到数据库
	 * @return
	 */
	public String uploadKey(){
		// 获取文件的保存路径
		String p = ServletActionContext.getServletContext().getRealPath(path);
		File f = new File(p);
		if (!f.exists()) {
			f.mkdirs();
		}
		for (int i = 0; i < fs.length; i++) {
			System.out.println(path);
			System.out.println(p);
			System.out.println(size);
			System.out.println(fs[i].length());
			System.out.println("------------");

			/*
			 * 如果文件大于上传限定值
			 */
			if (fs[i].length() < size) {
				try {
					FileUtils.copyFile(fs[i], new File(f, fsFileName[i]));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// 调用readXls方法读取excel表中数据保存到list集合
		try {
			 List<String[]> keyList = poiUtil.readExcel(p);
			//int b = keyList.size();
			//循环遍历集合保存到数据库
			for(int i = 0;i < keyList.size();i++){
				String[] keyWord = keyList.get(i);
				KeyWord key = new KeyWord();
				key.setKeyValue(keyWord[0]);
				double a = Double.parseDouble(keyWord[1]);
				key.setIndexId((int)a);
				double b = Double.parseDouble(keyWord[2]);
				key.setClientAndservice((int)b);
				double c = Double.parseDouble(keyWord[3]);
				key.setIsUse((int)c);
				keyWordService.insertKey(key);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 删除该上传文件
		DeleteFile.delAllFile(p);
		return NONE;
	}
	
	
	
	
	
	

}
