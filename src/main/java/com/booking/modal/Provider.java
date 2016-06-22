package com.booking.modal;

/**
 * Created by raghuramn on 6/18/16.
 */
public class Provider {
	String firstName;
	String middleName;
	String lastName;
	String password;
	String primaryPhone;
	String alternatePhone;

	public Provider(){
		
	}
	
	public Provider(com.booking.domain.Provider provider){
		this.firstName = provider.getFirstName();
		this.middleName = provider.getMiddleName();
		this.lastName = provider.getLastName();
		this.password = provider.getPassword();
		this.primaryPhone = provider.getPrimaryPhone();
		this.alternatePhone = provider.getAlternatePhone();
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
}
