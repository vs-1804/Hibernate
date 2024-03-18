package com.example.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	@OneToMany(mappedBy = "manufacturer",cascade = CascadeType.ALL)
	private Set<Model> model;

	public Set<Model> getModel() {
		return model;
	}

	public void setModel(Set<Model> model) {
		this.model = model;
	}

	public Manufacturer() {
		super();
	}

	public Manufacturer( String name) {
		super();
		//this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
