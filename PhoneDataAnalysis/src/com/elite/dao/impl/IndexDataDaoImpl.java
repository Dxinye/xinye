package com.elite.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.elite.dao.IndexDataDao;
import com.elite.vo.IndexData;

public class IndexDataDaoImpl extends HibernateDaoSupport implements IndexDataDao {

	//添加方法
	public void insert(IndexData ID) {
		this.getHibernateTemplate().save(ID);
	}

	//修改方法
	public void update(IndexData ID) {
		this.getHibernateTemplate().update(ID);
	}

	//删除方法
	public void delete(IndexData ID) {
		this.getHibernateTemplate().delete(ID);
	}

	//查询全部的方法
	public List<IndexData> findAll() {
		String hql = "from IndexData";
		List<IndexData> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<IndexData> findByDataID(Integer id) {
		String hql = "from IndexData where dID = ?";
		List<IndexData> list = this.getHibernateTemplate().find(hql,id);
		return list;
	}

	@Override
	public List<IndexData> findByIndexID(int id) {
		String hql = "from IndexData where indexID = ?";
		List<IndexData> dList = null;
		dList = this.getHibernateTemplate().find(hql,id);
		return dList;
	}

}
