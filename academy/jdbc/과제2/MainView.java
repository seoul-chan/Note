package com.home2.view;

import java.util.List;
import java.util.Scanner;

import com.home2.controller.EmployeeController;
import com.home2.model.vo.Department;
import com.home2.model.vo.Employee;
import com.home2.model.vo.Job;

public class MainView {
	private EmployeeController ec;
	
	public void mainMenu(EmployeeController ec) {
		this.ec=ec;
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("==== 메인 메뉴 ====");
			System.out.println("1. 전체사원 조회");
			System.out.println("2. 사원조회");
			System.out.println("3. 사원 등록");
			System.out.println("4. 사원 수정(직책,부서,급여,전화번호,이메일)");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 부서 관리");
			System.out.println("7. 직책 관리");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
			
			switch(sc.nextInt()) {
				case 0 : System.out.println("프로그램을 종료합니다."); return;	
				case 1 : ec.searchAll(); break;
				case 2 : ec.searchEmp(); break;
				case 3 : ec.insertEmp(); break;
				case 4 : ec.updateEmp(); break;
				case 5 : ec.deleteEmp(); break;
				case 6 : ec.depMenu(); break;
				case 7 : ec.jobMenu(); break;
			}
		}
	}
	
	public void printAll(List<Employee> list) {
		for(Employee e : list)
			System.out.println(e);
	}
	
	public void printMsg(String msg) {
		System.out.println("===================");
		System.out.println(msg);
		System.out.println("===================");
	}
	
	public int searchEmp() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 사원 조회 ====");
		System.out.println("1. 부서 조회");
		System.out.println("2. 직책 조회");
		System.out.println("3. 이름 조회");
		System.out.println("4. 급여 조회");
		System.out.print("입력 : ");
		
		return sc.nextInt();
	}
	
	public String searchDep() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 부서 조회 ====");
		System.out.print("부서 입력 : ");
		return sc.next();
	}
	
	public String searchJob() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 직책 조회 ====");
		System.out.print("직책 입력 : ");
		return sc.next();
	}
	
	public String searchName() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 이름 조회 ====");
		System.out.print("이름 입력 : ");
		return sc.next();
	}
	
	public int[] searchSalary() {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[2];
		
		System.out.println("==== 급여 조회 ====");
		System.out.print("급여 입력 : ");
		arr[0]=sc.nextInt();
		System.out.print("이상(1)/이하(0) : ");
		arr[1]=sc.nextInt();
		return arr;
	}
	
	public Employee insertEmp() {
		Scanner sc=new Scanner(System.in);
		Employee e=new Employee();
		
		System.out.println("==== 사원 등록 ====");
		System.out.print("사원 번호 : ");
		e.setEmpId(sc.nextInt());
		System.out.print("이름 : ");
		e.setEmpName(sc.next());
		System.out.print("주민번호 : ");
		e.setEmpNo(sc.next());
		System.out.print("이메일 : ");
		e.setEmail(sc.next());
		System.out.print("핸드폰 번호 : ");
		e.setPhone(sc.next());
		System.out.print("부서 코드 : ");
		e.setDeptCode(sc.next());
		System.out.print("직책 코드 : ");
		e.setJobCode(sc.next());
		System.out.print("급여 수준 : ");
		e.setSalLevel(sc.next());
		System.out.print("급여 : ");
		e.setSalary(sc.nextInt());
		System.out.print("보너스 : ");
		e.setBonus(sc.nextFloat());
		System.out.print("매니저 코드 : ");
		e.setManagerId(sc.nextInt());

		return e;
	}
	
	public Employee updateEmp() {
		Scanner sc=new Scanner(System.in);
		Employee e=new Employee();

		System.out.println("==== 사원 수정 ====");
		
		System.out.println("=== 수정 전 ===");
		System.out.print("수정할 사원 코드 : ");
		e.setEmpId(sc.nextInt());
		
		System.out.println("=== 수정 후 ===");
		System.out.print("직책 코드 : ");
		e.setJobCode(sc.next());
		System.out.print("부서 코드 : ");
		e.setDeptCode(sc.next());
		System.out.print("급여 : ");
		e.setSalary(sc.nextInt());
		System.out.print("전화번호 : ");
		e.setPhone(sc.next());
		System.out.print("이메일 : ");
		e.setEmail(sc.next());
		
		return e;
	}
	
	public int deleteEmp() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 사원 삭제 ====");
		System.out.print("사원 번호 입력 : ");
		return sc.nextInt();
	}
	
	public int depMenu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 부서 관리 ====");
		System.out.println("1. 부서 등록");
		System.out.println("2. 부서 수정");
		System.out.println("3. 부서 삭제");
		System.out.print("입력 : ");
		
		return sc.nextInt();
	}
	
	public Department insertDep() {
		Scanner sc=new Scanner(System.in);
		Department dep = new Department();
		
		System.out.println("==== 부서 등록 ====");
		System.out.print("부서 코드 : ");
		dep.setDeptId(sc.next());
		System.out.print("부서 이름 : ");
		dep.setDeptTitle(sc.next());
		System.out.print("지역 코드 : ");
		dep.setLocationId(sc.next());
		
		return dep;
	}
	
	public Department[] updateDep() {
		Scanner sc=new Scanner(System.in);
		Department[] dep = new Department[2];
		dep[0]=new Department();
		dep[1]=new Department();
		
		System.out.println("==== 부서 수정 ====");
		System.out.println("=== 수정 전 ===");
		System.out.print("수정할 부서 코드 : ");
		dep[1].setDeptId(sc.next());
		
		System.out.println("=== 수정 후 ===");
		System.out.print("부서 코드 : ");
		dep[0].setDeptId(sc.next());
		System.out.print("부서 이름 : ");
		dep[0].setDeptTitle(sc.next());
		System.out.print("지역 코드 : ");
		dep[0].setLocationId(sc.next());
		
		return dep;
	}
	
	public String deleteDep() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== 부서 삭제 ====");
		System.out.print("부서 코드 : ");
		return sc.next();
	}
	
	public int jobMenu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 부서 관리 ====");
		System.out.println("1. 직책 등록");
		System.out.println("2. 직책 수정");
		System.out.println("3. 직책 삭제");
		System.out.print("입력 : ");
		
		return sc.nextInt();
	}
	
	public Job insertJob() {
		Scanner sc=new Scanner(System.in);
		Job job=new Job();
		
		System.out.println("==== 직책 등록 ====");
		System.out.print("직책 코드 : ");
		job.setJobCode(sc.next());
		System.out.print("직책 이름 : ");
		job.setJobName(sc.next());
		
		return job;
	}
	
	public Job[] updateJob() {
		Scanner sc=new Scanner(System.in);
		Job[] job=new Job[2];
		job[0]=new Job();
		job[1]=new Job();
		
		System.out.println("==== 직책 수정 ====");
		System.out.println("=== 수정 전 ===");
		System.out.print("수정할 직책 코드 : ");
		job[0].setJobCode(sc.next());
		
		System.out.println("=== 수정 후 ===");
		System.out.print("직책 코드 : ");
		job[1].setJobCode(sc.next());
		System.out.print("직책 이름 : ");
		job[1].setJobName(sc.next());
		
		return job;
	}
	
	public String deleteJob() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== 직책 삭제 ====");
		System.out.print("직책 코드 : ");
		return sc.next();
	}
}
