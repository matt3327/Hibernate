package com.spring.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.spring.entity.Employee;



public class employeeDaoImpI implements employeeDao {
	private static StandardServiceRegistry registry = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
    private static Transaction transaction = null;
    
    static {
    	StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

		Map<String, String> settings = new HashMap<>();
		settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/class");
		settings.put("hibernate.connection.username", "root");
		settings.put("hibernate.connection.password", "root");
		settings.put("hibernate.show_sql", "true");
		settings.put("hibernate.hbm2ddl.auto", "update");

		registryBuilder.applySettings(settings);
		registry = registryBuilder.build();

		MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Employee.class);
		Metadata metadata = sources.getMetadataBuilder().build();

		sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    
    @Override
	public boolean saveEmployee(Employee employee) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
    	return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		return true;
	}

	@Override
	public boolean deleteEmployee(int employeeNo) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Employee employee = new Employee();
		Employee.setEmployeeNo(employeeNo);
		session.delete(employee);
		transaction.commit();
    	return true;
	}

	@Override
	public List<Employee> getAllEmployees() {
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		return criteria.list();
	}

	@Override
	public Employee getEmployeeByNo(int EmployeeNo) {
		session = sessionFactory.openSession();
		return session.get(Employee.class, EmployeeNo);
	}
    
}
