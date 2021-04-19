package com.semi.baseball;

import java.util.Scanner;

public class BaseballGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] random= new String[4];
		
		//중복 없이 랜덤 값 생성
		for(int i=0;i<4;i++) {
			random[i]=String.valueOf((int)(Math.random()*9+1));
			for(int j=0;j<i;j++) {
				if(random[i].equals(random[j])) i--;
			}
//			System.out.print(random[i]+" ");  주석 해제 시 컴퓨터 입력 값 확인
		}
		
		System.out.println("==== 숫자 야구게임 ====");

		while(true) {
			int strike=0,ball=0;
			System.out.print("숫자를 입력해주세요(4자리) : ");
			String[] input = sc.next().split("");	//사용자 입력

			boolean b =false;
			for(int i=0;i<4;i++) {	//중복 숫자 입력 확인
				for(int j=0;j<i;j++) {
					if(input[i].equals(input[j])) {
						b=true;
					}
				}
			}
			if(b) {
				System.out.println("중복 입력된 숫자가 있습니다.");
				System.out.println("다시 입력해 주세요.");
				continue;
			}
			
			//스트라이크
			for(int i=0;i<4;i++) {
				if(input[i].equals(random[i])) {
					strike++;
					input[i]="0";
				}
			}
			//볼
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(input[i].equals(random[j])) {
						ball++;
					}
				}
			}
			System.out.println("strike : "+strike+", ball : "+ball+"\n");
			if(strike==4) break;
		}
	}
}
