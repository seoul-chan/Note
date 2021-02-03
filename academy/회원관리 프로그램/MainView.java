package com.member.model.view;

import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MainView {
	public void mainMenu(MemberController mem) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== 회원관리 프로그램 ====");
			System.out.println("1. 전체회원 조회");
			System.out.println("2. 회원 등록");
			System.out.println("3. 아이디로 회원 조회");
			System.out.println("4. 이름으로 회원 조회");
			System.out.println("0. 프로그램 종료");
			
			int cho = sc.nextInt();
			switch(cho) {
				case 1 : mem.serchAll(); break;
				case 2 : mem.insertMember(); break;
				case 3 : mem.serchId(); break;
				case 4 : mem.serchName(); break;
				case 0 : return;
			}
		}
	}
	
	public void resultPrint(String msg) {
		System.out.println("\n============================================");
		System.out.print(msg);
		System.out.println("\n============================================\n");
	}
	
	public Member insetMember() {
		Scanner sc = new Scanner(System.in);
		Member mem = new Member();
		
		System.out.println("==== 회원 등록 메뉴 ====");
		System.out.print("이름을 입력하세요 : ");
		mem.setName(sc.next());
		System.out.print("나이을 입력하세요 : ");
		mem.setAge(sc.nextInt());
		System.out.print("성별을 입력하세요 : ");
		mem.setGender(sc.next().charAt(0));
		System.out.print("주소를 입력하세요 : ");
		mem.setAddress(sc.next());
		System.out.print("아이디를 입력하세요 : ");
		mem.setId(sc.next());
		System.out.print("비밀번호를 입력하세요 : ");
		mem.setPw(sc.nextInt());
		
		return mem;
	}
	public String serchId() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== ID 조회 메뉴 ====");
		System.out.print("아이디를 입력하세요 : ");
		return sc.next();
	}
	public String serchName() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== 이름 조회 메뉴 ====");
		System.out.print("이름을 입력하세요 : ");
		return sc.next();
	}
	
}
