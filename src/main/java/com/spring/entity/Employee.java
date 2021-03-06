package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PoductTable")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column (name = "EmployeeName", length = 30, nullable = false)
	private String EmployeeName;
	private String ProjectName;
	
	public Employee() {
		
	}
	
	public Employee(String EmployeeName, String ProjectName) {
		super();
		this.EmployeeName = EmployeeName;
		this.ProjectName = ProjectName;
	}
	
private int EmployeeNo;
	
	public int getEmployeeNo() {
		return EmployeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		EmployeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeName=" + EmployeeName + ", ProjectName=" + ProjectName + "]";
	}
}
