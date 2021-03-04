package com.kh.practice.list.music.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.music.model.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("****** 메인 메뉴 *****");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			try {
				switch(sc.nextInt()) {
				case 1: addList(); break;
				case 2: addAtZero(); break;
				case 3: printAll(); break;
				case 4: searchMusic(); break;
				case 5: removeMusic(); break;
				case 6: setMusic(); break;
				case 7: ascTitle(); break;
				case 8: descSinger(); break;
				case 9: System.out.println("종료"); return;
				default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				}
			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				sc.nextLine();
			}
		}				
	}
	
	public void addList() {
		System.out.println("\n****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.next();
		System.out.print("가수 명 : ");
		String singer = sc.next();
		
		Music music = new Music(title, singer);		
		System.out.println(mc.addList(music)==1?"추가 성공":"추가 실패");
	}
	
	public void addAtZero() {
		System.out.println("\n****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.next();
		System.out.print("가수 명 : ");
		String singer = sc.next();
		
		Music music = new Music(title, singer);		
		System.out.println(mc.addAtZero(music)==1?"추가 성공":"추가 실패");
	}
	
	public void printAll() {
		System.out.println("\n****** 전체 곡 목록 출력 ******");
		List<Music> list = mc.printAll();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	public void searchMusic() {
		System.out.println("\n****** 특정 곡 검색 ******");
		System.out.print("곡 명 : ");
		String title = sc.next();
		Music m = mc.searchMusic(title); 
		if(m!=null)
			System.out.println("검색한 곡은 "+m.getTitle()+", "+m.getSinger()+"입니다.");
		else
			System.out.println("검색한 곡이 없습니다.");		
	}
	
	public void removeMusic() {
		System.out.println("\n****** 특정 곡 삭제 ******");
		System.out.print("곡 명 : ");
		String title = sc.next();
		Music m = mc.removeMusic(title);
		if(m!=null)
			System.out.println(m.getTitle()+", "+m.getSinger()+"을 삭제 했습니다.");
		else
			System.out.println("삭제할 곡이 없습니다.");	
	}
	
	public void setMusic() {
		System.out.println("\n****** 특정 곡 정보 수정 ******");
		System.out.print("수정할 곡 명 : ");
		String title = sc.next();
		System.out.print("수정할 가수 명 : ");
		String singer = sc.next();
		
		Music m = mc.setMusic(title, singer);
		if(m!=null)
			System.out.println(m.getTitle()+", "+m.getSinger()+"의 값이 변경 되었습니다.");
		else
			System.out.println("수정할 곡이 없습니다.");	
	}
	
	public void ascTitle() {
		System.out.println(mc.ascTitle()==1?"정렬성공":"정렬 실패");
	}
	
	public void descSinger() {
		System.out.println(mc.descSinger()==1?"정렬성공":"정렬 실패");
	}
	
}
