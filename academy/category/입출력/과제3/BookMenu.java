package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr = new Book[10];
	
	public BookMenu() {
		bc.makeFile();
		this.bArr=bc.fileRead();
	}
	
	public void mainMenu() {
		while(true) {
			try {
				System.out.println("1. 도서 추가 저장");
				System.out.println("2. 저장 도서 출력");
				System.out.println("9. 프로그램 끝내기");
				System.out.print("메뉴 번호 : ");
				int menu = sc.nextInt();
				
				switch(menu) {
					case 1 : fileSave(); break;
					case 2 : fileRead(); break;
					case 9 : System.out.println("프로그램 종료"); return;
					default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
				
			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				sc.nextLine();
			}
		}
	}
	
	public void fileSave() {
		sc.nextLine();
		System.out.print("도서 명 : ");
		String title = sc.nextLine();
		System.out.print("저자 명 : ");
		String author = sc.nextLine();
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		
		System.out.print("출판 날짜(yyyy-mm-dd) : ");
		String[] temp = sc.next().split("-");		
		Calendar date = Calendar.getInstance();
		date.set(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));
		
		System.out.print("할인율 : ");
		double discount  = sc.nextDouble();
		
		for(int i=0;i<bArr.length;i++)
			if(bArr[i]==null) {
				bArr[i] = new Book(title, author, price, date, discount);
				bc.fileSave(bArr);
				break;
			}
	}
	
	public void fileRead() {
		bArr=bc.fileRead();
		
		for(Book b : bArr)
			if(b!=null)
				System.out.println(b);
	}
}
