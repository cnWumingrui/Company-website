package com.yc.bean;

import java.io.Serializable;

public class Friendlink implements Serializable {

	/**
	 * 1	id	int
		2	web_name	varchar2
		3	web_address	varchar2

	 */
	private static final long serialVersionUID = 881023768416377821L;

	private Integer id;
	private String web_name;
	private String web_address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWeb_name() {
		return web_name;
	}
	public void setWeb_name(String web_name) {
		this.web_name = web_name;
	}
	public String getWeb_address() {
		return web_address;
	}
	public void setWeb_address(String web_address) {
		this.web_address = web_address;
	}
	@Override
	public String toString() {
		return "Friendlink [id=" + id + ", web_name=" + web_name
				+ ", web_address=" + web_address + "]";
	}
	
	
}
