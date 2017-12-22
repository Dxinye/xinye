package com.elite.vo;

import java.io.Serializable;
/**
 * 同义词表实体类
 * @author rd
 *
 */
@SuppressWarnings("serial")
public class Synonyms implements Serializable{
	private Integer synonymsID;
	private String synonymsValue;
	
	
	public Integer getSynonymsID() {
		return synonymsID;
	}
	public void setSynonymsID(Integer synonymsID) {
		this.synonymsID = synonymsID;
	}
	public String getSynonymsValue() {
		return synonymsValue;
	}
	public void setSynonymsValue(String synonymsValue) {
		this.synonymsValue = synonymsValue;
	}

}
