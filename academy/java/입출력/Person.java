package com.io.model.vo;

import java.io.Serializable;

public class Person implements Serializable{
	
	//아래 코드는 자동 작성된 코드이다. 해당 코드가 없는 경우 
	//Person에서 경고문이 뜨는데 Add generated serial Version ID 클릭 시 무작위 값을 출력해준다.
	private static final long serialVersionUID = -1446892394112895351L; //무작위로 중복되지 않음 값 출력
	
	
	private String name;
	private int age;
	private char gender;
	private double height;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age, char gender, double height) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return name +","+ age +","+ gender +","+ height;
	}
}
