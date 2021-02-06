package com.poly.model.vo;

public class Cat extends Animal{
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, String category, int age, int weight, char gender, String habitat) {
		super(name, category, age, weight, gender, habitat);
		// TODO Auto-generated constructor stub
	}
	
	public void barkCat() {
		System.out.println("¾ß¿Ë");
	}
	
	@Override
	public void bark() {
		barkCat();
	}
}
