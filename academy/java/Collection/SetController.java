package com.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.common.Car;

public class SetController {
	public static void main(String[] args) {
		/*
		 * Set : 객체들을 저장할 수 있는 구조로 순서가 없으며 중복 값을 가질 수 없다
		 * 순서가 없기에 데이터의 자리는 데이터 추가시에 자리가 랜덤으로 변경된다.(데이터 추가 전 최초만 랜덤 배치)  
		 * add() : 값을 저장하는 메서드, add()로 데이터가 추가되면 데이터의 위치는 다시 한번 변경된다.
		 * Collection을 상속받은 객체다.
		 */
		HashSet set = new HashSet();
		set.add("김경찬1");
		set.add("김경찬2");
		set.add("김경찬3");
		set.add("김경찬4");

		
		
		/*
		 * set저장소에 있는 값을 가져올때는 값을 지칭하는 id값이 없기에 전체를 순회해야한다.
		 * 순회하는 방법은 다음과 같다.
		 * 1. Iterator객체를 이용하는 방법
		 * 2. forEach를 이용하는 방법
		 * 3. set.interator()메서드를 이용하는 방법
		 */
		System.out.println(set);
		Iterator it = set.iterator();
		while(it.hasNext()) {
//			String name = it.next(); 에러, set반환형도 Object이기 때문에 형변환이 필요하다.
			String name = (String)it.next();
			System.out.println(name);
		}
		
		it=set.iterator();
		it.next();
		
		for(Object s : set) {
			System.out.println(s);
		}
		
		//set에 저장되어 있는 데이터의 갯수
		System.out.println(set.size());
		
		//set에 데이터가 비어있는지 확인
		System.out.println(set.isEmpty());
		
		set.add("김경찬(duplication)");
		set.add("김경찬(duplication)");
		set.add("김경찬(duplication)");
		set.add("김경찬(duplication)");
		System.out.println(set);  //Set은 중복 값을 저장하지 않기에 중복된 값은 하나만 저장된다.
		
		Iterator it2 = set.iterator(); 
		while(it2.hasNext()) 
			System.out.println(it2.next()); //중복 값은 저장되지 않아 하나만 출력된다.
		
		
		HashSet cars = new HashSet();
		cars.add(new Car("제네시스","검정",80000000,4));
		cars.add(new Car("티코","흰색",800000,2));
		cars.add(new Car("포르쉐","빨강",20000000,4));
		cars.add(new Car("마티즈","황금",400000,4));
		cars.add(new Car("벤틀리","회색",300000000,4));
		
		boolean result=cars.contains(new Car("벤틀리","회색",300000000,4));
		System.out.println(result); //equals, hash 오버라이딩 전 -> false
		
		//lotto쉽게 만들기
		HashSet lotto = new HashSet();
		while(lotto.size()!=6) {
			int num = (int)(Math.random()*44)+1;
			lotto.add(num);
		}
		for(Object o : lotto)
			System.out.println(o+" ");
		System.out.println();
		
		//Set 객체 제거 
		cars.remove(new Car("벤틀리","회색",300000000,4));
		
		/*
		 * ArrayList하고 호환성
		 * ArrayList에 중복 저장된 값을 HashSet을 이용하여 중복을 제거 후 다시 반환 받는다.
		 */
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(4);
		System.out.println("중복값 제거 전(ArrayList)"+list);
		
		HashSet temp = new HashSet(list);
		System.out.println("중복값 제거 중 (Hahset)"+temp);
		
		list=new ArrayList(temp);
		System.out.println("중복값 제거 후(ArrayList)"+list);
		
		
				
		// ***LinkedHashSet 순서가 있는 set
		LinkedHashSet lSet = new LinkedHashSet();
		lSet.add("김경찬");
		lSet.add("김경찬2");
		lSet.add("김경찬3");
		System.out.println("LinkedHashSet : "+lSet);
		
		
		
		// ***TreeSet() : 자동 오름차순 정렬
		TreeSet tSet = new TreeSet();
		tSet.add(1);
		tSet.add(5);
		tSet.add(2);
		tSet.add(3);
		tSet.add(9);
//		tSet.add(4);	//Car객체와 서로 다른 객체라서 주석해줘야 아래 Car객체 추가 시 에러가 발생하지 않는다. (비교할 수 없기에??)
		System.out.println("TreeSet : "+tSet);

		
		/*
		 * TresSet에 객체를 add시 에러가 발생한다.(ClassCastException)
		 * (문구 : Car cannot be cast to class java.lang.Comparable	<- Comparable을 구현해서 해결한다.)
		 * 
		 * 트리셋은 저장할 때 부터 비교를 하면서 저장을 한다. 따라서 equals가 구현이 되어있지 않은 객체는 삽입이 되지 않는다. 
		 * (기본 타입, 래퍼타입, String 등은 Comaparable이 구현이 되어있어서 비교 가능)
		 * 
		 * 저장하는 객체가 Comparable을 가지고 있던지, 저장하는 비교 기준인 Comparator를 구현한 클래스를 갖고 있어야 한다.
		 */ 
		
		//Car객체에 Comparable구현 및 그에 따른 compareTo 오버라이딩 후 add()진행
		tSet.add(new Car("제네시스","검정",80000000,4)); 
		tSet.add(new Car("티코","흰색",800000,2));
		tSet.add(new Car("포르쉐","빨강",20000000,4));
		tSet.add(new Car("마티즈","황금",400000,4));
		tSet.add(new Car("벤틀리","회색",300000000,4));
		System.out.println("TreeSet : "+tSet);
		
		Iterator it3 = tSet.descendingIterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		
		//tSet의 데이터 중 벤틀리를 찾아서 이름, 색상, 가격 출력하기.
		Iterator carIt = tSet.iterator();
		while(carIt.hasNext()) {
			Car c = (Car)carIt.next();
			if(c.getName().contains("벤틀리")) //equals()사용 가능
				System.out.println(c.getName()+" "+c.getColor()+" "+c.getPrice());
		}
		
		
		
		
		
		
		
	}
}
