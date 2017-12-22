package com.elite.service.impl;

import java.util.List;

import com.elite.dao.FiltrateDao;
import com.elite.service.FiltrateService;
import com.elite.vo.Filtrate;
/**
 * service层的实现类
 * @author rd
 *
 */
public class FiltrateServiceImpl implements FiltrateService {
	private FiltrateDao filtrateDao;
	
	public FiltrateDao getFiltrateDao() {
		return filtrateDao;
	}

	public void setFiltrateDao(FiltrateDao filtrateDao) {
		this.filtrateDao = filtrateDao;
	}
	//添加数据的方法
	public void insertFiltrate(Filtrate filtrate) {
		
		filtrateDao.insertFiltrate(filtrate);
	}
	//查询全部的方法
	public List<Filtrate> findAllFiltrate() {
		List<Filtrate> fList = filtrateDao.findAllFiltrate();
		return fList;
	}

	@Override
	public void updateFilte(Filtrate filtrate) {
		filtrateDao.updateFilte(filtrate);
	}

	@Override
	public Filtrate findByIdFiltrate(String serRdNumber) {
		return filtrateDao.findByIdFiltrate(serRdNumber);
		
	}

	//根据目录id查询分类后的内容方法
	public List<Filtrate> findByIndexId(Integer id) {
		List<Filtrate> fList = filtrateDao.findByIndexId(id);
		return fList;
	}

	//根据时间查询数据
	public List<Filtrate> findByDate(String filtrateDate, String filtrateDate1) {
		List<Filtrate> fList = filtrateDao.findByDate(filtrateDate,filtrateDate1);
		return fList;
	}

}
