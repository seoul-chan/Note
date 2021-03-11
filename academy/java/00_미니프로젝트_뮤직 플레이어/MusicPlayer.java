package music.play.list.view;

import java.util.ArrayList;
import java.util.Scanner;

import music.play.list.controller.MemberController;
import music.play.list.controller.MusicController;
import music.play.list.model.Member;

public class MusicPlayer {
	private Scanner sc = new Scanner(System.in);
	private MusicController muCon = new MusicController();
	private MemberController meCon = new MemberController();
	private boolean pass = false;	//현재 로그인상태 여부
	
	public void mainMenu(){
		meCon.loadMember();
		
		while(true) {
			System.out.println("\n====== Music Player ======");
			System.out.println("1. 로그인");
			System.out.println("2. 회원 가입");
			System.out.println("3. 음악 목록");
			System.out.println("9. 프로그램 종료");
			System.out.print("목록을 선택하세요 : ");
			
			int input = sc.nextInt();
			switch(input) {
				case 1 : login(); break;
				case 2 : signUp();break;
				case 3 : playList(); break;		
				case 9 : exit(); break;
				default : System.out.println("잘못 입력하였습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	public void loginMenu(){		
		while(true) {
			System.out.println("\n====== Music Player ======");
			System.out.println("1. 로그아웃");
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 음악 목록");
			System.out.println("7. 내 정보 확인");
			System.out.println("8. 회원 탈퇴");
			System.out.println("9. 프로그램 종료");
			System.out.print("목록을 선택하세요 : ");
			
			int input = sc.nextInt();
			
			switch(input) {
				case 1 : {
					logout(); 
					if(!pass) return;
					else break;
				}
				case 2 : updateMember(); break;
				case 3 : playList(); break;
				case 7 : myInfo(); break;
				case 8 : {
					signOut();
					if(!pass) return;
					else break;
				}
				case 9 : exit(); break;
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
			loginMenu();
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
		
		String id="";
		while(true) {
			
			System.out.print("아이디를 입력해 주세요 : ");
			id = sc.next();
			if(!meCon.dupliId(id)) break;
				else System.out.println("중복되는 아이디입니다. 다시 입력해주세요.");
		}
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
		meCon.saveMember();
		System.out.println("회원가입을 축하드립니다~!!");
	}
	
	public void myInfo() {
		Member m = meCon.myInfo();
		System.out.println("\n======= 내 정보 =======");
		System.out.println("이름 : "+m.getName());
		System.out.println("아이디 : "+m.getId());
		System.out.println("핸드폰 번호 : "+m.getPhone());
		System.out.println("주소 : "+m.getAddress());
		
	}
	
	public void updateMember() {
		Member mem = new Member();
		
		while(true) {
			System.out.println("\n==== 회원정보 수정 메뉴 ====");
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
			meCon.updateMember(mem);
			
			}
	}
	
	public void playList() {
		String[] fileList = muCon.musicList();
		
		while(true) {
			System.out.println("\n===== 재생 목록 =====");
			for(int i=0;i<fileList.length;i++) {
				System.out.println(i+1+". "+fileList[i].substring(0, fileList[i].indexOf(".")));
			}			
			
			System.out.println("===== 플레이 메뉴 =====");
			System.out.println("6. 이전 곡");
			System.out.println("7. 다음 곡");
			System.out.println("8. 노래 정지");
			System.out.println("9. 이전 메뉴");
			System.out.print("재생하려는 음악 파일을 선택하세요 : ");
			
			int input = sc.nextInt();
			
			switch(input) {
				case 6 : muCon.priviusPlay();break;
				case 7 : muCon.nextPlay();break;
				case 8 : muCon.stop();break;
				case 9 : {
					System.out.println("이전 메뉴로 돌아갑니다.");
					return;
				}
				default : {
					if(pass) muCon.play(input);
					else System.out.println("로그인이 필요한 서비스입니다.");
				}
			}
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
	
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		meCon.saveMember();
		System.exit(0);
	}
}
