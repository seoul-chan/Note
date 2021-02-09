package com.kh.hw.memberview;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {	}
	
	public void maintMenu() {
		
		while(true) {
			System.out.println();
			System.out.println("최대 등록 가능한 회원 수는 "+mc.SIZE+"명 입니다.");
			System.out.println("현재 등록된 회원 수는 "+mc.existMemberNum()+"명 입니다.");
			
			System.out.println((mc.existMemberNum()<mc.SIZE)?"1. 새 회원 등록":"회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			
			int cho = sc.nextInt();
			if(mc.existMemberNum()>=mc.SIZE&&cho==1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			switch(cho) {
				case 1 : insertMember(); break;
				case 2 : searchMember(); break;
				case 3 : updateMember(); break;
				case 4 : deleteMember(); break;
				case 5 : printAll(); break;
				case 9 : System.out.println("프로그램을 종료합니다."); return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}				
	}
	
	public void insertMember() {
		String id;			// 개선하기##############
		while(true) {
			System.out.print("아이디 : ");
			id = sc.next();
			if(mc.checkId(id)) break;
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
		}		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		char gender;		// 개선하기##############
		while(true) {
			System.out.print("성별(M/F) : ");
			gender = sc.next().charAt(0);
			if(gender=='m'||gender=='M'||gender=='f'||gender=='F') break;
			System.out.println("성별을 다시 입력하세요.");
		}
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		mc.insertMember(id, name, password, email, gender, age);
	}
	
	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		int cho = sc.nextInt();
		switch(cho) {
			case 1 : searchId(); break;
			case 2 : searchName(); break;
			case 3 : searchEmail(); break;
			case 9 : maintMenu(); break;
			default : System.out.println("잘못 입력하셨습니다."); maintMenu();
		}
	}
	
	public void searchId() {
		System.out.println("검색할 아이디 : ");
		String id = sc.next();
		String search = mc.searchId(id);
		if(search.equals("")) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(search);
		}
	}
	
	public void searchName() {
		System.out.println("검색할 이름 : ");
		String name = sc.next();
		Member[] search = mc.searchName(name);
		if(search==null) {	//equals와 무슨 차이???
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			
			for(int i=0;i<search.length;i++) {
				if(search[i]!=null)
				System.out.println(search[i]);
			}
		}
	}
	
	public void searchEmail() {
		
	}
	
	public void updateMember() {
		
	}
	
	public void updatePassword() {
		
	}
	
	public void updateName() {
		
	}
	
	public void updateEmail() {
		
	}
	
	public void deleteMember() {
		
	}
	
	public void deleteOne() {
		
	}
	
	public void deleteAll() {
		
	}
	
	public void printAll() {
		System.out.println("==== 출력 결과 =====");
		Member[] m = mc.printAll();
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null)
			System.out.println(m[i].inform());
		}
			
	}
}
