package com.example.jpa.se.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(value= {

		@NamedQuery(
				name = "Address.findAll",
				query = "SELECT a FROM Address as a"
				)



})
@Entity
@Table(name = "address")
@Access(AccessType.FIELD)
public class Address {

	public Address() {
		// Nothing to do here
	}

	public Address(Integer addressId, String street, String city, String province, String country, String postcode) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postcode = postcode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;

	@Column(name = "street")
	private String street;

	@Column(name="city")
	private String city;

	@Column(name = "province")
	private String province;

	@Column(name = "country")
	private String country;

	@Column(name = "postcode")
	private String postcode;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", province=" + province
				+ ", country=" + country + ", postcode=" + postcode + "]";
	}

}
