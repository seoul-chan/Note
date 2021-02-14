package com.kh.practice.chap01_poly.model.view;

import java.util.Scanner;

import com.kh.practice.chap01_poly.model.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.*;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("성별을 입력하세요(M/F) : ");
		char gender = sc.next().charAt(0);
		
		Member mem = new Member(name,age,gender);
		lc.insertMember(mem);
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.println("메뉴 번호");
			
			int cho = sc.nextInt();		
			switch(cho) {
				case 1 : lc.myinfo(); break;
				case 2 : selectAll(); break;
				case 3 : searchBook(); break;
				case 4 : rentBook(); break;
				case 9 : return;
				default : System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}
	
	public void selectAll() {
		Book[] bList = lc.selectAll();
		
		for(int i=0;i<bList.length;i++)
			System.out.println(i+"번 도서 : "+bList[i]);
	}
	
	public void searchBook() {
		System.out.print("검색할 책 이름을 입력해주세요 : ");
		Book[] searchList = lc.searchBook(sc.next());
		
		for(int i=0;i<searchList.length;i++)
			System.out.println(i+"번 도서 : "+searchList[i]);
	}
	
	public void rentBook() {
		System.out.println("도서 목록 입니다.");
		selectAll();
		
		System.out.print("대여할 도서 번호를 선택 : ");
		int result = lc.rentBook(sc.nextInt());
		
		switch(result) {
			case 0 : System.out.println("성공적으로 대여되었습니다.");
			case 1 : System.out.println("나이 제한으로 대여 불가능입니다.");
			case 2 : System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이"
					+ "페이지에서 확인하세요");
		}
	}
	
}
