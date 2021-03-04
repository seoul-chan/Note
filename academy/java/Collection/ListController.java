package com.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.common.FoodCalAsc;
import com.common.FoodCalDesc;
import com.common.FoodNameAsc;
import com.common.FoodNameDesc;
import com.common.IntegerOrderAsc;
import com.common.IntegerOrderDesc;
import com.common.TestLambda;
import com.model.vo.Food;




public class ListController {
	public static void main(String[] args) {
		/*
		 * List, Set은 인터페이스이기에 직접 사용은 불가하다.
		 * 
		 * ArrayList클래스 이용하기
		 * ArrayList 배열과 동일한 저장방식으로 가지며, 배열의 단점을 보완한 자료구조형태
		 * ArrayList는 클래스로 생성해서 이용을 함.
		 * 클래스 생성된 객체의 메소드를 이용해서 관리름 함(수정, 추가, 삭제, 정렬...)
		 * ArrayList는 List인터페이스, Collection인터페이스를 구현했기에 List 변수, Collection변수에 대입될 수 있다.
		 * 기본적으로 list객체를 10개 보관할 수 있는 공간이 생성 -> 배열구조 인덱스에 의해 관리됨
		 * 배열과 저장하는 구조는 같다(인덱스 형식). 그러나 공간의 제약이 없으며 순서가 있다.
		*/
		
		
		ArrayList list = new ArrayList(); //10개 공간확보
		ArrayList<Integer> list2 = new ArrayList<Integer>(20); //20개 공간확보
		List l = new ArrayList();
		Collection c = new ArrayList();
		
		
		//*** add()를 이용해서 ArrayList에 객체저장하기
		list.add(true); //인자로 오브젝트 객체를 받음, 랩퍼클래스로 인해 자동으로 오토박싱
		list.add(19);
		list.add("김경찬");
		list.add(new Date());
		System.out.println(list);
		System.out.println(list.size());
		
		ArrayList foods=new ArrayList();
		foods.add(new Food("순대",7000,"국밥",500,null));
		foods.add(new Food("감자전",1000,"전",800,new Date(new GregorianCalendar(2021,02,20).getTimeInMillis())));
		foods.add(new Food("계란초밥",800,"초밥",200,null));
		
		System.out.println(foods);
		
		
		
		// ***get()메소드 및 index값을 기준으로 가져옴.
		Food f = (Food)foods.get(0); //저장 시 Object타입으로 저장되기에 형변환을 해주어야 한다.
		System.out.println(f.getName()+" "+f.getPrice());
		System.out.println(((Food)foods.get(1)).getName()+ " "+((Food)foods.get(1)).getPrice());
		
		//foods 출력 1
		for(int i=0;i<foods.size();i++) {
			Food temp = (Food)foods.get(i);
			System.out.println(temp.getName()+" "+temp.getPrice());
		}
		//foods 출력 2		
		for(Object f1 : foods) {
			Food temp = (Food)f1;
			System.out.println(temp.getName()+" "+temp.getPrice());
		}
		//500칼로리 이상 음식의 비용 합계
		int money=0;
		for(Object f1 : foods) {
			Food temp = (Food)f1;
			if(temp.getCalorie()>=500) {
				System.out.println(temp);
				money+=temp.getPrice();
			}
		}
		System.out.println("500칼로리 이상 음식의 비용 합계 : "+money);

		
		
		// ***remove() 및 인덱스를 이용해서 데이터 삭제
//		foods.remove(1);
//		foods.remove(1);
		foods.remove(new Food("계란초밥",800,"초밥",200,null));
		System.out.println(foods);
		
		
		
		// ***set()메소드를 이용하여 값 수정하기
		foods.set(1, new Food("라면",1200,"면",480,null));
		System.out.println(foods);
		
		
		
		// ***add(index, 값) 원하는 위치에 값 추가하기
		foods.add(0, new Food("피자",28000,"빵",1368,null));
		System.out.println(foods);
		
		
		
		// ***clear() 리스트 전체 삭제
		System.out.println("삭제 전 : "+list);
		list.clear();
		System.out.println("삭제 후 : "+list);
		
		
		
		// ***추가 유용한 메서드
		//contain() - 리스트에 값이 있는지 여부 확인
		//동일한 객체가 있는지 확인이기에 equals()메소드가 오버라이딩 되어 있어야한다.
			if(foods.contains(new Food("라면",1200,"면",480,null))) 
				System.out.println("있는 음식입니다.");
			
			if(!foods.contains(new Food("라면",1200,"면",480,null)))
				foods.add(new Food("라면",1200,"면",480,null));
			
		
		//isEmpty() - 리스트에 값이 비어있는지 여부 확인	
		System.out.println(foods.isEmpty());
		System.out.println(list.isEmpty());
		
		if(!foods.isEmpty()) { // foods.size()==0와 같은 의미
			for(Object t : foods) {
				System.out.println(t);
			}
		}
			
			
		//indexOf(객체) : 매개변수와 일치하는 값의 인덱스번화 반환
		System.out.println(foods.indexOf(new Food("라면",1200,"면",480,null)));
		
		
		//toArray() : list저장된 객체를 Objects배열로 반환해주는 메소드
		Object[] objFood=foods.toArray();
		for(int i=0;i<objFood.length;i++)
			System.out.println(objFood[i]);
		
		
		//list는 중복데이터도 저장이 가능함
		foods.add(new Food("탕수육",2500,"요리",1300,null));
		foods.add(new Food("버블티",2000,"차",100,null));
		foods.add(new Food("투움바파스타",3400,"면",9500,null));
		foods.add(new Food("햄버거",6700,"빵",700,null));
		foods.add(new Food("마라탕",9000,"면",780,null));
		
		for(int i=0;i<foods.size();i++) {
			System.out.println(foods.get(i));
		}
		
		
		//리스트는 순서가 있다. 즉, 정렬이 가능하다
		ArrayList numbers = new ArrayList();
		for(int i=0;i<10;i++) {
			numbers.add((int)(Math.random()*10));
		}
		System.out.println(numbers);
//		Collections.sort(numbers); //오름차순 정렬
		Collections.sort(numbers,new IntegerOrderAsc()); //오름차순 정렬
		System.out.println(numbers);
		
		Collections.sort(numbers,new IntegerOrderDesc()); //내림차순 정렬
		System.out.println(numbers);
		
		
		
		//foods에 있는 값을 조건에 따라 정렬해보자.
		//1. 칼로리를 기준으로 오름차순 정렬
		for(Object f1 : foods)
			System.out.println(f1);
		
		Collections.sort(foods,new FoodCalAsc());
		System.out.println("===================오름차순 정렬후(Calorie) ===================");
		for(Object f1 : foods)
			System.out.println(f1);
		
		System.out.println("===================내림차순 정렬후(Calorie) ===================");
		Collections.sort(foods,new FoodCalDesc());
		for(Object f1 : foods)
			System.out.println(f1);
		
		
		//2. 오름차순 정렬하기 음식이름으로 정렬하기
		/*
		 * 오름차순 정렬하기
		 * 스트링 객체에서 문자열을 비교해주는 메소드를 만들어놓음
		 * compareTo() -> str1.compareTo(str2) -> str1 str2 비교, return -, +, 0
		 */
		Collections.sort(foods,new FoodNameAsc());
		System.out.println("===================오름차순 정렬후(Name) ===================");
		for(Object f1 : foods)
			System.out.println(f1);
		
		foods.sort(new FoodNameDesc());
		System.out.println("===================내림차순 정렬후(Name) ===================");
		for(Object f1 : foods)
			System.out.println(f1);
		
		
		// 익명클래스를 이용하여 정렬 할 수도 있다.
		Collections.sort(foods,new Comparator<Food>() {	
			@Override
			public int compare(Food f1, Food f2) {
				return f1.getPrice()-f2.getPrice(); //클래스 파일 생성 없이 익명클래스로 사용 가능
			}
		});

		System.out.println();
		for(Object f1 : foods) {
			System.out.println(f1);
		}
		
		
		
		/* 매개변수와 로직만 안다면 클래스 이름, 메소드 이름이 필요가 없다 -> 람다식 등장!!
		 * 람다는 @FunctionalInterface다.(추상메소드가 한개만 선언된 인터페이스)
		 * lambda 사용 법 : (매개변수, .. , ...)  -> { 로직 작성 (+return)}
		 * 람다를 사용하기 위해 기본적으로 Interface에서 구현해야 하는 메소드 구조를 알아야한다. 
		 */

		//int compare(Object o1, Object o2)부분을 람다식으로 사용
		Collections.sort(foods,(Object o1, Object o2) -> {
			return ((Food)o1).getCategory().compareTo(((Food)o2).getCategory());
		});
		
		TestLambda testfilter=(Food temp) -> temp.getPrice()>20000;
		
		List result = filter(foods, (Food temp) -> temp.getPrice()>8000);	//가격이 8천원 이상인 객체 출력
		
		System.out.println("========== 람다 =============");
		result = filter(foods,(Food temp) -> temp.getCategory().contains("빵"));	//카테고리가 빵인 객체 출력
		for(Object o : result) {
			System.out.println(o);
		}
		
	}
	
	public static List filter(List list, TestLambda filter) {	//TestLambda filter자리에는 람다를 구현한 식이 와야한다??
		List result = new ArrayList();
		for(Object o : list) {
			if(filter.test((Food)o)) {
				result.add(o);
			}
		}
		return result;
	}
	
}
