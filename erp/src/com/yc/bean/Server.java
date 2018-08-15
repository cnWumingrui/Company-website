package com.yc.bean;

import java.io.Serializable;

public class Server implements Serializable {

	/**
	 * 1	id	int
	2	title	varchar2
	3	content	varchar2
	4	pic	varchar2
	5	join_date	date
	6	picnum	char
	7	picname	varchar2

	 */
	private static final long serialVersionUID = 5943485356487260077L;
	
	private Integer id;
	private String title;
	private String content;
	private String pic;
	private String join_date;
	private String picnum;
	private String picname;
	
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getPicnum() {
		return picnum;
	}
	public void setPicnum(String picnum) {
		this.picnum = picnum;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	@Override
	public String toString() {
		return "Server [id=" + id + ", title=" + title + ", content=" + content
				+ ", pic=" + pic + ", join_date=" + join_date + ", picnum="
				+ picnum + ", picname=" + picname + "]";
	}
	
}
