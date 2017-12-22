package com.elite.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.elite.dao.DtypeDao;
import com.elite.vo.Dtype;

public class DtypeDaoImpl extends HibernateDaoSupport implements DtypeDao {

	@Override
	public void insertType(Dtype type) {
		this.getHibernateTemplate().save(type);
	}

	@Override
	public void update(Dtype type) {
		this.getHibernateTemplate().update(type);
	}

	@Override
	public void deleteType(Dtype type) {
		this.getHibernateTemplate().delete(type);
	}

	@Override
	public List<Dtype> findAll() {
		String hql = "from Dtype";
		List<Dtype> typeList = this.getHibernateTemplate().find(hql);	
		return typeList;
	}

	@Override
	public List<Dtype> findByDataId(int dataId) {
		String hql = "from Dtype where dataId = ?";
		List<Dtype> typeList  = this.getHibernateTemplate().find(hql,dataId);
		return typeList;
	}

}
