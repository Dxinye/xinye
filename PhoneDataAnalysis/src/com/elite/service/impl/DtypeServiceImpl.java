package com.elite.service.impl;

import java.util.List;

import com.elite.dao.DtypeDao;
import com.elite.service.DypeService;
import com.elite.vo.Dtype;
/**
 * 数据所属类型操作接口的实现类
 * @author rd
 *
 */
public class DtypeServiceImpl implements DypeService {
	private DtypeDao dtypeDao;
	
	
	public DtypeDao getDtypeDao() {
		return dtypeDao;
	}

	public void setDtypeDao(DtypeDao dtypeDao) {
		this.dtypeDao = dtypeDao;
	}

	//添加数据所属类型
	public void insertType(Dtype type) {
		dtypeDao.insertType(type);
	}

	@Override
	public void update(Dtype type) {
		dtypeDao.update(type);
	}

	@Override
	public void deleteType(Dtype type) {
		dtypeDao.deleteType(type);
	}

	@Override
	public List<Dtype> findAll() {
		List<Dtype> typeList = dtypeDao.findAll();
		return typeList;
	}

	@Override
	public List<Dtype> findByDataId(int dataId) {
		List<Dtype> typeList = dtypeDao.findByDataId(dataId);
		return typeList;
	}

	@Override
	public void findById(Dtype dtype) {
		// TODO Auto-generated method stub
		
	}

}
