package com.home2.controller;

import java.util.List;

import com.home2.model.service.EmployeeService;
import com.home2.model.vo.Department;
import com.home2.model.vo.Employee;
import com.home2.model.vo.Job;
import com.home2.view.MainView;

public class EmployeeController {
	MainView view;
	EmployeeService service=new EmployeeService();
	
	public void mainMenu() {
		view=new MainView();
		view.mainMenu(this);		
	}
	
	public void searchAll() {
		List<Employee> list=service.searchAll();
		view.printAll(list);		
	}
	
	public void searchEmp() {
		switch(view.searchEmp()) {
			case 1 : searchDep(); break;
			case 2 : searchJob(); break;
			case 3 : searchName(); break;
			case 4 : searchSalary(); break;
			default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void searchDep() {
		String depCode = view.searchDep();
		List<Employee> list=service.searchDep(depCode);
		view.printAll(list);
	}
	
	public void searchJob() {
		String jobCode = view.searchJob();
		List<Employee> list=service.searchJob(jobCode);
		view.printAll(list);
	}
	
	public void searchName() {
		String name = view.searchName();
		List<Employee> list=service.searchName(name);
		view.printAll(list);
	}
	
	public void searchSalary() {
		int[] salary = view.searchSalary();
		List<Employee> list=service.searchSalary(salary);
		view.printAll(list);
	}
	
	public void insertEmp() {
		Employee e = view.insertEmp();
		int result=service.insertEmp(e);
		view.printMsg(result>0?"입력 성공":"입력 실패");
	}
	
	public void updateEmp() {
		Employee e = view.updateEmp();
		int result=service.updateEmp(e);
		view.printMsg(result>0?"수정 성공":"수정 실패");
	}
	
	public void deleteEmp() {
		int e=view.deleteEmp();
		int result=service.deleteEmp(e);
		view.printMsg(result>0?"삭제 성공":"삭제 실패");
	}
	
	public void depMenu() {
		switch(view.depMenu()) {
		case 1 : insertDep(); break;
		case 2 : updateDep(); break;
		case 3 : deleteDep(); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void insertDep() {
		Department dep = view.insertDep();
		int result=service.insertDep(dep);
		view.printMsg(result>0?"입력 성공":"입력 실패");
	}
	
	public void updateDep() {
		Department[] dep = view.updateDep();
		int result=service.updateDep(dep);
		view.printMsg(result>0?"수정 성공":"수정 실패");
	}
	
	public void deleteDep() {
		String depCode = view.deleteDep();
		int result=service.deleteDep(depCode);
		view.printMsg(result>0?"삭제 성공":"삭제 실패");
	}
	
	public void jobMenu() {
		switch(view.jobMenu()) {
		case 1 : insertJob(); break;
		case 2 : updateJob(); break;
		case 3 : deleteJob(); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void insertJob() {
		Job job=view.insertJob();
		int result=service.insertJob(job);
		view.printMsg(result>0?"입력 성공":"입력 실패");
	}
	
	public void updateJob() {
		Job[] job=view.updateJob();
		int result=service.updateJob(job);
		view.printMsg(result>0?"입력 성공":"입력 실패");
	}
	
	public void deleteJob() {
		String jobCode=view.deleteJob();
		int result=service.deleteJob(jobCode);
		view.printMsg(result>0?"삭제 성공":"삭제 실패");
	}
}
