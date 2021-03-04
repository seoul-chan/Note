package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 원 메뉴");
			System.out.println("2. 사각형 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int cho = sc.nextInt();
			
			switch(cho) {
				case 1 : circleMenu(); break;
				case 2 : rectangleMenu(); break;
				case 9 : return;
				default : System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
			}
		}	
	}
	
	public void circleMenu() {		
		System.out.println("==== 원 메뉴 ====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int cho = sc.nextInt();
		
		switch(cho) {
			case 1 : calcCircum(); break;
			case 2 : calcCircleArea(); break;
			case 9 : return;
			default : System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
		}
	}
	
	public void rectangleMenu() {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int cho = sc.nextInt();
		
		switch(cho) {
			case 1 : calcPerimeter(); break;
			case 2 : calcRectArea(); break;
			case 9 : return;
			default : System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
		}
	}
	
	// 원 둘레
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		
		String calc = cc.calcCircum(x, y, radius);
		System.out.println("원 둘레 : "+cc.printCircle()+" / "+calc);
	}
	
	//원 넓이
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		
		String calc = cc.calcArea(x, y, radius);
		System.out.println("원 넓이 : "+cc.printCircle()+" / "+calc);
	}
	
	// 사각형 둘레
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int heigh = sc.nextInt();
		System.out.print("너비 : ");
		int width = sc.nextInt();
		
		String calc = rc.calcPerimeter(x, y, heigh, width);
		System.out.println("사각형 둘레 : "+rc.printRectangle()+" / "+calc);
	}
	// 사각형 넓이
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int heigh = sc.nextInt();
		System.out.print("너비 : ");
		int width = sc.nextInt();
		
		String calc = rc.calcArea(x, y, heigh, width);
		System.out.println("사각형 둘레 : "+rc.printRectangle()+" / "+calc);
	}
}
