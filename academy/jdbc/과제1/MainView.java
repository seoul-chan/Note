package com.home.view;

import java.util.List;
import java.util.Scanner;

import com.home.controller.BoardController;
import com.home.controller.MemberController;
import com.home.model.vo.Board;
import com.home.model.vo.Member;

public class MainView {

	private MemberController mc;
	private BoardController bc=new BoardController();
	public void mainMenu(MemberController mc) {
		this.mc=mc;
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("==== 메인 메뉴 ====");
			System.out.println("1. 회원관리");
			System.out.println("2. 게시판 관리");
			System.out.println("3. 프로그램 종료");
			
			switch(sc.nextInt()) {
				case 1 : mc.memberTable(); break;
				case 2 : bc.board(this); break;
				case 3 : System.out.println("프로그램을 종료합니다."); return;
			}
		}
	}
	
	public void memberTable() {
		Scanner sc=new Scanner(System.in);
		
		while(true){
			System.out.println("==== 회원관리 메뉴 ====");
			System.out.println("1. 전체회원조회");
			System.out.println("2. 회원 아이디로 조회");
			System.out.println("3. 회원 이름으로 조회");
			System.out.println("4. 회원가입");
			System.out.println("5. 회원정보수정(주소,전화번호,이메일)");
			System.out.println("6. 회원탈퇴");
			System.out.println("7. 메인메뉴로");
			System.out.print("입력 : ");
			
			switch(sc.nextInt()) {
				case 1 : mc.mSearchAll(); break;
				case 2 : mc.mSearchId(); break;
				case 3 : mc.mSearchName(); break;
				case 4 : mc.mInsertMember(); break;
				case 5 : mc.mUpdateMember(); break;
				case 6 : mc.mDeleteMember(); break;
				case 7 : return;
			}
		}
	}
	
	public void mPrintAll(List<Member> list) {
		for(Member m : list)
			System.out.println(m);		
	}
	
	public void bPrintAll(List<Board> list) {
		for(Board b : list)
			System.out.println(b);		
	}
	
	public void PrintMsg(String msg) {
		System.out.println("===================");
		System.out.println(msg);
		System.out.println("===================");
		
	}
	
	public String mSearchId() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 아이디 조회 ====");
		System.out.print("조회할 아이디를 입력하세요 : ");
		return sc.next();
	}
	
	public String mSearchName() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 이름 조회 ====");
		System.out.print("조회할 이름을 입력하세요 : ");
		return sc.next();
	}
	
	public Member mInsertMember() {
		Scanner sc=new Scanner(System.in);
		Member m=new Member();
		System.out.println("==== 회원가입 ====");
		System.out.print("아이디 : ");
		m.setId(sc.next());
		System.out.print("비밀번호 : ");
		m.setPwd(sc.next());
		System.out.print("이름 : ");
		m.setName(sc.next());
		System.out.print("이메일 : ");
		m.setEmail(sc.next());
		System.out.print("주소 : ");
		m.setAddress(sc.next());
		System.out.print("핸드폰번호 : ");
		m.setPhone(sc.next());
		
		return m;
	}
	
	public Member mUpdateMember() {
		Scanner sc=new Scanner(System.in);
		Member m=new Member();
		
		System.out.println("==== 회원 정보 수정 ====");
		System.out.print("수정할 아이디 : ");
		m.setId(sc.next());
		System.out.print("주소 : ");
		m.setAddress(sc.next());
		System.out.print("전화번호 : ");
		m.setPhone(sc.next());
		System.out.print("이메일 : ");
		m.setEmail(sc.next());
		
		return m;
	}
	
	public String mDeleteMember() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 회원 탈퇴 ====");
		System.out.print("탈퇴할 회원의 아이디 입력 : ");
		return sc.next();
	}
	
	public void board() {
		Scanner sc=new Scanner(System.in);
		
		while(true){
			System.out.println("==== 게시판 메뉴 ====");
			System.out.println("1. 게시판 전체 검색");
			System.out.println("2. 게시물 등록");
			System.out.println("3. 작성자로 검색");
			System.out.println("4. 제목으로 검색");
			System.out.println("5. 게시물 수정(제목,내용)");
			System.out.println("6. 게시물 삭제");
			System.out.println("7. 메인메뉴로");
			System.out.print("입력 : ");
			
			switch(sc.nextInt()) {
				case 1 : bc.bSearchAll(); break;
				case 2 : bc.bInsertPost(); break;
				case 3 : bc.bSearchWriter(); break;
				case 4 : bc.bSearchTitle(); break;
				case 5 : bc.bUpdatePost(); break;
				case 6 : bc.bDeletePost(); break;
				case 7 : return;
			}
		}
	}
	
	public Board bInsertPost() {
		Scanner sc=new Scanner(System.in);
		Board b=new Board();
		
		System.out.println("==== 게시물 등록 ====");
		System.out.print("항목(공지,일반,비밀) : ");
		b.setDiv(sc.next());
		System.out.print("제목 : ");
		b.setTitle(sc.next());
		System.out.print("내용 : ");
		b.setContests(sc.next());
		System.out.print("작성자(회원번호) : ");
		b.setWriter(sc.nextInt());
		
		return b;
	}
	
	public String bSearchWriter() {
		System.out.println("==== 작성자로 검색 ====");
		Scanner sc=new Scanner(System.in);
		System.out.print("작성자(회원번호) : ");
		return sc.next();
	}
	
	public String bSearchTitle() {
		System.out.println("==== 제목으로 검색 ====");
		Scanner sc=new Scanner(System.in);
		System.out.print("제목 : ");
		return sc.next();
	}
	
	public Board bUpdatePost() {
		Scanner sc=new Scanner(System.in);
		Board b=new Board();
		
		System.out.println("==== 게시물 수정(제목,내용) ====");
		System.out.print("게시번호(idx) : ");
		b.setIdx(sc.nextInt());
		System.out.print("제목 : ");
		b.setTitle(sc.next());
		System.out.print("내용 : ");
		b.setContests(sc.next());
		
		return b;
	}
	
	public int bDeletePost() {
		System.out.println("==== 게시물 삭제 ====");
		Scanner sc=new Scanner(System.in);
		System.out.print("게시번호(idx) : ");
		return sc.nextInt();
	}
}
