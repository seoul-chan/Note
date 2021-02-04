package com.member.model.view;

import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MainView {
	public void mainMenu(MemberController memc) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== 회원관리 프로그램 ====");
			System.out.println("1. 전체회원 조회");
			System.out.println("2. 회원 등록");
			System.out.println("3. 아이디로 회원 조회");
			System.out.println("4. 이름으로 회원 조회");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 정보 제거");
			System.out.println("0. 프로그램 종료");
			
			int cho = sc.nextInt();
			switch(cho) {
				case 1 : memc.serchAll(); break;
				case 2 : memc.insertMember(); break;
				case 3 : memc.serchId(); break;
				case 4 : memc.serchName(); break;
				case 5 : memc.updateMember(); break;
				case 6 : memc.removeMember(); break;
				case 0 : return;
			}
		}
	}
	
	public void memberList(String msg) {
		System.out.println("\n============================================");
		System.out.println("회원번호\t이름\t나이\t성별\t주소\t아이디\t패스워드");
		System.out.print(msg);
		System.out.println("\n============================================\n");
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
	
	public Member updateMember() {
		Scanner sc = new Scanner(System.in);
		Member mem = new Member();
		
		System.out.println("==== 회원정보 수정 메뉴 ====");
		System.out.print("수정을 원하는 회원의 이름을 입력하세요 : ");
		mem.setName(sc.next());
		
		while(true) {
		System.out.println("수정을 원하는 항목을 입력하세요. ");
		System.out.println("1. 나이");
		System.out.println("2. 성별");
		System.out.println("3. 주소");
		System.out.println("4. 아이디");
		System.out.println("5. 패스워드");
		System.out.println("0. 수정 종료");
		int cho = sc.nextInt();
		
			switch(cho) {
				case 1 :System.out.print("나이을 입력하세요 : ");
						mem.setAge(sc.nextInt()); break;
				case 2 :System.out.print("성별을 입력하세요 : ");
						mem.setGender(sc.next().charAt(0)); break;
				case 3 :System.out.print("주소를 입력하세요 : ");
						mem.setAddress(sc.next()); break; 
				case 4 :System.out.print("아이디를 입력하세요 : ");
						mem.setId(sc.next());break; 
				case 5 :System.out.print("비밀번호를 입력하세요 : ");
						mem.setPw(sc.nextInt());break;
				case 0 : return mem;
			}
		}

	}
	
	public Member removeMember() {
		Scanner sc = new Scanner(System.in);
		Member mem = new Member();
		
		System.out.println("==== 회원정보 제거 메뉴 ====");
		System.out.print("회원번호를 입력하세요 : ");
		mem.setMemberNo(sc.nextInt());
		System.out.print("이름을 입력하세요 : ");
		mem.setName(sc.next());
		
//		System.out.print("나이을 입력하세요 : ");
//		mem.setAge(sc.nextInt());
//		System.out.print("성별을 입력하세요 : ");
//		mem.setGender(sc.next().charAt(0));
//		System.out.print("주소를 입력하세요 : ");
//		mem.setAddress(sc.next());
//		System.out.print("아이디를 입력하세요 : ");
//		mem.setId(sc.next());
//		System.out.print("비밀번호를 입력하세요 : ");
//		mem.setPw(sc.nextInt());
		
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
