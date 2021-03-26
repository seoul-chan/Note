package com.home.model.vo;

import java.sql.Date;

public class Member {
	private int index;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String address;
	private String phone;
	private Date enrollDate;
	
	public Member() {}
	public Member(int index,String id, String pwd, String name,String email,String address,String phone,Date enrollDate) {
		this.index=index;
		this.id=id;
		this.pwd=pwd;
		this.name=name;
		this.email=email;
		this.address=address;
		this.phone=phone;
		this.enrollDate = enrollDate;
	}
	
	public int getIndex() {return index;}
	public String getId() {return id;}
	public String getPwd() {return pwd;}
	public String getName() {return name;}
	public String getEmail() {return email;}
	public String getAddress() {return address;}
	public String getPhone() {return phone;}
	public Date getEnrollDate() {return enrollDate;}
	
	public void setIndex(int index) {this.index=index;}
	public void setId(String id) {this.id=id;}
	public void setPwd(String pwd) {this.pwd=pwd;}
	public void setName(String name) {this.name=name;}
	public void setEmail(String email) {this.email=email;}
	public void setAddress(String address) {this.address=address;}
	public void setPhone(String phone) {this.phone=phone;}
	public void setEnrollDate(Date enrollDate) {this.enrollDate = enrollDate;}
	
	@Override
	public String toString() {
		return "Member [회원번호=" + index + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", enrollDate=" + enrollDate + "]";
	}	
}
