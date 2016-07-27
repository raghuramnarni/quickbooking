package com.booking.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by raghuramn on 7/8/16.
 */
public class ProviderSearchForm {

	@NotEmpty(message = "Please enter email")
	@Email(message = "Please enter a valid email")
	String email;

	@NotEmpty(message = "Please enter password")
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
