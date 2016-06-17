package com.booking.modal;

import java.util.HashSet;
import java.util.List;

/**
 * Created by raghuramn on 6/16/16.
 */
public class Provider {

	long id;
	String firstName;
	String middleName;
	String lastName;
	String email;
	String password;
	String primaryPhone;
	String alternatePhone;
	HashSet<Property> properties;


	public Provider() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getAlternatePhone() {
		return alternatePhone;
	}

	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}

	public HashSet<Property> getProperties() {
		return properties;
	}

	public void setProperties(HashSet<Property> properties) {
		this.properties = properties;
	}
}
