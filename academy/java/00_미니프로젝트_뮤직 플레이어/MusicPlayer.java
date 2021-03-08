package music.play.list.view;

import java.util.Scanner;

import music.play.list.controller.MemberController;
import music.play.list.controller.MusicController;
import music.play.list.model.Member;

public class MusicPlayer {
	Scanner sc = new Scanner(System.in);
	MusicController muCon = new MusicController();
	MemberController meCon = new MemberController();
	boolean pass = false;
	
	public void mainMenu(){
		meCon.loadMember();
		
		while(true) {
			System.out.println("\n====== Music Player ======");
			System.out.println(pass?"1. 로그아웃":"1. 로그인");
			System.out.print(pass?"2. 회원 정보 수정\n":"2. 회원 가입\n");
			System.out.println("3. 음악 목록");
			System.out.println("4. 회원 탈퇴");
			System.out.println("9. 프로그램 종료");
			System.out.print("목록을 선택하세요 : ");
			
			int input = sc.nextInt();
			
			switch(input) {
				case 1 :  {
					if(pass) logout();
					else login();					
					break;
				}
				case 2 :  {
					if(pass) updateMember();
					else signUp();
					break;
				}
				case 3 :  {
					if(pass) {
						playList(); 
						break;
					} else {
						System.out.println("로그인이 필요한 서비스 입니다.");
						System.out.println("로그인 후 이용해 주세요.");
						break;
					} //if-else		
				}//case 3
				case 4 :  signOut();break;
				case 9 : {
					System.out.println("프로그램을 종료합니다.");
					meCon.saveMember();
					System.exit(0);
				}
				default : System.out.println("잘못 입력하였습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	public void login() {
		System.out.println("\n====== Music Player ======");
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("Password : ");
		String password = sc.next();
		
		if(meCon.logIn(id, password)) {
			System.out.println("어서오세요.");
			pass = true;
		} else {
			System.out.println("아이디 또는 비밀번호가 일치 하지 않습니다.");
		}
	}
	
	public void logout() {
		System.out.println("로그 아웃을 하시겠습니까??(Y/N)");
		String out = sc.next();
		if(out.toUpperCase().equals("Y")) {
			pass = false;
			meCon.logOut();
			System.out.println("로그아웃 되었습니다.");
		}
			
	}
	
	public void signUp() {
		System.out.print("이름을 입력해 주세요 : ");
		String name = sc.next();
		
		System.out.print("아이디를 입력해 주세요 : ");	//ID 중복 확인 구현 필요
		String id = sc.next();
		
		String password="";
		while(true) {
			System.out.print("패스워드를 입력해 주세요 : ");
			String oldPw = sc.next();
			System.out.print("패스워드를 한번 더 입력해 주세요 : ");
			password = sc.next();
			if(oldPw.equals(password)) 
				break;
			else
				System.out.println("패스워드가 일치하지 않습니다. 다시 입력해주세요.");
		}
		System.out.print("핸드폰 번호를 입력해 주세요 : ");
		String phone = sc.next();
		System.out.print("주소를 입력해 주세요 : ");
		String address = sc.next();
		
		Member m = new Member(name, id, password, phone, address);
		meCon.signUp(m);
		System.out.println("회원가입을 축하드립니다~!!");
	}
	
	public void updateMember() {
		Member mem = new Member();
		
		System.out.println("==== 회원정보 수정 메뉴 ====");
		while(true) {
			System.out.println("수정을 원하는 항목을 입력하세요. ");
			System.out.println("1. 아이디");
			System.out.println("2. 비밀번호");
			System.out.println("3. 핸드폰번호");
			System.out.println("4. 주소");
			System.out.println("0. 수정 종료");
			int cho = sc.nextInt();
			
				switch(cho) {
					case 1 :System.out.print("아이디를 입력하세요 : ");
							mem.setId(sc.next());break;
					case 2 :System.out.print("비밀번호를 입력하세요 : ");
							mem.setPassword(sc.next());break;
					case 3 :System.out.print("핸드폰번호를 입력하세요 : ");
							mem.setPhone(sc.next());break;
					case 4 :System.out.print("주소를 입력하세요 : ");
							mem.setAddress(sc.next()); break; 
					case 0 : return;
				}
			}
	}
	
	public void playList() {		
		while(true) {				
			System.out.println("\n===== 재생 목록 =====");
			System.out.println("1. test");
			System.out.println("2. test2");
			System.out.println("3. test3");
			System.out.println("4. test4");
			System.out.println("5. SG Wannabe Brown Eyed Girls - Must Have Love");
			System.out.println("8. 노래 정지");
			System.out.println("9. 이전 메뉴");
			System.out.print("재생하려는 음악 파일을 선택하세요 : ");
			
			int input = sc.nextInt();
			if(input==9) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}
			muCon.play(input);
		}
	}
	
	public void signOut() {
		System.out.println("회원 탈퇴 메뉴 입니다.");
		System.out.println("탈퇴하시겠습니까.(Y/N)");
		String out = sc.next();
		
		if(out.toUpperCase().equals("Y")) {
			System.out.println("정말로 탈퇴하시겠습니까?!!(Y/N)");
			out = sc.next();
			if(out.toUpperCase().equals("Y")) {
				pass = false;
				System.out.println("회원 탈퇴가 완료 되었습니다.");
				System.out.println("이용해 주셔서 감사합니다.");
				meCon.signOut();
			}
		}
	}
}
