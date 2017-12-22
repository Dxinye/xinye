package com.elite.dao;

import java.util.List;

import com.elite.vo.OriginalData;

public interface OriginalDataDao {
	
	/**
	 * 添加通话内容的dao接口
	 * @param originalData 参数是类对象
	 */
	public void insert(OriginalData originalData);
	
	/**
	 * 查询通话内容的接口
	 * @return	返回list集合
	 */
	public List<OriginalData> showOriginalData();
	
	//public OriginalData selectOne(String serviceRdnumber);
	
	/**
	 * 根据id查询通话内容
	 * @param id	参数为String类型的id
	 * @return	返回list集合
	 */
	public List<OriginalData> selectById(String id);
	
	/**
	 * 模糊查询通话内容的接口
	 * @return	返回list集合
	 */
	public List<OriginalData> findAll(String hql);
	
	public void partData(OriginalData o);

	/**
	 * dao层根据时间查询数据
	 * @param date1
	 * @param date2
	 * @return 返回list集合
	 */

	public List<OriginalData> findOriginalByDate(String date1, String date2);

	/**
	 * dao层修改数据的方法
	 * @param originalData
	 */
	public void updateOriginalData(OriginalData originalData);

	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	public OriginalData findDataById(Integer id);

	
}
