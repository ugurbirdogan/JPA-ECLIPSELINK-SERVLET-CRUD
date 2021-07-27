package com.ugur.dao;

import java.util.List;

import com.ugur.model.Employee;

public interface EmployeeDAO {

	
	public void insertEmployee(Employee employee);
	
	public Employee findEmployee(int id);
	
	public List<Employee> findAllEmployees();
	
	public void deleteEmployee(int id);
	
	public void updateEmployee(int id, Employee employee);
	
	
}
