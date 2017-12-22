package com.elite.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.elite.dao.UserDao;
import com.elite.vo.UserTable;


/**
 * user类dao层接口的实现类
 * @author rd
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	//注册方法
	public void insertUser(UserTable user) {
		this.getHibernateTemplate().save(user);
	}

	//用户登录方法
	public UserTable findLogin(UserTable user) {
		//String hql = "from UserTable where userName = ? and userPassword = ? and userIsActivate = 1";
		
		List<UserTable> uList = this.getHibernateTemplate().findByExample(user);
		if(uList != null && uList.size()>0){
			return uList.get(0);
		}
		return null;
	}

	@Override
	public UserTable findByName(String userName) {
		String hql = "from UserTable where user_name = ?";
		List<UserTable> list = this.getHibernateTemplate().find(hql,userName);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	//查询所有用户的方法
	public List<UserTable> findAllUser() {
		
		String hql = "from UserTable";
		List<UserTable> uList = this.getHibernateTemplate().find(hql);
		return uList;
		
		
	}

	//修改用户信息方法
	public void updateUser(UserTable user) {
		this.getHibernateTemplate().update(user);
	}

	//删除用户信息方法
	public void destroyUser(UserTable user) {
		this.getHibernateTemplate().delete(user);
	}

}
