package com.elite.service;

import java.util.List;

import com.elite.vo.IndexData;
/**
 * 业务层的目录和数据关系链接表
 * @author rd
 *
 */
public interface IndexDataService {
	/**
	 * 业务层的添加目录和数据关系的方法
	 * @param ID
	 */
	public void insert(IndexData ID);
	/**
	 * 修改关系表的业务层方法
	 * @param ID
	 */
	public void update(IndexData ID);
	/**
	 * 根据删除关系表数据的业务层方法
	 * @param id
	 */
	public void delete(IndexData ID);
	
	/**
	 * 业务层查询全部关系表的数据方法
	 * @return
	 */
	public List<IndexData> findAll();
	
	/**
	 * 业务层根据数据id查询目录id的方法
	 * @param id
	 * @return	返回list集合
	 */
	public List<IndexData> findByDataId(Integer id);
	
	/**
	 * 业务层根据目录id查询数据
	 * @param id
	 * @return
	 */
	public List<IndexData> findByIndexID(int id);
	
}
