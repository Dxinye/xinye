package com.elite.vo;

public class KeyWord implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer keywordID;	//关键字id
	private String keyValue;	//关键字值
	private Integer indexId;	//目录id
	private Integer keyColumn;	//关键字列的值
	private Integer clientAndservice;	//客户或客服，1位客服，2位客户，3位二者
	private Integer isUse;	//是否启用，1为启用，2为禁用
	
	
	public KeyWord(){
		
	}
	

	public KeyWord(Integer keywordID, String keyValue, Integer indexId, Integer keyColumn, Integer clientAndservice,
			Integer isUse) {
		super();
		this.keywordID = keywordID;
		this.keyValue = keyValue;
		this.indexId = indexId;
		this.keyColumn = keyColumn;
		this.clientAndservice = clientAndservice;
		this.isUse = isUse;
	}


	public Integer getKeywordID() {
		return keywordID;
	}


	public void setKeywordID(Integer keywordID) {
		this.keywordID = keywordID;
	}


	public String getKeyValue() {
		return keyValue;
	}


	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}


	public Integer getIndexId() {
		return indexId;
	}


	public void setIndexId(Integer indexId) {
		this.indexId = indexId;
	}


	public Integer getKeyColumn() {
		return keyColumn;
	}


	public void setKeyColumn(Integer keyColumn) {
		this.keyColumn = keyColumn;
	}


	public Integer getClientAndservice() {
		return clientAndservice;
	}


	public void setClientAndservice(Integer clientAndservice) {
		this.clientAndservice = clientAndservice;
	}


	public Integer getIsUse() {
		return isUse;
	}


	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	
	
	
	
	
}
