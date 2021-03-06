package com.member.model.vo;

public class Member {
	private String name;
	private int age;
	private char gender;
	private String address;
	private String id;
	private int pw;
	private static int count;
	private int memberNo;
	
	{
		count++;
		memberNo=count;
	}
	
	public Member(){}
	public Member(String name, String id, int pw, String address, int age, char gender){
		this.name=name;
		this.id=id;
		this.pw=pw;
		this.address=address;
		this.age=age;
		this.gender=gender;
	}
	
	public void setName(String name) {this.name=name;}
	public void setId(String id) {this.id=id;}
	public void setPw(int pw) {this.pw=pw;}
	public void setAddress(String address) {this.address=address;}
	public void setAge(int age) {this.age=age;}
	public void setGender(char gender) {this.gender=gender;}
	public void setMemberNo(int memberNo) {this.memberNo=memberNo;}
	
	public String getName() {return name;}
	public String getId() {return id;}
	public int getPw() {return pw;}
	public String getAddress() {return address;}
	public int getAge() {return age;}
	public char getGender() {return gender;}
	public int getMemberNo() {return memberNo;}
	
	public String serchAll() {
		String info="";
		info+=memberNo+"\t"+name+"\t"+age+"\t"+gender+"\t"+address+"\t"+id+"\t"+"#####"+"\n";
		
		return info;
	}
}
