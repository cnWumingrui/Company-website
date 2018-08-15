package com.yc.bean;

import java.io.Serializable;

public class Pronunciament implements Serializable {

	/**
	 * 1	id	int
	2	title	varchar2
	3	content	varchar2
	4	join＿date	date

	 */
	private static final long serialVersionUID = 6457653043767136916L;
	private Integer id;
	private String title;
	private String content;
	private String join＿date;
	
	public String getTitleFormat(){
		if(title!=null && title.length()>8){
			return title.substring(0,8)+"...";
		}else{
			return title;
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getJoin＿date() {
		return join＿date;
	}
	public void setJoin＿date(String join＿date) {
		this.join＿date = join＿date;
	}
	@Override
	public String toString() {
		return "Pronunciament [id=" + id + ", title=" + title + ", content="
				+ content + ", join＿date=" + join＿date + "]";
	}
	
}
