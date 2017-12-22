package com.elite.vo;

import java.io.Serializable;
/**
 * 同义词绑定的关键字表实体类
 * @author rd
 *
 */
@SuppressWarnings("serial")
public class Word implements Serializable{
	private Integer wordId;
	private String wordValue;
	private Integer synonymsID;
	
	
	public Integer getWordId() {
		return wordId;
	}
	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}
	public String getWordValue() {
		return wordValue;
	}
	public void setWordValue(String wordValue) {
		this.wordValue = wordValue;
	}
	public Integer getSynonymsID() {
		return synonymsID;
	}
	public void setSynonymsID(Integer synonymsID) {
		this.synonymsID = synonymsID;
	}
	
	
}
