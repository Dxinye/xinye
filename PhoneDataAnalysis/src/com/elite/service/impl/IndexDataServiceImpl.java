package com.elite.service.impl;

import java.util.List;

import com.elite.dao.IndexDataDao;
import com.elite.service.IndexDataService;
import com.elite.vo.IndexData;
/**
 * 关系表的业务层的实现类
 * @author rd
 *
 */
public class IndexDataServiceImpl implements IndexDataService {
	//注入indexDataDao
	private IndexDataDao indexDataDao;
	
	
	public IndexDataDao getIndexDataDao() {
		return indexDataDao;
	}

	public void setIndexDataDao(IndexDataDao indexDataDao) {
		this.indexDataDao = indexDataDao;
	}

	
	//添加数据
	public void insert(IndexData ID) {
		indexDataDao.insert(ID);
	}

	//修改数据
	public void update(IndexData ID) {
		indexDataDao.update(ID);

	}

	//删除数据
	public void delete(IndexData ID) {
		indexDataDao.delete(ID);
	}

	//查询全部数据
	public List<IndexData> findAll() {
		List<IndexData> idList = indexDataDao.findAll();
		return idList;
	}

	@Override
	public List<IndexData> findByDataId(Integer id) {
		List<IndexData> list = indexDataDao.findByDataID(id);
		return list;
	}

	@Override
	public List<IndexData> findByIndexID(int id) {
		List<IndexData> dList = indexDataDao.findByIndexID(id);
		return dList;
	}

}
