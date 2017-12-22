package com.elite.vo;

public class UserTable implements java.io.Serializable{
	private Integer userId;	//用户id
	private String userName;	//用户名
	private String userPassword;	//用户密码
	private String realName;	//用户真实姓名
	private Integer userRank;	//用户级别，1表示超级管理员，2表示只有读写功能，3表示只有查看数据功能；
	private Integer userIsActivate;	//账号是否激活，0为未激活，1已激活
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getUserRank() {
		return userRank;
	}
	public void setUserRank(Integer userRank) {
		this.userRank = userRank;
	}
	public Integer getUserIsActivate() {
		return userIsActivate;
	}
	public void setUserIsActivate(Integer userIsActivate) {
		this.userIsActivate = userIsActivate;
	}
	
}
