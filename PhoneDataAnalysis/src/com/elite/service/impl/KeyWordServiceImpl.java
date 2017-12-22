package com.elite.service.impl;

import java.util.List;

import com.elite.dao.KeyWordDao;
import com.elite.service.KeyWordService;
import com.elite.vo.KeyWord;

public class KeyWordServiceImpl implements KeyWordService {
	//注入KeyWord
	private KeyWordDao keyWordDao;
	
	public KeyWordDao getKeyWordDao() {
		return keyWordDao;
	}

	public void setKeyWordDao(KeyWordDao keyWordDao) {
		this.keyWordDao = keyWordDao;
	}

	
	@Override
	public String insertKey(KeyWord keyWord) {
		String result  = "fail";
		try{
			keyWordDao.insertKey(keyWord);
			result = "success";
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateKey(KeyWord keyWord) {
		// TODO Auto-generated method stub
		String result = "fail";
		try {
			keyWordDao.updateKey(keyWord);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		//keyWordDao.updateKey(keyWord);
		return result;
	}

	@Override
	public String deleteKey(KeyWord keyWord) {
		String result = "删除失败！";
		try{
			keyWordDao.deleteKey(keyWord);
			result = "删除成功！";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<KeyWord> findById(Integer indexID) {
		
		return keyWordDao.findById(indexID);
	}

	//查询全部的关键字方法
	public List<KeyWord> findAll() {
		List<KeyWord> kList = keyWordDao.findAll();
		return kList;
	}

	@Override
	public KeyWord findId(Integer id) {
		
		return keyWordDao.findId(id);
	}

}
