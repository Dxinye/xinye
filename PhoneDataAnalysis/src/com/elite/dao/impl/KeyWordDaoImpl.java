package com.elite.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.elite.dao.KeyWordDao;
import com.elite.vo.Indextable;
import com.elite.vo.KeyWord;

public class KeyWordDaoImpl extends HibernateDaoSupport implements KeyWordDao {

	@Override
	public void insertKey(KeyWord keyWord) {
		this.getHibernateTemplate().save(keyWord);
	}

	@Override
	public void updateKey(KeyWord keyWord) {
		this.getHibernateTemplate().update(keyWord);

	}

	@Override
	public void deleteKey(KeyWord keyWord) {
		this.getHibernateTemplate().delete(keyWord);
	}

	@Override
	public List<KeyWord> findById(Integer indexID) {
		String hql = "from KeyWord where indexId = ?";
		List<KeyWord> list = this.getHibernateTemplate().find(hql,indexID);
		return list;
	}

	@Override
	public List<KeyWord> findAll() {
		String hql = "from KeyWord";
		List<KeyWord> kList = this.getHibernateTemplate().find(hql);
		return kList;
	}

	@Override
	public KeyWord findId(Integer id) {
		String hql = "from KeyWord where keywordID = ?";
		List<KeyWord> kList = this.getHibernateTemplate().find(hql,id); 
		if(kList.size()>0){
			return kList.get(0);
		}
		return null;
	}

}
