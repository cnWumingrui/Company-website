package com.yc.bean;

import java.io.Serializable;

public class Companyinfo implements Serializable {

	/**
	 * 1	id	int
		2	typeid	    int
		3	title	varchar2
		4	content	varchar2
		5	picture	varchar2
		6	change_date	date

	 */
	private static final long serialVersionUID = 5029603324292221479L;
	
	private Integer id;
	private Integer typeid;
	private String title;
	private String content;
	private String picture;
	private String change_date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getChange_date() {
		return change_date;
	}
	public void setChange_date(String change_date) {
		this.change_date = change_date;
	}
	@Override
	public String toString() {
		return "Companyinfo [id=" + id + ", typeid=" + typeid + ", title="
				+ title + ", content=" + content + ", picture=" + picture
				+ ", change_date=" + change_date + "]";
	}
	
}
