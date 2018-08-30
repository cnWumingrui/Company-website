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

	private Integer admin_id;
	private String admin_username;
	private String admin_userpassword;
	private String admin_join_time;
	
	public Admin() {
	}
	public Admin(Integer id, String username, String userpassword,
			String join_time) {
		this.admin_id = id;
		this.admin_username = username;
		this.admin_userpassword = userpassword;
		this.admin_join_time = join_time;
	}
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_username() {
		return admin_username;
	}
	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
	public String getAdmin_userpassword() {
		return admin_userpassword;
	}
	public void setAdmin_userpassword(String admin_userpassword) {
		this.admin_userpassword = admin_userpassword;
	}
	public String getAdmin_join_time() {
		return admin_join_time;
	}
	public void setAdmin_join_time(String admin_join_time) {
		this.admin_join_time = admin_join_time;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_username="
				+ admin_username + ", admin_userpassword=" + admin_userpassword
				+ ", admin_join_time=" + admin_join_time + "]";
	}
	
	
}
