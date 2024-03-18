package com.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public  class Publisher {
	
	@Column(name = "publisher_name")
	private String name;

	@Column(name = "publisher_country")
	private String country;

	public Publisher() {
		super();
	}

	public Publisher(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}
