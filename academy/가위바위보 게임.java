package com.semi.rsp_game;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean b;
		System.out.println("===== 가위 바위 보 게임 ===== ");
		
		do {	
			System.out.println("가위, 바위, 보 중 하나를 입력하세요 : ");
			String input = sc.next();
			
			int computer = (int)(Math.random()*3+1); // 1:가위, 2:바위, 3:보; 
			b=false;
			
			switch(input) {
				case "가위" : {
					if(computer==1) {
						System.out.println("비겼습니다."); 
						b=true; 
					}
					else if(computer==2) System.out.println("졌습니다.");
					else System.out.println("이겼습니다."); break;
				}
				case "바위" : {
					if(computer==1) System.out.println("이겼습니다.");
					else if(computer==2) {
						System.out.println("비겼습니다.");
						b=true;
					}
					else System.out.println("졌습니다."); break;
				}
				case "보" : {
					if(computer==1) System.out.println("졌습니다.");
					else if(computer==2) System.out.println("이겼습니다.");
					else {
						System.out.println("비겼습니다."); 
						b=true;
						break;
					}
				}
				default : {
					System.out.println("잘못 입력하였습니다.");
					System.out.println("다시 입력해주세요.");
					b=true;
				}
			}
			
			if(computer==1) System.out.println("컴퓨터 : 가위" +  " 나 : " + input);
			if(computer==2) System.out.println("컴퓨터 : 바위" +  " 나 : " + input);
			if(computer==3) System.out.println("컴퓨터 : 보" +  " 나 : " + input);
		
		} while(b);
	}
}