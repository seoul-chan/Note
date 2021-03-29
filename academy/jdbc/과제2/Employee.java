package com.home2.model.vo;

import java.sql.Date;

public class Employee {
	private int empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private float bonus;
	private int managerId;
	private Date hireDate;
	private Date entDate;
	private String entYn;
	
	public Employee() {}

	public Employee(int empId, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, int salary, float bonus, int managerId, Date hireDate, Date entDate,
			String entYn) {
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
	}
	
	public int getEmpId() {return empId;}
	public String getEmpName() {return empName;}
	public String getEmpNo() {return empNo;}
	public String getEmail() {return email;}
	public String getPhone() {return phone;}
	public String getDeptCode() {return deptCode;}
	public String getJobCode() {return jobCode;}
	public String getSalLevel() {return salLevel;}
	public int getSalary() {return salary;}
	public float getBonus() {return bonus;}
	public int getManagerId() {return managerId;}
	public Date getHireDate() {return hireDate;}
	public Date getEntDate() {return entDate;}
	public String getEntYn() {return entYn;}

	public void setEmpId(int empId) {this.empId = empId;}
	public void setEmpName(String empName) {this.empName = empName;}
	public void setEmpNo(String empNo) {this.empNo = empNo;}
	public void setEmail(String email) {this.email = email;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setDeptCode(String deptCode) {this.deptCode = deptCode;}
	public void setJobCode(String jobCode) {this.jobCode = jobCode;}
	public void setSalLevel(String salLevel) {this.salLevel = salLevel;}
	public void setSalary(int salary) {this.salary = salary;}
	public void setBonus(float bonus) {this.bonus = bonus;}
	public void setManagerId(int managerId) {this.managerId = managerId;}
	public void setHireDate(Date hireDate) {this.hireDate = hireDate;}
	public void setEntDate(Date entDate) {this.entDate = entDate;}
	public void setEntYn(String entYn) {this.entYn = entYn;}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", salLevel=" + salLevel
				+ ", salary=" + salary + ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate
				+ ", entDate=" + entDate + ", entYn=" + entYn + "]";
	}
}
