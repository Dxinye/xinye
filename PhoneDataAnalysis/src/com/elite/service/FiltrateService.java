package com.elite.service;

import java.util.List;

import com.elite.vo.Filtrate;
/**
 * 分类后数据的service层接口
 * @author rd
 *
 */
public interface FiltrateService {
	/**
	 * 增加分类后数据的接口
	 * @param filtrate
	 */
	public void insertFiltrate(Filtrate filtrate);
	
	/**
	 * 查询全部数据分类后数据的接口
	 * @return
	 */
	public List<Filtrate> findAllFiltrate();
	
	/**
	 * 修改分类后数据的service接口
	 * @param filtrate	参数是filtrate对象
	 */
	public void updateFilte(Filtrate filtrate);
	
	/**
	 * 根据流水号查询对话内容
	 * @param serRdNumber
	 */
	public Filtrate findByIdFiltrate(String serRdNumber);
	
	/**
	 * 根据目录id查询出分类后的数据内容
	 * @param id	参数是目录的id
	 * @return	返回Filrate集合数据
	 */
	public List<Filtrate> findByIndexId(Integer id);

	/**
	 * 根据时间查询数据
	 * @param filtrateDate
	 * @param filtrateDate1
	 */
	public List<Filtrate> findByDate(String filtrateDate, String filtrateDate1);

}
