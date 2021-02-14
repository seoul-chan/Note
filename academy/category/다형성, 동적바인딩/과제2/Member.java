package com.kh.practice.chap01_poly.model.vo;

public class Member {
	private String name;
	private int age;
	private char gender;
	private int couponCount;
	
	public Member(){}
	public Member(String name, int age, char gender){
		this.name=name;
		this.age=age;
		this.gender=gender;
	}
	
	public void setName(String naem) {this.name=name;}
	public void setAge(int age) {this.age=age;}
	public void setGender(char gender) {this.gender=gender;};
	public void setCouponCount(int couponCount) {this.couponCount=couponCount;}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	public char getGender() {return gender;};
	public int getCouponCount() {return couponCount;}
	
	@Override
	public String toString() {
		return name+age+gender;
	}
	
}
