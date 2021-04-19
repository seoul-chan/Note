package com.semi.baseball;

import java.util.Scanner;

public class BaseballGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] random= new String[4];
		
		//중복 X
		for(int i=0;i<4;i++) {
			random[i]=String.valueOf((int)(Math.random()*9+1));
			for(int j=0;j<i;j++) {
				if(random[i].equals(random[j])) i--;
			}
			System.out.print(random[i]+" ");
		}

		while(true) {
			int strike=0,ball=0;
			
			System.out.println("==== 숫자 야구게임 ====");	//사용자 입력
			System.out.print("숫자를 입력해주세요(4자리) : ");
			String[] input = sc.next().split("");
			
			//스트라이크
			for(int i=0;i<4;i++) {
				if(input[i].equals(random[i])) {
					strike++;
					input[i]="0";
				}
			}
			
			//볼
			for(int i=0;i<4;i++) {
				if(random[i].contains(input[i])) {
					ball++;
				}
			}
			
			System.out.println("strike : "+strike+", ball : "+ball+"\n");
			if(strike==4) break;
		}
	}
}
