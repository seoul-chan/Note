package com.kh.practice.map.view;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("========== KH 사이트 ==========");
		while(true) {
			System.out.println("======**** 메인메뉴 ****=====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			
			try {
				switch(sc.nextInt()) {
				case 1 : joinMembership(); break;
				case 2 : login(); break;
				case 3 : sameName(); break;
				case 9 : System.out.println("프로그램 종료"); return;
				default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				}
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				sc.nextLine();
			}
		}
	}
	
	public void memberMenu() {
		while(true) {
			System.out.println("\n ****** 회원 메뉴 ******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 번호 선택 : ");
			try {
				switch(sc.nextInt()) {
					case 1 : changePassword(); break;
					case 2 : changeName(); break;
					case 3 : System.out.println("로그아웃 되었습니다."); return;
					default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				}
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				sc.nextLine();
			}
		}
	}
	
	public void joinMembership() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String password = sc.next();
			System.out.print("이름 : ");
			String name = sc.next();
			
			boolean flag = mc.joinMembership(id, new Member(password, name));
			if(flag) {
				System.out.println("성공적으로 회원가입을 완료하였습니다.");
				break;
			} else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}	
		}
	}
	
	public void login() {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		
		String name = mc.login(id, password);
		if(name.equals("")){
			System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
		} else {
			System.out.println(name+"님 환영합니다.");
			memberMenu();
		}
	}
	
	public void changePassword() {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String oldPw = sc.next();
		System.out.print("변경할 비밀번호 : ");
		String newPw = sc.next();
		
		boolean flag = mc.changePassword(id, oldPw, newPw);
		System.out.println(flag?"비밀번호 변경에 성공했습니다.":"비밀번호 변경에 실패했습니다.");
	}
	
	public void changeName() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String password = sc.next();
			
			String name = mc.login(id, password);
			
			if(name.equals("")) {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요.");
			} else {
				System.out.println("현재 저장되어 있는 이름 : "+name);
				
				System.out.print("변경할 이름 : ");
				mc.changeName(id, sc.next());
				System.out.println("이름 변경에 성공하였습니다.");
				break;
			}
		}
	}
	
	public void sameName() {
		System.out.print("이름 : ");
		String name = sc.next();
		
		Set set = mc.sameName(name).entrySet();
		Iterator<Member> it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println(e.getValue()+"-"+e.getKey());
		}
	}
}
