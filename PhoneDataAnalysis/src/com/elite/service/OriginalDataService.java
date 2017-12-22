package com.elite.service;

import java.util.List;

import com.elite.vo.KeyWord;
import com.elite.vo.OriginalData;
import com.sun.org.apache.xpath.internal.operations.Or;

public interface OriginalDataService {
	/**
	 * 添加数据的接口
	 * @param originalData
	 */
	public void insert(OriginalData originalData);
	
	/**
	 * 查询全部数据的接口
	 * @return	返回list集合
	 */
	public List<OriginalData> select();
	
	/**
	 * 根据id查询数据的接口
	 * @param o
	 * @return	返回list集合
	 */
	public List<OriginalData> selectOne(OriginalData o);
	
	/**
	 * 导出分类后数据的方法
	 * @return 返回List<>集合
	 */
	public List<OriginalData> findAll(List<KeyWord> keyList);
	
	/**
	 * 查询全部数据的房法
	 * @return
	 */
	public List<OriginalData> findByAll();
	
	/**
	 * 分离对话内容方法
	 * @param o
	 * @return 返回分离结果是是否成功
	 */
	public String partData(OriginalData o);

	/**
	 * 根据对话开始时间查询数据
	 * @param date1
	 * @param date2
	 * @return 返回查询结果
	 */
	public List<OriginalData> findOriginalByDate(String date1, String date2);

	/**
	 * 修改数据的方法 
	 * @param originalData
	 */
	public void updateOriginalData(OriginalData originalData);

	/**
	 * 根据时间和关键字对数据进行分类
	 * @param key
	 * @param date1
	 * @param date2
	 * @return	List<OriginalData> 集合
	 */
	public List<OriginalData> findBydate(List<KeyWord> keyList, String date1, String date2);
	
}
