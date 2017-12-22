package com.elite.service;

import java.util.List;

import com.elite.vo.KeyWord;

public interface KeyWordService {
	/**
	 * service添加关键字的接口
	 * @param keyWord
	 */
	public String insertKey(KeyWord keyWord);
	
	/**
	 * service 修改关键字的接口
	 * @param keyWord
	 */
	public String updateKey(KeyWord keyWord);
	
	/**
	 * service 删除关键字的接口
	 * @param id
	 */
	public String deleteKey(KeyWord keyWord);

	/**
	 * service 根据目录id查询关键字
	 * @param keywordID
	 * @return
	 */
	public List<KeyWord> findById(Integer indexID);
	
	/**
	 * 查询全部关键字的
	 * @return
	 */
	public List<KeyWord> findAll();
	
	/**
	 * 根据id查询关键字信息
	 * @param id
	 * @return 返回KeyWord对象
	 */
	public KeyWord findId(Integer id);
	
}
