package com.spring.app;

import java.util.List;

import com.spring.entity.Employee;
import com.spring.service.EmployeeService;
import com.spring.service.employeeServiceImpl;

public class EmployeeHibernateApp {

		private static EmployeeService employeeService = (EmployeeService) new employeeServiceImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee p1 = new Employee("Mark Collins", "project1");
		Employee p2 = new Employee("Heather tearci", "project2");
		
		employeeService.saveEmployee(p1);
		employeeService.saveEmployee(p2);
		
		p1.setProjectName("project1");
		if(EmployeeService.updateEmployee(p1)) {
			System.out.println("Project updated properly");
		} else {
			System.out.println("Project not updated");
		}
		
		List<Employee> allEmployees = EmployeeService.getAllEmployees();
		allEmployees.stream().forEach(System.out::println);
		System.out.println("-----------------------------------------");
		System.out.println("Project details" + EmployeeService.getEmployeeByNo(1));
	
	}

}
