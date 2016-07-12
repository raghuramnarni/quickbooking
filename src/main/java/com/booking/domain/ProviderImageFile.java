package com.booking.domain;

import javax.persistence.*;

/**
 * Created by raghuramn on 7/8/16.
 */
@Entity
@Table(name = "PROVIDER_PHOTO")
public class ProviderImageFile {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	Long id;

	@Column(name="NAME")
	String name;

	@Column(name="PATH")
	String path;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PROVIDER_ID")
	Provider provider;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ProviderImageFile(){

	}

	public ProviderImageFile(String name, String path, Provider provider){
		setName(name);
		setPath(path);
		setProvider(provider);
	}
}
