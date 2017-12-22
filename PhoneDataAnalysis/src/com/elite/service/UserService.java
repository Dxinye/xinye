package com.elite.service;

import java.util.List;

import com.elite.vo.UserTable;

/**
 * user类service层的接口
 * @author rd
 *
 */
public interface UserService {
	
	/**
	 * service层，用户注册的方法
	 * @param user 参数是UserTable对象
	 * 返回String字符串，判断注册是否成功
	 */
	public void insertUser(UserTable user) throws Exception;
	
	/**
	 * service层，用户登录的方法
	 * @param user 参数是usertable对象
	 */
	public UserTable findLogin(UserTable user);

	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return 返回UserTable对象
	 */
	public UserTable findByName(String userName);

	/**
	 * 查询所有用户的service接口方法
	 * @return 返回List集合
	 */
	public List<UserTable> findAllUser();

	/**
	 * 修改用户信息接口
	 * @param user
	 * @return 返回错误信息
	 */
	public String updateUser(UserTable user);

	/**
	 * 删除用户信息
	 * @param user
	 * @return 返回错误信息
	 */
	public String destroyUser(UserTable user);
	
	

}
