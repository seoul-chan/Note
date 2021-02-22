package com.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.common.Car;

public class MapController {
	public static void main(String[] args) {
		/*
		 * Map
		 * Map은 쌍으로 이루어져 있는 구조 -> key : value
		 * key는 하나의 index로 보며 중복 값을 가질 수 없지만 value는 중복값을 가질 수 있다.
		 * key, value type -> 둘다 Object타입을 사용한다.
		 * 통상 key값은 String객체로 많이 사용한다.
		 * value는 객체를 사용한다.
		 * Map은 Collection을 상속받지 않았다.
		 * List, Set보다 메소드의 명칭이나 활용이 약간 다르다. 
		 */
		
		HashMap map = new HashMap();
		// 값넣기 -> put(key,value);
		map.put("가","A");
		map.put("나","B");
		map.put("다","C");
		System.out.println(map);
		
		//get(key) -> 저장된 값 가져오기
		//저장된 값은 key통해서 가져옴
		System.out.println(map.get("가"));
		System.out.println(map.get("나"));
		
		// key값은 중복이 불가능함.
		// 중복된 키 값으로 입력이 들어오면 이전 값은 덮어쓰기 됨
		map.put("가", "경찬");
		System.out.println(map.get("가")); //경찬
		
		map.remove("가");
		System.out.println(map);
		System.out.println(map.get("가")); //null
		
		
		/*
		 * map에 있는 데이터 전체를 순회하는 2가지 방법
		 * 1. key값을 통째로 가져와 key로 접근하는 방법
		 * keySet() -> map의 key를 Set방식으로 반환하는 메소드
		 * 
		 * 2. key,value 모두 가져와 접근하는 방법
		 * key, value 모두 저장하는 클래스를 이용함 -> Map.Entry 클래스
		 * */

		// 방법 1.
		Set keys=map.keySet(); //key들을 반환함.
		Iterator it = keys.iterator();
		
		while(it.hasNext()) {
			Object key = it.next(); //key값
//			String key = (String)it.next();  형변환을 사용해서도 할 수 있다.
			System.out.println(map.get(key));
		}
		
		
		// 방법 2. 
		Set entrySets = map.entrySet();
		Iterator entryIt=entrySets.iterator();
		while(entryIt.hasNext()) {
			Map.Entry en = (Map.Entry)entryIt.next();
			System.out.println(en.getKey()+" : "+en.getValue());
		}
		
		//isEmpty() - 데이터가 비어 있는지 확인
		System.out.println(map.isEmpty());
		
		//key, value가 포함되어 있는지 확인
		System.out.println(map.containsKey("나")); //객체가 들어가 있는 경우 equals, hashcode 오버라이딩 필수
		System.out.println(map.containsValue("A"));
		
		//데이터의 갯수를 확인
		System.out.println(map.size());

		//데이터 전체 지우기
		map.clear();
		
		/*
		 * map을 생성해서 key는 String(숫자), value Car객체
		 * 1 : 모닝 흰색 5000 4
		 * 2 : 그렌저 검은색 8000 4
		 * 3 : 카니발 회색 6000 5
		 * 4 : 테슬라 빨강 1억 3천 5
		 */
		
		//1. 전체 데이터를 출력하기 (차명, 색상 가격)
		//2. 가격이 7천만원 이상인 차만 출력 (차명, 가격, 인원수)
		HashMap cars = new HashMap();
		cars.put(1, new Car("모닝","흰색",5000,4));
		cars.put(2, new Car("그랜저","검은색",8000,4));
		cars.put(3, new Car("카니발","회색",6000,5));
		cars.put(4, new Car("테슬라","빨강",13000,5));
		
		System.out.println(cars);
		
		//방법 1
		Set carKey = cars.keySet();
		Iterator carIt = carKey.iterator();
		
		while(carIt.hasNext()) {
			Car cc = (Car)cars.get(carIt.next());
			if(cc.getPrice()>=7000)
				System.out.println(cc.getName()+" "+cc.getPrice()+" "+cc.getPerson());
		}
		
		//방법 2		
		Set entryCar=cars.entrySet();
		Iterator entryit = entryCar.iterator();
		
		while(entryit.hasNext()) {
			Map.Entry entry = (Map.Entry)entryit.next();
			Car c = (Car)entry.getValue();
			
			if(c.getPrice()>7000)
				System.out.println(c.getName()+" "+c.getPrice()+" "+c.getPerson());
			
		}	
	}
}
