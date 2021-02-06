package com.poly.model.vo;

public class Mouse extends Animal{
	public Mouse() {
		// TODO Auto-generated constructor stub
	}

	public Mouse(String name, String category, int age, int weight, char gender, String habitat) {
		super(name, category, age, weight, gender, habitat);
		// TODO Auto-generated constructor stub
	}
	
	public void barkMouse() {
		System.out.println("ÂïÂï");
	}
}
