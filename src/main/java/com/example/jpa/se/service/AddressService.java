package com.example.jpa.se.service;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.example.jpa.se.entity.Address;

public class AddressService {

	private EntityManager entityManager;
	Logger LOGGER = Logger.getLogger(AddressService.class);

	public AddressService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Address create(Address address) {
		if(address != null) {
			entityManager.persist(address);
			LOGGER.info("Address saved successfully with address_id :: " + address.getAddressId());
		}
		return address;
	}
}
