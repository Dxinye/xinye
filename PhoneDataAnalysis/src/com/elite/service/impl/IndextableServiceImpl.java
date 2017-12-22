package com.elite.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.elite.dao.IndextableDao;
import com.elite.service.IndextableService;
import com.elite.service.KeyWordService;
import com.elite.vo.Indextable;

public class IndextableServiceImpl implements IndextableService {
	//注入indextableDao;
	private IndextableDao indextableDao;
	

	public IndextableDao getIndextableDao() {
		return indextableDao;
	}

	public void setIndextableDao(IndextableDao indextableDao) {
		this.indextableDao = indextableDao;
	}

	@Override
	public List<Indextable> select() {
		List<Indextable> list = indextableDao.select();
		return list;
	}

	@Override
	public List<Indextable> selectById(int id) {
		List<Indextable> list = indextableDao.selectById(id);
		return list;
	}

	@Override
	public Indextable selectRootNode(int id) {
		System.out.println(id);
		return indextableDao.selectRootNode(id);
	}
	
	//更新实现的方法
	public void updateIndex(Indextable indextable) {
		indextableDao.updateIndex(indextable);
	}

	//添加目录的service实现方法
	public void insertIndex(Indextable indextable) {
		indextableDao.insertIndex(indextable);
		
	}

	//刪除目录的service实现方法
	public void deleteIndex(Indextable indextable) {
		/*List<Indextable> iList = new ArrayList<Indextable>();
		Indextable i1 = new Indextable();
		iList = selectById(indextable.getId());
		if(iList.size()>0){
			for (int i = 0; i < iList.size(); i++) {
				i1=iList.get(i);
				indextableDao.deleteInde(i1);
			}
			
		}*/
		
		
		indextableDao.deleteInde(indextable);
		
	}

	@Override
	public Indextable findById(Integer id) {
		
		return indextableDao.findById(id);
	}

	@Override
	public List<Indextable> selectByIdAll(Integer id) {
		List<Indextable> listById = new ArrayList<>();
		List<Indextable> iList = indextableDao.selectById(id);
		if(iList != null){
			for(int i=0;i<iList.size();i++){
				int k = iList.get(i).getId();
				iList = indextableDao.selectById(k);
			}
		}
		listById.addAll(iList);
		return null;
	}
	
	
	
}
