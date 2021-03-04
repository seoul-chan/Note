package com.kh.practice.score.view;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.score.controller.ScoreController;

public class ScoreMenu {
	private Scanner sc = new Scanner(System.in);
	private ScoreController scr = new ScoreController();
	
	public void mainMenu() {
		while(true) {
			try {
				System.out.println("1. 성적 저장");
				System.out.println("2. 성적 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				
				switch(sc.nextInt()) {
					case 1 : saveScore(); break;
					case 2 : readScore(); break;
					case 9 : System.out.println("프로그램을 종료합니다.");return;
					default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public void saveScore() {
		int num=1;
		
		while(true) {	
			System.out.println(num+"번쨰 학생 정보 기록");
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("국어 점수 : ");
			int kor = sc.nextInt();
			System.out.print("영어 점수 : ");
			int eng = sc.nextInt();
			System.out.print("수학 점수 : ");
			int math = sc.nextInt();
			
			int sum = kor + eng + math;
			double avg = sum/3.0;
			
			scr.saveScore(name, kor, eng, math, sum, avg);
			num++;
			
			System.out.print("그만 입력하시려면 N또는 n입력, 계속 하시려면 아무 키나 입력하세요 : ");
			if(sc.next().toUpperCase().charAt(0)=='N') break;
		}
	}
	
	public void readScore() {
		int count=0;
		int sumAll=0;
		double avgAll=0.0;
		
		try(DataInputStream data = scr.readScore()) {
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t");
			while(true) {
				String name=data.readUTF();
				int kor = data.readInt();
				int eng = data.readInt();
				int math = data.readInt();
				int sum = data.readInt();
				double avg = data.readDouble();
				
				System.out.println(name+"\t"+kor+"\t"+eng+"\t"+	math+"\t"+sum+"\t"+avg);
				count++;
				sumAll+=sum;
				avgAll+=avg;
			}
		} catch (EOFException e) {
			System.out.println("읽은 횟수\t합계\t평균");
			System.out.println(count+"\t"+sumAll+"\t"+avgAll);				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
