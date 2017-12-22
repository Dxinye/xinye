package com.elite.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 	跳转到登录页面
	 * @return
	 */
	public String loginFirst(){
		System.out.println("访问");
		return "login";
	}
	//跳转到文件上传页面(原数据)
	public String fileUpload(){
		
		return "fileUpload";
	}
	
	//跳转到注册页面
	public String JumpRegist(){
		return "JumpRegist";
	}
	
	//跳转到录入目录的文件上传页面
	public String fileUploadIndex(){
		return "fileUploadIndex";
	}
	
	//跳转到录入关键字的页面
	public String fileUploadKeyWord(){
		return "fileUploadKeyWord";
	}
	
	//跳转到根据时间分类页面
	public String filtrateByDate(){
		
		return "filtrateByDate";
	}
	
}
