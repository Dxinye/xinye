package com.elite.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.elite.dao.IndextableDao;
import com.elite.vo.Indextable;

public class IndextableDaoImpl extends HibernateDaoSupport implements IndextableDao{

	@Override
	public List<Indextable> select() {
		String hql = "from Indextable";
		List<Indextable> list = getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<Indextable> selectBySize(String moreSql) {
		//String hql = "from Indextable where parentID = ?";
		List<Indextable> list = getHibernateTemplate().find("from Indextable"+moreSql);
		
		return list;
	}
	
	//根据父id查询节点
	public List<Indextable> selectById(int id) {
		//String hql = "from Indextable where parentID = ?";
		List<Indextable> list = getHibernateTemplate().find("from Indextable where parentID = "+id+" ");
		
		return list;
	}

	@Override
	public Indextable selectRootNode(int id) {
		//String hql = "from Indextable where parentID = 0";
		System.out.println(id);
		List<Indextable> list = this.getHibernateTemplate().find("from Indextable where parentID = "+id+" ");
		System.out.println(id);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	//dao层实现接口的更新目录方法
	public void updateIndex(Indextable indextable) {
		this.getHibernateTemplate().update(indextable);
	}

	//dao層的實現方法
	public void insertIndex(Indextable indextable) {
		this.getHibernateTemplate().save(indextable);
	}

	//dao層刪除的實現方法
	public void deleteInde(Indextable indextable) {
		this.getHibernateTemplate().delete(indextable);
	}

	@Override
	public Indextable findById(Integer id) {
		List<Indextable> list = this.getHibernateTemplate().find("from Indextable where id = "+id+" ");
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
	

}
