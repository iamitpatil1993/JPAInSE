package com.example.jpa.se.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.example.jpa.se.entity.Address;
import com.example.jpa.se.service.AddressService;
import com.example.jpa.se.service.PersistenceManager;

public class MainClass {

	private static Logger LOGGER = Logger.getLogger(MainClass.class);

	public static void main(String args[]) {

		EntityManager entityManager = PersistenceManager.createEntityManager("JPADB");
		entityManager.getTransaction().begin();
		AddressService addressService = new AddressService(entityManager);

		// 1. Create address
		Address address = addressService.create(new Address(null, "Gajanan Hos. Soc.", "Pune", "asdasd", "India", "411033"));
		entityManager.getTransaction().commit();


		// 2. Update Address
		entityManager.getTransaction().begin();
		Address address2 = entityManager.find(Address.class, 4);
		address2.setCity("Mumbai");

		entityManager.getTransaction().commit();
		LOGGER.info("address saved with address_id = " + 4);
		
		
		// 3. Delete address
		entityManager.getTransaction().begin();
		Address address3 = entityManager.getReference(Address.class, address.getAddressId() -1);
		entityManager.remove(address3);
		entityManager.getTransaction().commit();
		
		
		// query all entity managers
		TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a", Address.class);
		List<Address> addresses = query.getResultList();
		addresses.stream().forEach(System.out::println);
		
		
		TypedQuery<Address> namedAddressTypedQuery = entityManager.createNamedQuery("Address.findAll", Address.class);
		List<Address> namedQueryAddressList = namedAddressTypedQuery.getResultList();
		namedQueryAddressList.stream().forEach(System.out::println);

	}

}
