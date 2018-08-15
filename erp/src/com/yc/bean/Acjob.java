package com.yc.bean;

import java.io.Serializable;

public class Acjob implements Serializable{

	/**
	 *1	id
		2	jodid
		3	username
		4	sex
		5	birthday
		6	ismarry
		7	school
		8	studydegree
		9	specialty
		10	gradyear
		11	telephone
		12	email
		13	address
		14	ability
		15	resumes
		16	join_date
		17	position
 
	 */
	private static final long serialVersionUID = -1388527785439961356L;
	
	private Integer id;
	private Integer jobid;
	private String username;
	private String sex;
	private String brithday;
	private String ismarry;
	private String school;
	private String studydegree;
	private String specialty;
	private String gradyear;
	private String telephone;
	private String email;
	private String address;
	private String ability;
	private String resumes;
	private String join_date;
	private String position;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJobid() {
		return jobid;
	}
	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	public String getIsmarry() {
		return ismarry;
	}
	public void setIsmarry(String ismarry) {
		this.ismarry = ismarry;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getStudydegree() {
		return studydegree;
	}
	public void setStudydegree(String studydegree) {
		this.studydegree = studydegree;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getGradyear() {
		return gradyear;
	}
	public void setGradyear(String gradyear) {
		this.gradyear = gradyear;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public String getResumes() {
		return resumes;
	}
	public void setResumes(String resumes) {
		this.resumes = resumes;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Acjob [id=" + id + ", jobid=" + jobid + ", username="
				+ username + ", sex=" + sex + ", brithday=" + brithday
				+ ", ismarry=" + ismarry + ", school=" + school
				+ ", studydegree=" + studydegree + ", specialty=" + specialty
				+ ", gradyear=" + gradyear + ", telephone=" + telephone
				+ ", email=" + email + ", address=" + address + ", ability="
				+ ability + ", resumes=" + resumes + ", join_date=" + join_date
				+ ", position=" + position + "]";
	}
	
	
}
