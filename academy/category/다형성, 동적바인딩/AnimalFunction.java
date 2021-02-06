package com.poly.controller;

import com.poly.model.vo.Animal;
import com.poly.model.vo.Cat;
import com.poly.model.vo.Dog;
import com.poly.model.vo.Mouse;
import com.poly.model.vo.Rabbit;

public class AnimalFunction {
//	public void bark(Dog d) {
//		d.barkDog();
//	}
//	public void bark(Cat c) {
//		c.barkCat();
//	}
//	public void bark(Rabbit r) {
//		r.barkRabbit();
//	}
//	public void bark(Mouse m) {
//		m.barkMouse();
//	}
	public void bark(Animal a) {
		//a만약에 쥐면 쥐로 형변환 -> barkMouse();
		//a만약에 개면 개로 형변환 -> barkDog();
		//instanceof예약어가 있음
		// 변수명 instanceof 클래스명 -> 변수를 클래스로 변환할 수 있니?
		// 반환형은 boolean
		if(a instanceof Dog) {
			((Dog)a).barkDog();
		} else if (a instanceof Cat) {
			((Cat)a).barkCat();
		} else if (a instanceof Rabbit) {
			((Rabbit)a).barkRabbit();
		} else if (a instanceof Mouse) {
			((Mouse)a).barkMouse();
		}
	}
}
