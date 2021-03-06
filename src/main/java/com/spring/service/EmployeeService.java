package com.spring.service;

import java.util.List;

import com.spring.entity.Employee;

public interface EmployeeService {
	public boolean saveEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int EmployeeNo);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeByNo(int EmployeeNo);
}
