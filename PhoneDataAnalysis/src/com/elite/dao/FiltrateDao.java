package com.elite.dao;

import java.util.List;

import com.elite.vo.Filtrate;

/**
 * Filtrate 类dao层的接口
 * @author rd
 *
 */
public interface FiltrateDao {
	/**
	 * 添加分类后的数据的到层方法接口
	 * @param filtrate
	 */
	public void insertFiltrate(Filtrate filtrate);
	
	/**
	 * 查询分类后的数据的dao方法接口
	 * @return
	 */
	public List<Filtrate> findAllFiltrate();
	
	/**
	 * 修改分类后数据的接口
	 * @param filtrate 参数是Filtrate对象。
	 */
	public void updateFilte(Filtrate filtrate);

	/**
	 * dao根据流水号查询对话内容接口
	 * @param serRdNumber
	 */
	public Filtrate findByIdFiltrate(String serRdNumber);
	
	/**
	 * dao层根据目录id查询分类后数据的接口
	 * @param id参数是目录id
	 * @return	返回Filtrate集合
	 */
	public List<Filtrate> findByIndexId(Integer id);
	
	/**
	 * 根据时间查询数据
	 * @param filtrateDate
	 * @param filtrateDate1
	 * @return
	 */
	public List<Filtrate> findByDate(String filtrateDate, String filtrateDate1);
	
}
