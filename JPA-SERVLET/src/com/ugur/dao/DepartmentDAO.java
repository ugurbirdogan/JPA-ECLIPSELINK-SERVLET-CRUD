package com.ugur.dao;

import java.util.List;

import com.ugur.model.Department;

public interface DepartmentDAO {
	
	public Department insertDepartment(String name);
	
	public Department findDepartment(int id);
	
	public List<Department> findAllDepartments();
	
	public void deleteDepartment(int id);
	
	public void updateDepartment(int id, String name);
	
	public Department getDepartmentByName(String name);

}
