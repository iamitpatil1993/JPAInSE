package com.example.jpa.se.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	private PersistenceManager() {
		// nothing to do here
	}

	public static EntityManager createEntityManager(String persistenceUnitname) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitname);
		return entityManagerFactory.createEntityManager();
	}
}
