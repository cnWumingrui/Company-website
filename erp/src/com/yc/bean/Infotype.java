package com.yc.bean;

import java.io.Serializable;

public class Infotype implements Serializable {

	/**
	 * 1	id	int
		2	typename	varchar2

	 */
	private static final long serialVersionUID = 3937838688961095829L;

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
		return "Infotype [id=" + id + ", typename=" + typename + "]";
	}
	
	
}
