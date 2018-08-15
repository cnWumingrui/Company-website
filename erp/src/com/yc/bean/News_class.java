package com.yc.bean;

import java.io.Serializable;

public class News_class implements Serializable {

	/**
	 *1	id	int
	2	typename	nnvarchar
 
	 */
	private static final long serialVersionUID = -5147963278647725108L;
	
	private Integer id;
	private String typename;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "News_class [id=" + id + ", typename=" + typename + "]";
	}
	
}
