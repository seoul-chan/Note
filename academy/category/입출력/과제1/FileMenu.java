package com.kh.practice.file.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		while(true) {
			try {
				System.out.println("***** My Note *****");
				System.out.println("1. 노트 새로 만들기");
				System.out.println("2. 노트 열기");
				System.out.println("3. 노트 열어서 수정하기");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				
				switch(sc.nextInt()) {
					case 1 : fileSave(); break;
					case 2 : fileOpen(); break;
					case 3 : fileEdit(); break;
					case 9 : System.out.println("프로그램을 종료합니다."); return;
					default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				}
			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		System.out.println("파일에 저장할 내용을 입력하세요.");
		System.out.println("ex끝it라고 입력하면 종료됩니다.");
		System.out.print("내용 : ");
		
		sc.nextLine();
		while(true) {
			String input = sc.nextLine();
			if(input.equals("ex끝it")) break;
			
			sb.append(input+"\n");
		}
		
		while(true) {
			System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
			String fileName = sc.next();

			if(fc.checkName(fileName)) {
				System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n)");
				if(sc.next().equals("y")) {
					fc.fileSave(fileName, sb);
					break;
				}
					else continue;
			} else {
				fc.fileSave(fileName, sb);
				break;
			}
		}				
	}
	
	
	public void fileOpen() {
		System.out.print("열 파일 명 : ");
		String file = sc.next();
		System.out.println(fc.checkName(file)?fc.fileOpen(file):"없는 파일입니다.");		
	}
	
	
	public void fileEdit() {
		StringBuilder sb = new StringBuilder();
		
		System.out.print("수정할 파일 명 : ");
		String file = sc.next();
		if(fc.checkName(file)) {
			System.out.println("파일에 수정할 내용을 입력하세요.");
			System.out.println("ex끝it라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			
			sc.nextLine();
			while(true) {
				String input = sc.nextLine();
				if(input.equals("ex끝it")) break;
				
				sb.append(input+"\n");
			}
			
			fc.fileEdit(file, sb);
			
		} else {
			System.out.println("없는 파일입니다.");
		}
	}
}
