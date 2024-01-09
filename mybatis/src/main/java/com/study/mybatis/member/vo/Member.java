package com.study.mybatis.member.vo;

import java.sql.Date;

import oracle.sql.DATE;

public class Member {
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String email;
	private String birthday;
	private String gender;
	private String phone;
	private String address;
	private Date enroll_date;
	private Date modify_date;
	private String status;
	
	public Member() {}

	public Member(String user_id, String user_pwd, String user_name, String email, String birthday, String gender,
			String phone, String address, Date enroll_date, Date modify_date, String status) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.enroll_date = enroll_date;
		this.modify_date = modify_date;
		this.status = status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_name=" + user_name + ", email=" + email
				+ ", birthday=" + birthday + ", gender=" + gender + ", phone=" + phone + ", address=" + address
				+ ", enroll_date=" + enroll_date + ", modify_date=" + modify_date + ", status=" + status + "]";
	}
}
