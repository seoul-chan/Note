package com.kh.hw.memberview;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {	}
	
	public void maintMenu() {
//		mc.init(); //테스트 용 메서드
		
		while(true) {
			System.out.println();
			System.out.println("최대 등록 가능한 회원 수는 "+mc.SIZE+"명 입니다.");
			System.out.println("현재 등록된 회원 수는 "+mc.existMemberNum()+"명 입니다.");
			
			System.out.println((mc.existMemberNum()<mc.SIZE)?"1. 새 회원 등록":"회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모든 회원 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			
			int cho = sc.nextInt();
			
			//모든 회원이 등록된 경우 1번 입력 시
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
		String id;
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
		char gender;
		while(true) {
			System.out.print("성별(M/F) : ");
			gender = sc.next().toUpperCase().charAt(0);
			if(gender=='M'||gender=='F') break;
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
			case 9 : break;
			default : System.out.println("잘못 입력하셨습니다.");
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
			System.out.println("아이디\t이름\t패스워드\t이메일\t\t성별\t나이");
			System.out.println(search);
		}
	}
	
	public void searchName() {
		System.out.println("검색할 이름 : ");
		String name = sc.next();
		Member[] search = mc.searchName(name);
		if(search==null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println("아이디\t이름\t패스워드\t이메일\t\t성별\t나이");
			
			for(int i=0;i<search.length;i++) {
				if(search[i]!=null)
				System.out.println(search[i]);
			}
		}
	}
	
	public void searchEmail() {
		System.out.println("검색할 이메일 : ");
		String email = sc.next();
		Member[] search = mc.searchEmail(email);
		if(search==null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println("아이디\t이름\t패스워드\t이메일\t\t성별\t나이");
			
			for(int i=0;i<search.length;i++) {
				if(search[i]!=null)
				System.out.println(search[i]);
			}
		}
	}
	
	public void updateMember() {
		System.out.println("==== 멤버 정보 수정 ====");
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		int cho = sc.nextInt();
		switch(cho) {
			case 1 : updatePassword(); break;
			case 2 : updateName(); break;
			case 3 : updateEmail(); break;
			case 9 : break;
			default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void updatePassword() {
		System.out.println("==== 비밀번호 수정 ====");
		System.out.println("아이디를 입력해주세요 : ");
		String id = sc.next();
		System.out.println("수정할 비밀번호를 입력해주세요 : ");
		String password = sc.next();
		
		boolean flag = mc.updatePassword(id, password);
		System.out.println(flag?"수정이 성공적으로 되었습니다.":"존재하지 않는 아이디입니다.");
	}
	
	public void updateName() {
		System.out.println("==== 이름 수정 ====");
		System.out.println("아이디를 입력해주세요 : ");
		String id = sc.next();
		System.out.println("수정할 이름 입력해주세요 : ");
		String name = sc.next();
		
		boolean flag = mc.updateName(id, name);
		System.out.println(flag?"수정이 성공적으로 되었습니다.":"존재하지 않는 아이디입니다.");
	}
	
	public void updateEmail() {
		System.out.println("==== 이메일 수정 ====");
		System.out.println("아이디를 입력해주세요 : ");
		String id = sc.next();
		System.out.println("이메일을 입력해주세요 : ");
		String email = sc.next();
		
		boolean flag = mc.updateEmail(id, email);
		System.out.println(flag?"수정이 성공적으로 되었습니다.":"존재하지 않는 아이디입니다.");
	}
	
	public void deleteMember() {
		System.out.println("==== 회원 정보 삭제 ====");
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		
		int cho = sc.nextInt();
		switch(cho) {
			case 1 : deleteOne(); break;
			case 2 : deleteAll(); break;
			default :  System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void deleteOne() {
		System.out.println("==== 회원 정보 삭제 ====");
		System.out.println("삭제할 회원의 id를 입력해주세요 : ");
		String id = sc.next();
		System.out.print("정말 삭제 하시겠습니까?(Y/N) : ");
		String cho = sc.next();
		
		if(cho.equals("Y")||cho.equals("y")) {
			boolean flag = mc.delete(id);
			System.out.println(flag?"성공적으로 삭제하였습니다.":"존재하지 않는 아이디입니다.");
		}
	}
	
	public void deleteAll() {
		System.out.println("==== 모든 회원 정보 삭제 ====");
		System.out.print("모든 회원을 삭제 하시겠습니까?(Y/N) : ");
		String cho = sc.next();
		if(cho.equals("Y")||cho.equals("y")) {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
	}
	
	public void printAll() {
		System.out.println("==== 모든 회원 출력 =====");
		System.out.println("아이디\t이름\t패스워드\t이메일\t\t성별\t나이");
		Member[] mem = mc.printAll();
		
		if(mem==null) {
			System.out.println("저장된 회원이 없습니다.");
			return;
		}
		
		for(int i=0;i<mem.length;i++) {
			if(mem[i]!=null)
			System.out.println(mem[i].inform());
		}
			
	}
}
