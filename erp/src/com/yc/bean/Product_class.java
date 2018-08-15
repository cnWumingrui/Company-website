package com.yc.bean;

import java.io.Serializable;

public class Product_class implements Serializable {

	/**
	 * 1	id	int
	2	protype	nnvarchar

	 */
	private static final long serialVersionUID = -2816596824118539658L;

	private Integer id;
	private String protype;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProtype() {
		return protype;
	}
	public void setProtype(String protype) {
		this.protype = protype;
	}
	@Override
	public String toString() {
		return "Product_class [id=" + id + ", protype=" + protype + "]";
	}
	
}
