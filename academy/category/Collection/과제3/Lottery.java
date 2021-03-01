package com.kh.practice.set.model.vo;

public class Lottery {
	private String name;
	private String phone;
	
	public Lottery() {}
	public Lottery(String name, String phone) {
		this.name=name;
		this.phone=phone;
	}
	
	public String getName() {return name;}
	public String getPhone() {return phone;}
	public void setName(String name) {this.name=name;}
	public void setPhone(String phone) {this.phone=phone;}
	
	@Override
	public String toString() {
		return "["+name+", "+phone+"]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Lottery) {
			Lottery lo =(Lottery)obj;
			if(name.equals(lo.getName())
					&&phone.equals(lo.getPhone()))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (name+phone).hashCode();
	}
}
