package com.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//Domain class for the structure of the zoostaff table
@Entity
public class ZooStaff implements java.io.Serializable{
	//Needs this serialVersionUID to avoid the compiler warning about mismatched serialversionUID
	private static final long serialVersionUID = -6885760160516574461L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fullName;
	private String animalGroup;
	private String role;
	private int salary;

	public ZooStaff() {}
	
	public ZooStaff(String fullName, String animalGroup, String role, int salary) {
		this.fullName = fullName;
		this.animalGroup = animalGroup;
		this.role = role;
		this.salary = salary;
	}
	
	
	
	//Getters and setters for the different variables
	public void setId(int id) {
		this.id = id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAnimalGroup(String animalGroup) {
		this.animalGroup = animalGroup;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getAnimalGroup() {
		return animalGroup;
	}

	public String getRole() {
		return role;
	}

	public int getSalary() {
		return salary;
	}
	
	public String toString() {
		return "Staff: " + fullName + " takes care of " + animalGroup + " with the role " + role;
	}
}
