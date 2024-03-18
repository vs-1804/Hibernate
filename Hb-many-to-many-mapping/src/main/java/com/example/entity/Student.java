package com.example.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course",
	           joinColumns = @JoinColumn(name="student_id"),
	           inverseJoinColumns = @JoinColumn(name="course_id"))
	private Set<Course> courses;
	

	public Student() {
		
	}

	public Student( String name) {
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


	public Set<Course> getCourse() {
		return courses;
	}


	public void setCourse(Set<Course> courses) {
		this.courses = courses;
	}
	
}
