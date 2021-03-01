package com.kh.practice.set.view;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		System.out.println("============= KH 추첨 프로그램 =============");
		
		while(true) {
			try {
				System.out.println("****** 메인 메뉴 ******");
				System.out.println("1. 추첨 대상 추가");
				System.out.println("2. 추첨 대상 삭제");
				System.out.println("3. 당첨 대상 확인");
				System.out.println("4. 정렬된 당첨 대상 확인");
				System.out.println("5. 당첨 대상 검색");
				System.out.println("9. 종료");
				System.out.print("메뉴 번호 선택 : ");
				
				switch(sc.nextInt()) {
					case 1 : insertObject(); break;
					case 2 : deleteObject(); break;
					case 3 : winObject(); break;
					case 4 : sortedWinObject(); break;
					case 5 : searchWinner(); break;
					case 9 : System.out.println("프로그램 종료"); return;
					default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				}	
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				sc.nextLine();
			}
		}
	}
	
	public void insertObject() {
		System.out.println("\n==== 추첨 대상 추가 ====");
		System.out.print("추첨할 추첨 대상 수를 입력하세요 : ");
		int count = sc.nextInt();
		for(int i=1;i<=count;i++) {
			while(true) {
				System.out.print("추점자 이름을 입력하세요"+"("+i+"번째) : ");
				String name = sc.next();
				System.out.print("추점자 핸드폰 번호를 입력하세요 : ");
				String phone = sc.next();
				
				boolean flag = lc.insertObject(new Lottery(name,phone));
				
				if(flag) {
					System.out.println("추가 완료되었습니다."); 
					break;
				} else {
					System.out.println("중복된 대상입니다. 다시 입력해주세요.");
				}				
			}//while
		}//for
	}
	
	public void deleteObject() {
		System.out.println("\n==== 추첨 대상 삭제 ====");
		System.out.print("삭제할 이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("삭제할 핸드폰 번호를 입력하세요 : ");
		String phone = sc.next();
		
		boolean flag = lc.deleteObject(new Lottery(name, phone));
		System.out.println(flag?"삭제 완료 되었습니다.":"존재하지 않는 대상입니다.");		
	}
	
	public void winObject() {
		System.out.println("\n==== 당첨 대상 확인 ====");
		System.out.println(lc.winObject());
	}
	
	public void sortedWinObject() {
		System.out.println("\n==== 정렬된 당첨 대상 확인 ====");
		Set<Lottery> set = lc.sortedWinObject();
		Iterator<Lottery> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
	
	public void searchWinner() {
		System.out.println("\n==== 당첨 대상 검색 ====");
		System.out.print("검색할 이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("검색할 핸드폰 번호를 입력하세요 : ");
		String phone = sc.next();
		
		boolean flag = lc.searchWinner(new Lottery(name, phone));
		
		System.out.println(flag?"축하합니다. 당첨 목록에 존재합니다.":"안타깝지만 당첨 목록에 존재하지 않습니다.");		
	}
}