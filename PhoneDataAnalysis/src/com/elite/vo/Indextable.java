package com.elite.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Indextable implements java.io.Serializable{
	
	private Integer id;	//节点id
	private Integer parentID;	//父节点id
	private String text;	//目录名称
	private String attributes;	//其它属性
	private String state;
	private List<Indextable> children = new ArrayList<>();	
    private Indextable parent;
    private int level;
    private Integer dataID;
    
    //private Set<KeyWord> keyWord = new HashSet<KeyWord>();
	
	/*public Set<KeyWord> getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(Set<KeyWord> keyWord) {
		this.keyWord = keyWord;
	}*/



	public Indextable(){
		
	}
	
	
	
	public Indextable(Integer id, Integer parentID, String text, List<Indextable> children, Indextable parent,
			int level,String attributes,String state,Integer dataID) {
		super();
		this.id = id;
		this.parentID = parentID;
		this.text = text;
		this.children = children;
		this.parent = parent;
		this.level = level;
		this.attributes = attributes;
		this.state = state;
		this.dataID = dataID;
	}



	public Indextable(Integer id, Integer parentID, String text) {
		super();
		this.id = id;
		this.parentID = parentID;
		this.text = text;
	}
	
	public String getState() {
		return state;
	}

	public List<Indextable> getChildren() {
		return children;
	}

	public void setChildren(List<Indextable> children) {
		this.children = children;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getDataID() {
		return dataID;
	}

	public void setDataID(Integer dataID) {
		this.dataID = dataID;
	}

	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public Indextable getParent() {
		return parent;
	}

	public void setParent(Indextable parent) {
		this.parent = parent;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Integer getParentID() {
		return parentID;
	}
	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}
	
	public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }
	
}
