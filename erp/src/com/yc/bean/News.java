package com.yc.bean;

import java.io.Serializable;

public class News implements Serializable {

	/**
	 *	1	id	int
		2	title	nnvarchar
		3	typeid	nnvarchar
		4	content	ntext
		5	picture	nnvarchar
		6	laiz	nnvarchar
		7	join_date	smalldatetime
		8	change_date	smalldatetime
		9	imgurl	nvarchar
		10	picnum	char
		11	imgtext	char
		12	imglink	char
		13	imgAlt	char
 
	 */
	private static final long serialVersionUID = -1850670895436268588L;
	
	private Integer id;
	private String title;
	private String typeid;
	private String content;
	private String picture;
	private String laiz;
	private String join_date;
	private String change_date;
	private String imgurl;
	private String picnum;
	private String imgtext;
	private String imglink;
	private String imgAlt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitleFormat(){
		if(title!=null  && title.length()>8){
			return title.substring(0,8)+"...";
		}else{
			return title;
		}
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
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
	public String getLaiz() {
		return laiz;
	}
	public void setLaiz(String laiz) {
		this.laiz = laiz;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getChange_date() {
		return change_date;
	}
	public void setChange_date(String change_date) {
		this.change_date = change_date;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getPicnum() {
		return picnum;
	}
	public void setPicnum(String picnum) {
		this.picnum = picnum;
	}
	public String getImgtext() {
		return imgtext;
	}
	public void setImgtext(String imgtext) {
		this.imgtext = imgtext;
	}
	public String getImglink() {
		return imglink;
	}
	public void setImglink(String imglink) {
		this.imglink = imglink;
	}
	public String getImgAlt() {
		return imgAlt;
	}
	public void setImgAlt(String imgAlt) {
		this.imgAlt = imgAlt;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", typeid=" + typeid
				+ ", content=" + content + ", picture=" + picture + ", laiz="
				+ laiz + ", join_date=" + join_date + ", change_date="
				+ change_date + ", imgurl=" + imgurl + ", picnum=" + picnum
				+ ", imgtext=" + imgtext + ", imglink=" + imglink + ", imgAlt="
				+ imgAlt + "]";
	}
	
}
