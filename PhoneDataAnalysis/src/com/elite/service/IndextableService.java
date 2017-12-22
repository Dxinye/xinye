package com.elite.service;

import java.util.List;

import com.elite.vo.Indextable;

public interface IndextableService {
	/**
	 * 业务层的查询全部的目录方法
	 * @return
	 */
	public List<Indextable> select();
	/**
	 * 业务层的根据父id查询目录树数据方法
	 * @return
	 */
	public List<Indextable> selectById(int id);
	
	/**
	 * 查询根目录的业务层方法
	 * @param i
	 * @return
	 */
	public Indextable selectRootNode(int id);
	/**
	 * 更新目录的service接口方法
	 * @param indextable
	 */
	public void updateIndex(Indextable indextable);
	/**
	 * 添加目录的service接口
	 * @param indextable
	 */
	public void insertIndex(Indextable indextable);
	
	/**
	 * 刪除目录的service接口
	 * @param indextable
	 */
	public void deleteIndex(Indextable indextable);
	
	/**
	 * 根据id查询目录信息
	 * @param id
	 */
	public Indextable findById(Integer id);
	
	/**
	 * 根据id查询出改目录下的所有子目录
	 * @param id
	 * @return 返回一个list集合
	 */
	public List<Indextable> selectByIdAll(Integer id);
	
	
}
