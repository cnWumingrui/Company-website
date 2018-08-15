package com.yc.bean;

import java.io.Serializable;

public class Admin implements Serializable {

	/**
	 * 	1	id	int
		2	username	varchar2
		3	userpassword	varchar2
		4	join_time	date

	 */
	private static final long serialVersionUID = 371525309521087732L;

	private Integer id;
	private String username;
	private String userpassword;
	private String join_time;
	
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
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getJoin_time() {
		return join_time;
	}
	public void setJoin_time(String join_time) {
		this.join_time = join_time;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", userpassword="
				+ userpassword + ", join_time=" + join_time + "]";
	}
	
	
}
