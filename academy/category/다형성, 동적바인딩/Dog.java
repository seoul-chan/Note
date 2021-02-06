package com.poly.model.vo;

public class Dog extends Animal{
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, String category, int age, int weight, char gender, String habitat) {
		super(name, category, age, weight, gender, habitat);
		// TODO Auto-generated constructor stub
	}
	
	public void barkDog() {
		System.out.println("¸Û¸Û");
	}
	
	@Override
	public void bark() {	//Animal¸Þ¼Òµå
		barkDog();
	}
}
