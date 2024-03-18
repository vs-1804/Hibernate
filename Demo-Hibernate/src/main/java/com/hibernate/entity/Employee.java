package com.hibernate.entity;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	@Basic(optional = false)
	private String name;
	private int deptId;
	@Convert(converter = GenderConverter.class)
	private Gender sex;
	//Creation timestamp
	@CreationTimestamp
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_At", updatable = false)
	private LocalDateTime createdAt;

	// Update timestamp
	@UpdateTimestamp
	@Column(name = "updated_At")
	private LocalDateTime updatedAt;

	@Embedded
	private Address permanentAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "city", column = @Column(name = "temp_city")),
			@AttributeOverride(name = "state", column = @Column(name = "temp_state")) })
	private Address tempAddress;

	public Employee() {

	}

	public Employee( String name, int deptId, Gender sex, 
			Address permanentAddress, Address tempAddress) {
		super();
		//this.empId = empId;
		this.name = name;
		this.deptId = deptId;
		this.sex = sex;
		//this.createdAt = createdAt;
		//this.updatedAt = updatedAt;
		this.permanentAddress = permanentAddress;
		this.tempAddress = tempAddress;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Address getTempAddress() {
		return tempAddress;
	}

	public void setTempAddress(Address tempAddress) {
		this.tempAddress = tempAddress;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", deptId=" + deptId + ", sex=" + sex + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", permanentAddress=" + permanentAddress + ", tempAddress="
				+ tempAddress + "]";
	}

	
}
