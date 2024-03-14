package com.example.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "publisher_id")
	private int id;
	
	private String name;
	@OneToOne(mappedBy = "publisher", cascade = CascadeType.ALL)
	private Book book;
	
	public Publisher() {
		super();
	}
	public Publisher( String name) {
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
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
