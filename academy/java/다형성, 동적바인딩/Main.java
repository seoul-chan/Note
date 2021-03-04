package com.poly.run;

import com.poly.controller.AnimalFunction;
import com.poly.model.vo.Animal;
import com.poly.model.vo.Cat;
import com.poly.model.vo.Dog;
import com.poly.model.vo.Mouse;
import com.poly.model.vo.Rabbit;

public class Main {
	public static void main(String[] args) {
		//다형성은 상속관계에 있는 객체들에게 적용되는 기술
		//상속관계에 있는 객체 중 부모클래스 타입의 변수는 자식객체를
		//저장할 수 있는것을 의미한다.
		Animal a1 = new Animal();
		Animal a2 = new Dog(); //상속관계
		
		// 두 객체에 상속관계를 설정하면 가능해진다 -> 다형성
		a2=new Dog();
//		a2=new Cat();
		
		// 자식객체가 부모클래스의 자로형변수에 대입되면
		// 부모의 내용만 확인할 수 있게 된다. -> 자식의 내용은 이용이 불가능함.
		
		//부모클래스 자료형변수에 자식객체를 대입하고 자식에 있는
		//내용에 접근하려면 강제적 형변환을 해서 이용을 함
		
//		(Dog)a2.darkDog(); // 에러, (Dog)현변환 보다 .이 먼저 우선순위가 높다.
							//a2에서 .(직접접근)을 먼저 수행하기에 Dog의 멤버 이용 불가하다. 
		((Dog)a2).barkDog();
		
		a2=new Cat();
		((Cat)a2).barkCat();
		
		AnimalFunction af = new AnimalFunction();
		af.bark(new Dog());
		af.bark(new Cat());
		af.bark(new Rabbit());
		af.bark(new Mouse());
		
		//한개타입으로 여러 타입을 받을 수 있음
		//배열 객체배열! -> 한가지만(type) 사용이 간ㅇ!
		//부모의 타입으로 선언하면 4개의 자식 타입을 한개의 배열로 다 관리!
		Animal[] animals = new Animal[5];
		animals[0]=new Dog();
		animals[1]=new Dog();
		animals[2]=new Rabbit();
		animals[3]=new Rabbit();
		animals[4]=new Rabbit();
		
		int dogCount=0;
		int catCount=0;
		int rabbitCount=0;
		for(int i=0;i<animals.length;i++) {
			if(animals[i] instanceof Dog) {
				dogCount++;
				((Dog)animals[i]).barkDog();
			} else if(animals[i] instanceof Cat) {
				catCount++;
				((Cat)animals[i]).barkCat();
			} else if(animals[i] instanceof Rabbit) {
				rabbitCount++;
				((Rabbit)animals[i]).barkRabbit();
			}
		}
		System.out.println("개는 : "+dogCount);
		System.out.println("고양이는 : "+catCount);
		System.out.println("토끼는  : "+rabbitCount);
		
		//동적바인딩
		for(int i=0;i<animals.length;i++) {
			animals[i].bark();		// Dog클래스에서 bark()오버라이딩 시 Dog.bark() 실행(animals[i]=Dog객체일 경우)
									// Cat클래스에서 bark()오버라이딩 시 Cat.bark() 실행(animals[i]=Cat객체일 경우)
									// 자식 클래스에 오버라이딩이 없다면 기존 부모 클래스의 메서드 실행
									// 형변환 할 필요가 없다 -> 동적바인딩
		}
		
	}
}
