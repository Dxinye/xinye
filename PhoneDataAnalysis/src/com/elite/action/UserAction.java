package com.elite.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.elite.service.UserService;
import com.elite.vo.UserTable;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserTable>{
	//注入模型驱动属性
	private UserTable user;
	//注入Userservice
	private UserService userService;
	//接收userName参数
	
	/**
	 * 用户注册方法
	 * @return 
	 */
	public String userRegist(){
		try {
			UserTable user1 = userService.findByName(user.getUserName());
			if(user1 != null){
				return "registFail";
			}else{
				userService.insertUser(user);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "userRegist";
	}
	
	//根据用户名查询用户
	public String findUserName(){
		/*HttpServletRequest request = ServletActionContext.getRequest();
		request.getAttribute("");*/
		UserTable user1 = userService.findByName(user.getUserName());
		
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		
		if(user1 != null){
			try {
				response.getWriter().write("用户名已经存在！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.getWriter().write("用户名可用");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return NONE;
	}
	
	//用户登录
	public String loginUser(){
		
		UserTable userLogin = userService.findLogin(user);
		if(userLogin == null){
			this.addActionError("登录失败:用户名或密码错误或用户未激活!");
			return "login1";
		}else{
			// 登录成功
			// 将用户的信息存入到session中
			ServletActionContext.getRequest().getSession().setAttribute("userLogin", userLogin);
			if(userLogin.getUserRank() == 1){
				// 页面跳转
				return "loginUser";
			}
			if(userLogin.getUserRank() == 2){
				// 页面跳转
				return "loginUser2";
			}
			if(userLogin.getUserRank() == 3){
				// 页面跳转
				return "loginUser3";
			}
		}
		return null;
	}
	
	//用户退出
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	//查询所有用户
	public String findAllUser(){
		List<UserTable> uList = userService.findAllUser();
		//调用方法转成json格式
		String a = BecomeJson(uList);
		System.out.println(a);
		//利用response对象输出到jsp页面
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
	
	//修改用户方法
	public String updateUser(){
		String result = "用户名不能在此处修改！";
		UserTable user1 = userService.findByName(user.getUserName());
		if(user1 != null){
			/*try {
				userService.insertUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			user.setUserId(user1.getUserId());
			result = userService.updateUser(user);
		}
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	
	//删除用户信息
	public String destroyUser(){
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		String userName = request.getParameter("userName");
		UserTable user1 = userService.findByName(userName);
		if(user1 != null){
			result = userService.destroyUser(user1);
		}
		try {
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	
	//跳转到用户界面的action
	public String userList(){
		
		return "userList";
	}
	
	
	
	//转换数据成json数据
	public String BecomeJson(Object cDto){
		Gson gson=new Gson();
		String json=gson.toJson(cDto);
		return json;
	}
	
	
	
	//模型驱动的返回方法
	public UserTable getModel() {
		if(user == null){
			user = new UserTable();
		}
		return user;
	}

	/*public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}*/

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
