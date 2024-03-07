package com.example.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "contractual")
public class Contractual_Employee  extends Employee1 {
	 
    private float pay_per_hour;  
       
    private String contract_duration;

	public Contractual_Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contractual_Employee(String name,float pay_per_hour, String contract_duration) {
		super(name);
		this.pay_per_hour = pay_per_hour;
		this.contract_duration = contract_duration;
	}

	public float getPay_per_hour() {
		return pay_per_hour;
	}

	public void setPay_per_hour(float pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	public String getContract_duration() {
		return contract_duration;
	}

	public void setContract_duration(String contract_duration) {
		this.contract_duration = contract_duration;
	}

	
    

}
