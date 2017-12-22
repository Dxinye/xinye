package com.elite.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.elite.dao.OriginalDataDao;
import com.elite.vo.OriginalData;

public class OriginalDataDaoImpl extends HibernateDaoSupport implements OriginalDataDao {

	@Override
	public void insert(OriginalData originalData) {
		getHibernateTemplate().save(originalData);
		
	}
	
	@Override
	public List<OriginalData> showOriginalData() {
		System.out.println("已执行查询的dao层方法");
		List<OriginalData> list = getHibernateTemplate().find("from OriginalData");
		return list;
	}

	@Override
	public List<OriginalData> selectById(String id) {
		List<OriginalData> list= getHibernateTemplate().find(id);
		return list;
	}

	@Override
	public List<OriginalData> findAll(String hql) {
		//String hql = "from OriginalData where 1=1";
		//this.getHibernateTemplate()
		List<OriginalData> oList = this.getHibernateTemplate().find(hql);
		return oList;
	}

	//分离对话内容
	public void partData(OriginalData o) {
		this.getHibernateTemplate().save(o);
	}

	@Override
	public List<OriginalData> findOriginalByDate(String date1, String date2) {
		String hql = "from OriginalData where conversation_startTime >= '" +date1+ "' and conversation_startTime <= '" +date2+"'";
		List<OriginalData> oList = this.getHibernateTemplate().find(hql);
		return oList;
	}

	@Override
	public void updateOriginalData(OriginalData originalData) {
		this.getHibernateTemplate().update(originalData);
	}

	@Override
	public OriginalData findDataById(Integer id) {
		String hql = "from OriginalData where ID = ?";
		List<OriginalData> list =this.getHibernateTemplate().find(hql,id);
		return list.get(0);
	}
	

	/*public List<OriginalData> findSome(OriginalData od) {
		String hql = "from OriginalData where 1=1 ";
		//this.getHibernateTemplate()
		if(od.getClientCity()!=null&&!"".equals(od.getClientCity())){
			hql = hql + "and ClientCity="+od.getClientCity();
		}
		List<OriginalData> oList = this.getHibernateTemplate().find(hql);
		return oList;
	}*/

	
}
