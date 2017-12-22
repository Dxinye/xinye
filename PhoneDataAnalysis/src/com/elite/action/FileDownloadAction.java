package com.elite.action;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport{
	
	 private String fn;  //文件名
	    private String path;  //路径

	    public String getFn() {
	        return fn;
	    }

	    public void setFn(String fn) {
	        this.fn = fn;
	    }

	    public String getPath() {
	        return path;
	    }

	    public void setPath(String path) {
	        this.path = path;
	    }

	    @Override
	    public String execute() throws Exception {
	        return SUCCESS;
	    }
	    public InputStream getInputStream() throws Exception{
	        //获得路径和文件名
	        String ip=ServletActionContext.getServletContext().getRealPath(path)+"/"+fn;
	        InputStream is=new FileInputStream(ip);
	        return is;
	    }
	
}
