package com.kh.practice.token.view.TokenMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.token.controller.TokenController;

public class TokenMenu {
	private Scanner sc = new Scanner(System.in);
	private TokenController tc = new TokenController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("1.지정 문자열");
			System.out.println("2.입력 문자열");
			System.out.println("3.프로그램 끝내기");
			System.out.print("입력 : ");

			try {		
				switch(sc.nextInt()) {
				case 1 : tokenMenu(); break;
				case 2 : inputMenu(); break;
				case 3 : System.out.println("프로그램을 종료합니다."); return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}	
	}
	
	public void tokenMenu() {
		String str = "J a v a P r o g r a m";
		String aferStr = tc.afterToken(str);
		System.out.println("토큰 처리 전 글자 : "+str);
		System.out.println("토큰 처리 전 개수 : " + str.length());
		System.out.println("토큰 처리 후 문자 : "+aferStr);
		System.out.println("토큰 처리 후 개수 : "+aferStr.length());
	}
	
	public void inputMenu() {
		System.out.print("문자열을 입력하세요 : ");
		String firstUpper = tc.firstCap(sc.next());  
		System.out.println("첫 글자 대문자 : " + firstUpper);
		System.out.println("찾을 문자를 하나 입력하세요 : ");
		char input = sc.next().charAt(0);
		System.out.println(input+" 문자가 들어간 개수 : "+tc.findChar(firstUpper, input));	
	}
}
