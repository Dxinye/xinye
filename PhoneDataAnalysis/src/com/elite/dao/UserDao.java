package com.elite.dao;

import java.util.List;

import com.elite.vo.UserTable;

/**
 * user类dao层接口
 * @author rd
 *
 */
public interface UserDao {

	/**
	 * dao层用户注册的方法
	 * @param user 参数是UserTable对象
	 */
	public void insertUser(UserTable user);
	
	/**
	 * dao层用户等录的方法
	 * @param user 参数是UserTable对象
	 */
	public UserTable findLogin(UserTable user);
	
	/**
	 * dao层根据用户名查询用户
	 * @param userName
	 * @return 返回类对象
	 */
	public UserTable findByName(String userName);

	/**
	 * dao层查询所有用户的接口
	 * @return 返回List集合
	 */
	public List<UserTable> findAllUser();

	/**
	 * dao层修改用户信息接口
	 * @param user
	 */
	public void updateUser(UserTable user);

	/**
	 * dao层删除用户信息接口
	 * @param user
	 */
	public void destroyUser(UserTable user);

}
