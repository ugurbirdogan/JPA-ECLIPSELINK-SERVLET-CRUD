package com.ugur.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	
}
