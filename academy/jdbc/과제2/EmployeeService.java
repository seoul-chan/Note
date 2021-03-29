package com.home2.model.service;

import static com.home2.common.JDBCTemplate.close;
import static com.home2.common.JDBCTemplate.commit;
import static com.home2.common.JDBCTemplate.getConnection;
import static com.home2.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.home2.model.dao.EmployeeDao;
import com.home2.model.vo.Department;
import com.home2.model.vo.Employee;
import com.home2.model.vo.Job;;


public class EmployeeService {
	EmployeeDao dao=new EmployeeDao();

	public List<Employee> searchAll() {
		Connection conn=getConnection();
		List<Employee> list=dao.searchAll(conn);
		
		close(conn);
		return list;
	}
		
	public List<Employee> searchDep(String depCode) {
		Connection conn=getConnection();
		List<Employee> list=dao.searchDep(conn,depCode);
		
		close(conn);
		return list;
	}
	
	public List<Employee> searchJob(String jobCode) {
		Connection conn=getConnection();
		List<Employee> list=dao.searchJob(conn,jobCode);
		
		close(conn);
		return list;		
	}
	
	public List<Employee> searchName(String name) {
		Connection conn=getConnection();
		List<Employee> list=dao.searchName(conn,name);
		
		close(conn);
		return list;		
	}
	
	public List<Employee> searchSalary(int[] salary) {
		Connection conn=getConnection();
		List<Employee> list=dao.searchSalary(conn,salary);
		
		close(conn);
		return list;		
	}
	
	public int insertEmp(Employee e) {
		Connection conn=getConnection();
		int result=dao.insertEmp(conn,e);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int updateEmp(Employee e) {
		Connection conn=getConnection();
		int result=dao.updateEmp(conn,e);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int deleteEmp(int e) {
		Connection conn=getConnection();
		int result=dao.deleteEmp(conn,e);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int insertDep(Department dep) {
		Connection conn=getConnection();
		int result=dao.insertDep(conn,dep);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int updateDep(Department[] dep) {
		Connection conn=getConnection();
		int result=dao.updateDep(conn,dep);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int deleteDep(String depId) {
		Connection conn=getConnection();
		int result=dao.deleteDep(conn,depId);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int insertJob(Job job) {
		Connection conn=getConnection();
		int result=dao.insertJob(conn,job);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int updateJob(Job[] job) {
		Connection conn=getConnection();
		int result=dao.updateJob(conn,job);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int deleteJob(String jobCode) {
		Connection conn=getConnection();
		int result=dao.deleteJob(conn,jobCode);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
}
