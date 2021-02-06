package com.poly.model.vo;

public class Animal {
	private String name;
	private String category;
	private int age;
	private int weight;
	private char gender;
	private String habitat;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	public Animal(String name, String category, int age, int weight, char gender, String habitat) {
		super();
		this.name = name;
		this.category = category;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
		this.habitat = habitat;
	}
	
	public void bark() {
		System.out.println("움음소리구현");
	}



	@Override
	public String toString() {
		return category+" "+name+" "+age+" " + weight+ " " +gender+ " " +habitat; 
	}
}
