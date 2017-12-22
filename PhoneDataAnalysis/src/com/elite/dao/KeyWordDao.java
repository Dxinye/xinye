package com.elite.dao;

import java.util.List;

import com.elite.vo.KeyWord;

public interface KeyWordDao {
	/**
	 * 添加关键字的
	 * @param keyWord
	 */
	public void insertKey(KeyWord keyWord);
	
	/**
	 * 
	 * @param keyWord
	 */
	public void updateKey(KeyWord keyWord);
	
	/**
	 * 删除关键字的方法
	 * @param id
	 */
	public void deleteKey(KeyWord keyWord);
	/**
	 * 根据id查询关键字的doa层接口
	 * @param keywordID
	 * @return
	 */
	public List<KeyWord> findById(Integer indexID);
	
	/**
	 * 查询全部关键字的dao层方法
	 * @return
	 */
	public List<KeyWord> findAll();
	
	/**
	 * 根据id查询关键字内容
	 * @param id
	 * @return KeyWord对象
	 */
	public KeyWord findId(Integer id);
	
}
