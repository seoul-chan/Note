package com.kh.pratice.charCheck.view;

import java.util.Scanner;

import com.kh.pratice.charCheck.controller.CharacterController;
import com.kh.pratice.charCheck.exception.CharCheckException;

public class CharacterMenu {
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("영문자 갯수를 확인 할 문자열을 입력해주세요 : " );
			String input = sc.nextLine();
			int count = new CharacterController().countAlpha(input);
			System.out.println("'"+input+"'에 포함된 영문자 개수 : "+count);
			
		} catch (CharCheckException e) {
			e.printStackTrace();
		}
	}
}
