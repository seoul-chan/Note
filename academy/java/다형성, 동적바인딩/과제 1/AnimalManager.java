package practice3.controller;

import practice3.model.vo.Animal;
import practice3.model.vo.Cat;
import practice3.model.vo.Dog;

public class AnimalManager {
	public static void main(String[] args) {
		Animal[] a = new Animal[5];
		a[0]=new Dog("aa","11",12);
		a[1]=new Dog("bb","21",20);
		a[2]=new Cat("cc", "36", "seoul", "black");
		a[3]=new Dog("dd","49",17);
		a[4]=new Cat("ee", "52", "ansan", "pink");
		
		for(int i=0;i<5;i++) {
			a[i].speak();
		}
	}
}
