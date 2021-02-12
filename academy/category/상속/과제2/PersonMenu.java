package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {
		while(true) {
			int[] count = pc.personCount();
			System.out.println();
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 "+count[0]+"명 입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 "+count[1]+"명 입니다.");
			
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			
			int cho = sc.nextInt();
			switch(cho) {
				case 1 : studentMenu(); break;
				case 2 : employeeMenu(); break;
				case 9 : System.out.println("종료합니다."); return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void studentMenu() {
		while(true) {
			int[] count = pc.personCount();
			System.out.println("\n==== 학생 메뉴 ====");
			System.out.println((count[0]==3)?"학생을 담을 수 있는 공간이 꽉 찾기 떄문에 "
										+ "학생 추가 메뉴는 더 이상 활성되 되지 않습니다.":"1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			
			int cho = sc.nextInt();
			if(count[0]==3&&cho==1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			switch(cho) {
				case 1: insertStudent(); break;
				case 2: printStudent(); break;
				case 9 : System.out.println("메인으로 돌아갑니다."); return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void employeeMenu() {
		while(true) {
			int[] count = pc.personCount();
			System.out.println("\n==== 사원 메뉴 ====");
			System.out.println((count[1]==10)?"사원을 담을 수 있는 공간이 꽉 찾기 떄문에 "
										+ "사원 추가 메뉴는 더 이상 활성되 되지 않습니다.":"1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			
			int cho = sc.nextInt();
			if(count[1]==10&&cho==1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			switch(cho) {
				case 1: insertEmployee(); break;
				case 2: printEmployee(); break;
				case 9 : System.out.println("메인으로 돌아갑니다."); return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insertStudent() {
		while(true) {
			System.out.println("\n==== 학생 추가 메뉴 ====");
			System.out.print("학생 이름 : ");
			String name = sc.next();
			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			System.out.print("학생 키 : ");
			double height = sc.nextDouble();
			System.out.print("학생 몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			System.out.print("학생 전공 : ");
			String major = sc.next();
			
			pc.insertStudent(name, age, height, weight, grade, major);
			
			int[] count = pc.personCount();
			if(count[0]<3) {
				System.out.println("그만 하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			} else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찾기 떄문에 학생 추가를 종료하고 "
						+ "학생 메뉴로 돌아갑니다.");
				break;
			}
			
			char conti = sc.next().charAt(0);
			if(conti=='N'||conti=='n') break;
		}
	}
	
	public void printStudent() {
		Student[] s = pc.printStudent();
		
		System.out.println();
		if(s==null) {
			System.out.println("저장된 학생정보가 없습니다.");
		} else {
			for(int i=0;i<s.length;i++) {
				if(s[i]!=null) System.out.println(s[i]);
			}
		}
	}
	
	public void insertEmployee() {
		while(true) {
			System.out.println("\n==== 사원 추가 메뉴 ====");
			System.out.print("사원 이름 : ");
			String name = sc.next();
			System.out.print("사원 나이 : ");
			int age = sc.nextInt();
			System.out.print("사원 키 : ");
			double height = sc.nextDouble();
			System.out.print("사원 몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("사원 급여 : ");
			int salary = sc.nextInt();
			System.out.print("사원 부서 : ");
			String dept = sc.next();
			
			pc.insertEmployee(name, age, height, weight, salary, dept);
			
			int[] count = pc.personCount();
			if(count[1]<10) {
				System.out.println("그만 하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			} else {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찾기 떄문에 사원 추가를 종료하고 "
						+ "사원 메뉴로 돌아갑니다.");
				break;
			}
			
			char conti = sc.next().charAt(0);
			if(conti=='N'||conti=='n') break;
		}
	}
	
	public void printEmployee() {
		Employee[] e = pc.printEmloyee();
		
		System.out.println();
		if(e==null) {
			System.out.println("저장된 사원정보가 없습니다.");
		} else {
			for(int i=0;i<e.length;i++) {
				if(e[i]!=null) System.out.println(e[i]);
			}
		}
	}
}
