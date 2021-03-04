package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	
	public void mainMenu() {
		System.out.println("== Welcome KH Library ==");
		
		while(true) {
			System.out.println("\n****** 메인 메뉴 ******");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			
			try {
				switch(sc.nextInt()) {
				case 1 : insertBook(); break;
				case 2 : selectList(); break;
				case 3 : searchBook(); break;
				case 4 : deleteBook(); break;
				case 5 : ascBook(); break;
				case 9 : return;
				default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				}
			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				sc.nextLine();				
			}
		}
	}
	
	public void insertBook() {
		String title="";
		String author="";
		String category="";
		int price=0;
		
		try {
			System.out.println("\n=== 새 도서 추가 ===");
			System.out.print("도서명 입력 : ");
			sc.nextLine();
			title = sc.nextLine();
			System.out.print("저자명 입력 : ");
			author = sc.next();
			System.out.println("= 장르 =");

			
			int input=0;			
			while(true) {
				System.out.println("1.인문");
				System.out.println("2.자연과학");
				System.out.println("3.의료");
				System.out.println("4.기타");
				System.out.print("장르 입력 : ");
				
				switch(input=sc.nextInt()){
				case 1 : category = "인문"; break;
				case 2 : category = "자연과학"; break;
				case 3 : category = "의료"; break;
				case 4 : category = "기타"; break;
				default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				}
				if(input>=1&&input<=4) break;
			}
			System.out.print("가격 입력 : ");
			price = sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			sc.nextLine();	
			return;
		}
		
		Book book = new Book(title, author, category, price);
		bc.insertBook(book);	
	}
	
	public void selectList() {
		System.out.println("\n=== 도서 전체 조회 ===");
		ArrayList<Book> bookList = bc.selectList();
		
		if(bookList.size()==0) 
			System.out.println("존재하는 도서가 없습니다.");
		else 		
			for(int i=0;i<bookList.size();i++)
				System.out.println(bookList.get(i));		
	}
	
	public void searchBook() {
		System.out.println("\n=== 도서 검색 조회 ===");
		System.out.print("검색할 도서명 : ");
		sc.nextLine();
		String keyword = sc.nextLine();
		ArrayList<Book> searchList = bc.searchBook(keyword);
		
		if(searchList.size()==0) 
			System.out.println("존재하는 도서가 없습니다.");
		else 		
			for(int i=0;i<searchList.size();i++)
				System.out.println(searchList.get(i));		
	}
	
	public void deleteBook() {
		System.out.println("\n=== 도서 삭제 ===");
		System.out.print("삭제할 도서명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("삭제할 저자명 : ");
		String author = sc.next();
		
		Book remove = bc.deleteBook(title, author);
		System.out.println(remove!=null?"성공적으로 삭제되었습니다.":"삭제할 도서를 찾지 못했습니다.");		
	}
	
	public void ascBook() {
		System.out.println(bc.ascBook()==1?"정렬에 성공하였습니다.":"정렬에 실패하였습니다.");
	}
}
