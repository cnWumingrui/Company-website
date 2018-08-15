package com.yc.bean;

import java.io.Serializable;

public class Job implements Serializable {

	/**
	 * 1	id	int
		2	inviter	varchar2
		3	number	int
		4	address	varchar2
		5	wage	varchar2
		6	expressdate	date
		7	demand	varchar2
		8	join_date	date

	 */
	private static final long serialVersionUID = 3269168303291493482L;

	private Integer id;
	private String inviter;
	private Integer number;
	private String address;
	private String wage;
	private String expressdate;
	private String demand;
	private String join_date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInviter() {
		return inviter;
	}
	public void setInviter(String inviter) {
		this.inviter = inviter;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	public String getExpressdate() {
		return expressdate;
	}
	public void setExpressdate(String expressdate) {
		this.expressdate = expressdate;
	}
	public String getDemand() {
		return demand;
	}
	public void setDemand(String demand) {
		this.demand = demand;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", inviter=" + inviter + ", number=" + number
				+ ", address=" + address + ", wage=" + wage + ", expressdate="
				+ expressdate + ", demand=" + demand + ", join_date="
				+ join_date + "]";
	}
	
	
	
}
