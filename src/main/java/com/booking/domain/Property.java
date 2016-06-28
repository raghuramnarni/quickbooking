package com.booking.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by raghuramn on 6/17/16.
 */
@Entity
public class Property implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "ID_PROPERTY")
	long id;
	@Column(name = "VENUE_NAME")
	String venueName;
	@Column(name = "ADDRESS_LINE_1")
	String addressLine1;
	@Column(name = "ADDRESS_LINE_2")
	String addressLine2;
	@Column(name = "LAND_MARK")
	String landMark;
	@Column(name = "POSTAL_CODE")
	String postalCode;
	@Column(name = "CITY")
	String city;
	@Column(name = "STATE")
	String state;
	@Column(name = "COUNTRY")
	String country;
	@ManyToOne
	@JoinColumn(name="ID_PROVIDER")
	Provider provider;

	public Property(com.booking.modal.Property property) {
		setVenueName(property.getVenueName());
		setAddressLine1(property.getAddressLine1());
		setAddressLine2(property.getAddressLine2());
		setLandMark(property.getLandMark());
		setPostalCode(property.getPostalCode());
		setCity(property.getCity());
		setState(property.getState());
		setCountry(property.getCountry());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
