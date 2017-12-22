package com.elite.service;

import java.util.List;

import com.elite.vo.Dtype;

/**
 * 数据所属类别的业务层接口
 * @author rd
 *
 */
public interface DypeService {
	/**
	 * 添加数据所属的类型的方法
	 * @param type
	 */
	public void insertType(Dtype type);
	/**
	 * 修改数据所属类型的方法
	 * @param type
	 */
	public void update(Dtype type);
	/**
	 * 删除数据所属类型的方法
	 * @param type
	 */
	public void deleteType(Dtype type);
	/**
	 * 查询全部数据所属类型的方法
	 * @return
	 */
	public List<Dtype> findAll();
	/**
	 * 根据数据id查询数据所属类型
	 * @param dataId
	 * @return
	 */
	public List<Dtype> findByDataId(int dataId);
	
	/**
	 * 根据id查询数据
	 * @param dtype
	 */
	public void findById(Dtype dtype);
	
}
