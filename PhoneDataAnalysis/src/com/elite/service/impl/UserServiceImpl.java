package com.elite.service.impl;

import java.util.List;

import com.elite.dao.UserDao;
import com.elite.service.UserService;
import com.elite.vo.UserTable;
/**
 * user类service层接口实现类
 * @author rd
 *
 */
public class UserServiceImpl implements UserService {
	//注入UserDao
	private UserDao userDao;

	//用户注册方法
	public void insertUser(UserTable user) throws Exception {
		//String result = "fail";	
		user.setUserIsActivate(0); //设置初始状态账号为未激活状态；0为未激活，1为激活
		user.setUserRank(3); 	//设置账号初始等级为只能查看数据等级；1表示超级管理员，2表示只有读写功能，3表示只有查看数据功能；
		/*try {
			userDao.insertUser(user);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;*/
		
		userDao.insertUser(user);
	}

	//用户登录方法
	public UserTable findLogin(UserTable user) {
		//UserTable user1 = userDao.findByName(user.getUserName());
		/*if(user1 == null){
			return user1;
		}else{
			user.setUserIsActivate(1);	//设置用户的状态为1
			return userDao.findLogin(user);
		}*/
		UserTable user1 = new UserTable();
		user1.setUserName(user.getUserName());
		user1.setUserPassword(user.getUserPassword());
		user1.setUserIsActivate(1);
		return userDao.findLogin(user1);
	}
	
	//根据用户名查询用户
	public UserTable findByName(String userName) {
		UserTable user1 = userDao.findByName(userName);
		return user1;
	}
	
	//查询所有用户的方法
	public List<UserTable> findAllUser() {
		List<UserTable> list = userDao.findAllUser();
		return list;
	}
	
	//修改用户信息方法
	public String updateUser(UserTable user) {
		String result ="修改失败";
		try {
			userDao.updateUser(user);
			result = "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//删除用户信息
	public String destroyUser(UserTable user) {
		String result = "fail";
		try {
			userDao.destroyUser(user);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	

	

	

}
