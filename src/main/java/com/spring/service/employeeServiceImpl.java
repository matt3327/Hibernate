package com.spring.service;

import java.util.List;


import com.spring.dao.employeeDao;
import com.spring.dao.employeeDaoImpI;
import com.spring.entity.Employee;

public class employeeServiceImpl {
private static employeeDao employeeDao = new employeeDaoImpI();
	
	
	public boolean saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}

	
	public boolean updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	
	public boolean deleteEmployee(Integer employeeNo) {
		return employeeDao.deleteEmployee(employeeNo);
	}

	
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	
	public Employee getEmployeeByNo(int employeeNo) {
		return employeeDao.getEmployeeByNo(employeeNo);
	}
}
