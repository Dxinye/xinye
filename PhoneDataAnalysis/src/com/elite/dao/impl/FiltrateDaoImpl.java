package com.elite.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.elite.dao.FiltrateDao;
import com.elite.vo.Filtrate;

public class FiltrateDaoImpl extends HibernateDaoSupport implements FiltrateDao {

	@Override
	public void insertFiltrate(Filtrate filtrate) {
		this.getHibernateTemplate().save(filtrate);
	}

	@Override
	public List<Filtrate> findAllFiltrate() {
		String hql = "from Filtrate";
		List<Filtrate> fFist = this.getHibernateTemplate().find(hql);
		return fFist;
	}

	@Override
	public void updateFilte(Filtrate filtrate) {
		this.getHibernateTemplate().update(filtrate);
	}

	@Override
	public Filtrate findByIdFiltrate(String serRdNumber) {
		String hql = "from Filtrate where ser_rdNumber =? ";
		List<Filtrate> fList = this.getHibernateTemplate().find(hql, serRdNumber);
		if(fList.size()>0){
			return fList.get(0);
		}
		return null;
	}

	@Override
	public List<Filtrate> findByIndexId(Integer id) {
		String hql = "from Filtrate where keywordID = ? ";
		List<Filtrate> fList = this.getHibernateTemplate().find(hql, id);
		return fList;
	}

	@Override
	public List<Filtrate> findByDate(String filtrateDate, String filtrateDate1) {
		//String hql = "from Filtrate where conversation_startTime <= ? and conversation_startTime >= ?";
		String hql = "from Filtrate where conversation_startTime >='" +filtrateDate +"' and conversation_startTime <='" +filtrateDate1+"'";
		List<Filtrate> fList = this.getHibernateTemplate().find(hql);
		return fList;
	}

}
