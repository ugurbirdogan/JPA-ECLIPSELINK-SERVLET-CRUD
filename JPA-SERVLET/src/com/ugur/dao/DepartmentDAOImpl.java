package com.ugur.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ugur.model.Department;
import com.ugur.utility.EntityManagerProvider;

public class DepartmentDAOImpl implements DepartmentDAO{
	
	private EntityManager entityManager;
	
	public DepartmentDAOImpl() {

		EntityManagerFactory entityManagerFactory = EntityManagerProvider.getEntityManagerFactory();
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Override
	public Department insertDepartment(String name) {
		
		Department department = new Department(name);
		
		entityManager.getTransaction().begin();
		entityManager.persist(department);
		entityManager.getTransaction().commit();
		
		return department;
	}

	@Override
	public Department findDepartment(int id) {

		return entityManager.find(Department.class, id);
		
	}

	@Override
	public List<Department> findAllDepartments() {
		
		Query query = entityManager.createQuery("Select d from Department d");
		return query.getResultList();
	}

	@Override
	public void deleteDepartment(int id) {

		Department department = findDepartment(id);
		
		if(department != null) {
			
			entityManager.getTransaction().begin();
			entityManager.remove(department);
			entityManager.getTransaction().commit();
		}
	}

	@Override
	public void updateDepartment(int id, String name) {

		Department department = findDepartment(id);
		
		entityManager.getTransaction().begin();
		
		department.setName(name);
		
		entityManager.getTransaction().commit();
		
	}

	@Override
	public Department getDepartmentByName(String name) {

		TypedQuery<Department> query = entityManager.createQuery("Select d from Department d where d.name=:dName",Department.class).setParameter("dName", name);
		List<Department> found = query.getResultList();

	    if (found.isEmpty()) {
	        return null; //or throw checked exception data not found
	    } else {
	        return found.get(0);
	    }
	}

}
