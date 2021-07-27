package com.ugur.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.ugur.model.Employee;
import com.ugur.utility.EntityManagerProvider;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	public EmployeeDAOImpl() {

		EntityManagerFactory entityManagerFactory = EntityManagerProvider.getEntityManagerFactory();
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public void insertEmployee(Employee employee) {

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

	@Override
	public Employee findEmployee(int id) {

		return entityManager.find(Employee.class, id);
		
	}

	@Override
	public List<Employee> findAllEmployees() {

		Query query = entityManager.createQuery("Select e from Employee e ");
		return query.getResultList();
		
	}

	@Override
	public void deleteEmployee(int id) {

		Employee employee = findEmployee(id);
		
		if(employee != null ) {
			
			entityManager.getTransaction().begin();
			entityManager.remove(employee);
			entityManager.getTransaction().commit();
			
		}
		
	}

	@Override
	public void updateEmployee(int id, Employee employee) {

		Employee emp = findEmployee(id);
		
		entityManager.getTransaction().begin();
		
		emp.setName(employee.getName());
		emp.setSurname(employee.getSurname());
		emp.setSalary(employee.getSalary());
		emp.setTitle(employee.getTitle());
		emp.setDepartment(employee.getDepartment());
		
		entityManager.getTransaction().commit();
		
	}

}
