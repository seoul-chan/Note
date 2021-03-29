package com.home2.model.dao;

import static com.home2.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.home2.model.vo.Department;
import com.home2.model.vo.Employee;
import com.home2.model.vo.Job;

public class EmployeeDao {
	Properties prop=new Properties();
	
	public EmployeeDao(){
		try {
			prop.load(new FileReader("resource/sql/sql.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> searchAll(Connection conn) {
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		List<Employee> list =new ArrayList<Employee>();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchAll"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setEmpId(rs.getInt("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getFloat("bonus"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYn(rs.getString("ent_yn"));
				list.add(e);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
		
	public List<Employee> searchDep(Connection conn,String depCode) {
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		List<Employee> list =new ArrayList<Employee>();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchDep"));
			pstmt.setString(1, depCode);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setEmpId(rs.getInt("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getFloat("bonus"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYn(rs.getString("ent_yn"));
				list.add(e);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Employee> searchJob(Connection conn,String jobCode) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Employee> list=new ArrayList<Employee>();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchJob"));
			pstmt.setString(1, jobCode);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Employee e=new Employee();
				e.setEmpId(rs.getInt("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getFloat("bonus"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYn(rs.getString("ent_yn"));
				list.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Employee> searchName(Connection conn,String name) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Employee> list=new ArrayList<Employee>();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchName"));
			pstmt.setString(1, "%"+name+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Employee e=new Employee();
				e.setEmpId(rs.getInt("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getFloat("bonus"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYn(rs.getString("ent_yn"));
				list.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Employee> searchSalary(Connection conn,int[] salary) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Employee> list=new ArrayList<Employee>();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty(salary[1]>0?"searchSalaryUp":"searchSalaryDown"));
			pstmt.setInt(1, salary[0]);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Employee e=new Employee();
				e.setEmpId(rs.getInt("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getFloat("bonus"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYn(rs.getString("ent_yn"));
				list.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int insertEmp(Connection conn,Employee emp) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try{
			pstmt=conn.prepareStatement(prop.getProperty("insertEmp"));
			pstmt.setInt(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpNo());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getDeptCode());
			pstmt.setString(7, emp.getJobCode());
			pstmt.setString(8, emp.getSalLevel());
			pstmt.setInt(9, emp.getSalary());
			pstmt.setFloat(10, emp.getBonus());
			pstmt.setInt(11, emp.getManagerId());
			pstmt.setDate(12, emp.getHireDate());
			pstmt.setDate(13, emp.getEntDate());
			pstmt.setString(14, emp.getEntYn());			
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateEmp(Connection conn,Employee emp) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try{
			pstmt=conn.prepareStatement(prop.getProperty("updateEmp"));
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setString(3, emp.getDeptCode());
			pstmt.setString(4, emp.getJobCode());
			pstmt.setInt(5, emp.getSalary());	
			pstmt.setInt(6, emp.getEmpId());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteEmp(Connection conn,int emp) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try{
			pstmt=conn.prepareStatement(prop.getProperty("deleteEmp"));
			pstmt.setInt(1, emp);		
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertDep(Connection conn,Department dep) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertDep"));
			pstmt.setString(1, dep.getDeptId());
			pstmt.setString(2, dep.getDeptTitle());
			pstmt.setString(3, dep.getLocationId());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateDep(Connection conn,Department[] dep) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateDep"));
			pstmt.setString(1, dep[0].getDeptId());
			pstmt.setString(2, dep[0].getDeptTitle());
			pstmt.setString(3, dep[0].getLocationId());
			pstmt.setString(4, dep[1].getDeptId());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteDep(Connection conn,String depId) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteDep"));
			pstmt.setString(1, depId);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertJob(Connection conn,Job job) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertJob"));
			pstmt.setString(1, job.getJobCode());
			pstmt.setString(2, job.getJobName());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateJob(Connection conn,Job[] job) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateJob"));
			pstmt.setString(1, job[1].getJobCode());
			pstmt.setString(2, job[1].getJobName());
			pstmt.setString(3, job[0].getJobCode());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteJob(Connection conn,String jobCode) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteJob"));
			pstmt.setString(1, jobCode);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
