package com.booking.form;

import java.util.ArrayList;
import java.util.List;
import com.booking.modal.Property;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by raghuramn on 6/18/16.
 */
public class ProviderEnrollmentForm {

	@NotEmpty(message = "Please enter firstName")
	String firstName;
	String middleName;
	@NotEmpty(message = "Please enter lastName")
	String lastName;
	@NotEmpty(message = "Please enter password")
	String password;
	@NotEmpty(message = "Please enter email")
	@Email(message = "Please enter a valid email")
	String email;
	@NotEmpty(message = "Please enter primaryPhone")
	@Pattern(regexp = "\\d{10}", message = "Please enter a valid phone number")
	String primaryPhone;
	@Pattern(regexp = "\\d{10}", message = "Please enter a valid phone number")
	String alternatePhone;
	String role="ROLE_USER";
	List<Property> properties = new ArrayList<Property>();

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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
