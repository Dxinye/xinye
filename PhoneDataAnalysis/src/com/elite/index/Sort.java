package com.elite.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.elite.service.DypeService;
import com.elite.service.IndexDataService;
import com.elite.service.IndextableService;
import com.elite.service.KeyWordService;
import com.elite.service.OriginalDataService;
import com.elite.vo.Dtype;
import com.elite.vo.IndexData;
import com.elite.vo.Indextable;
import com.elite.vo.KeyWord;
import com.elite.vo.OriginalData;

public class Sort {
	//实体类
	private Indextable indextable = new Indextable();
	//注入indextableService
	private IndextableService indextableService;
	//注入keyWordService
	private KeyWordService keyWordService;
	//注入originalDataService
	private OriginalDataService originalDataService;
	//注入IndexDataService
	private IndexDataService indexDataService;
	//实体类IndexData
	private IndexData indexData = new IndexData();
	//注入DtypeService
	private DypeService dtypeService;
	
	
	public int num =0;
	private int[]a = new int[10];
	//private List<int[]> intList = new ArrayList<>();
	
	
	
	/**
	 * 利用递归根据当前id查询其全部父id
	 * @param id
	 */
	public void findParent(int id){
		//StringBuffer str = new StringBuffer();
		//根据当前id查询出目录值
		String str = "";
		Dtype dtype = new Dtype();
		Indextable index = indextableService.findById(id);
		//查询保存数据类型的数据
		List<Dtype> typeList = dtypeService.findAll();
		if(index.getParentID() != 0){
			str = typeList.get(0).getDataType();
			if("".equals(str) || str==null){
				str = index.getText();
			}else{
				str = index.getText() + "->" + str;
			}
			dtype.setTypeId(1);
			dtype.setDataType(str);
			dtypeService.update(dtype);
			findParent(index.getParentID());
		}else{
			str = typeList.get(0).getDataType();
			str = index.getText() + "->" + str;
			dtype.setTypeId(1);
			dtype.setDataType(str);
			dtypeService.update(dtype);
		}
	}
	
	/**
	 * 判断目录是否是叶子（最后一级目录）
	 * @param index
	 * @return
	 */
	public Boolean leaf(int index){
		Boolean flag = false;
		List<Indextable> iList = indextableService.selectById(index);
		if(iList.size() ==0){
			flag = true;
		}
		return flag;
	}
	
	
	
	public IndexData getIndexData() {
		return indexData;
	}


	public void setIndexData(IndexData indexData) {
		this.indexData = indexData;
	}


	public IndextableService getIndextableService() {
		return indextableService;
	}


	public void setIndextableService(IndextableService indextableService) {
		this.indextableService = indextableService;
	}


	public KeyWordService getKeyWordService() {
		return keyWordService;
	}


	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}


	public OriginalDataService getOriginalDataService() {
		return originalDataService;
	}


	public void setOriginalDataService(OriginalDataService originalDataService) {
		this.originalDataService = originalDataService;
	}


	public Indextable getIndextable() {
		return indextable;
	}


	public void setIndextable(Indextable indextable) {
		this.indextable = indextable;
	}


	public IndexDataService getIndexDataService() {
		return indexDataService;
	}


	public void setIndexDataService(IndexDataService indexDataService) {
		this.indexDataService = indexDataService;
	}

	public DypeService getDtypeService() {
		return dtypeService;
	}

	public void setDtypeService(DypeService dtypeService) {
		this.dtypeService = dtypeService;
	}
	
	
}
