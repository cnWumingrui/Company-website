package com.yc.bean;

import java.io.Serializable;

public class Webconfig implements Serializable {

	/**
	 * 1	id	int
	2	web_name	varchar2
	3	join_date	date
	4	Url	varchar2
	5	logo	varchar2
	6	email	varchar2
	7	banner	varchar2
	8	banquan	varchar2

	 */
	private static final long serialVersionUID = -3665622472022270124L;

	private Integer id;
	private String web_name;
	private String join_date;
	private String Url;
	private String logo;
	private String email;
	private String banner;
	private String banquan;
	
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
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getBanquan() {
		return banquan;
	}
	public void setBanquan(String banquan) {
		this.banquan = banquan;
	}
	@Override
	public String toString() {
		return "Webconfig [id=" + id + ", web_name=" + web_name
				+ ", join_date=" + join_date + ", Url=" + Url + ", logo="
				+ logo + ", email=" + email + ", banner=" + banner
				+ ", banquan=" + banquan + "]";
	}
	
	
}
