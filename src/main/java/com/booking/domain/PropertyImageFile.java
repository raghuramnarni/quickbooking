package com.booking.domain;

import javax.persistence.*;

/**
 * Created by raghuramn on 7/8/16.
 */
@Entity
@Table(name = "PROPERTY_PHOTO")
public class PropertyImageFile {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	Long id;

	@Column(name="NAME")
	String name;

	@Column(name="PATH")
	String path;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PROPERTY_ID")
	Property property;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public PropertyImageFile(){

	}

	public PropertyImageFile(String name, String path, Property property){
		setName(name);
		setPath(path);
		setProperty(property);
	}
}
