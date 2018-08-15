package com.yc.bean;

import java.io.Serializable;

public class Leave_word implements Serializable {

	/**
	 * 1	id	int
	2	username	varchar2
	3	firmname	varchar2
	4	contactman	varchar2
	5	ring	varchar2
	6	fax	varchar2
	7	email	varchar2
	8	title	varchar2
	9	content	varchar2
	10	renew	varchar2
	11	join_date	date

	 */
	private static final long serialVersionUID = -8588906340136151213L;
	private Integer id;
	private String username;
	private String firmname;
	private String contactman;
	private String ring;
	private String fax;
	private String email;
	private String title;
	private String content;
	private String renew;
	private String join_date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirmname() {
		return firmname;
	}
	public void setFirmname(String firmname) {
		this.firmname = firmname;
	}
	public String getContactman() {
		return contactman;
	}
	public void setContactman(String contactman) {
		this.contactman = contactman;
	}
	public String getRing() {
		return ring;
	}
	public void setRing(String ring) {
		this.ring = ring;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getRenew() {
		return renew;
	}
	public void setRenew(String renew) {
		this.renew = renew;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	@Override
	public String toString() {
		return "Leave_word [id=" + id + ", username=" + username
				+ ", firmname=" + firmname + ", contactman=" + contactman
				+ ", ring=" + ring + ", fax=" + fax + ", email=" + email
				+ ", title=" + title + ", content=" + content + ", renew="
				+ renew + ", join_date=" + join_date + "]";
	}
	
	
}
