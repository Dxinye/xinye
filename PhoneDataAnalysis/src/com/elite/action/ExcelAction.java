package com.elite.action;

import com.opensymphony.xwork2.ActionSupport;

public class ExcelAction extends ActionSupport{
	
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	} 
	
	public String readExcel(){
		
		return NONE;
	}
	
}
