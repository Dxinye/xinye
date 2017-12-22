package com.elite.dao;

import java.util.List;

import com.elite.vo.Indextable;

public interface IndextableDao {
	/**
	 * 
	 * @return
	 */
	public List<Indextable> select();

	/**
	 * dao根据ParentId查询目录树数据层方法
	 * 
	 * @return
	 */
	public List<Indextable> selectById(int id);
	/**
	 * 模糊查询的接口
	 * @param moreSql
	 * @return
	 */
	public List<Indextable> selectBySize(String moreSql);
	
	/**
	 * dao层查询根节点目录树数据
	 * 
	 * @param id
	 * @return
	 */
	public Indextable selectRootNode(int id);

	/**
	 * dao層的更新目錄方法
	 * @param indextable
	 */
	public void updateIndex(Indextable indextable);
	
	/**
	 * dao層的添加接口
	 * @param indextable
	 */
	public void insertIndex(Indextable indextable);
	
	/**
	 * 
	 * dao層的刪除方法接口
	 * @param indextable
	 */
	public void deleteInde(Indextable indextable);
	
	/**
	 * dao根据id查询节点的信息接口
	 * @param id
	 * @return
	 */
	public Indextable findById(Integer id);

}
