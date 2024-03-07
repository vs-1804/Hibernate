package com.example.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "regular")
public class Regular_Employee  extends Employee1{
	
	private float salary;  
	  
	private int bonus;

	public Regular_Employee() {
		super();	
	}

	public Regular_Employee(String name,float salary, int bonus) {
		super(name);
		this.salary = salary;
		this.bonus = bonus;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	

	
	  

}
