package com.elite.dao;

import java.util.List;

import com.elite.vo.IndexData;

/**
 * 关系表数据的到层接口
 * @author rd
 *
 */
public interface IndexDataDao {

	/**
	 * dao层的添加目录和数据关系的方法
	 * @param ID
	 */
	public void insert(IndexData ID);
	/**
	 * dao层修改关系表的业务层方法
	 * @param ID
	 */
	public void update(IndexData ID);
	/**
	 * dao层根据id删除关系表数据
	 * @param id
	 */
	public void delete(IndexData ID);
	
	/**
	 * dao层查询全部关系表的数据方法
	 * 返回list集合
	 * @return
	 */
	public List<IndexData> findAll();
	
	/**
	 * dao层根据数据id查询目录id的方法
	 * @param id
	 * @return
	 */
	public List<IndexData> findByDataID(Integer id);
	
	/**
	 * dao层根据目录id查询数据
	 * @param id
	 * @return
	 */
	public List<IndexData> findByIndexID(int id);
	
}
