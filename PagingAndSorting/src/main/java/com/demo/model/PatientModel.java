package com.demo.model;



import java.util.UUID;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
public class PatientModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	private String name;
	
	private String city;
	
	private String zip;
	private String lname;
	
	

	/*
	 * public PatientModel() { super();
	 * 
	 * }
	 * 
	 * public PatientModel(long id, String name, String city, String zip) { super();
	 * this.id = id; this.name = name; this.city = city; this.zip = zip;
	 * this.lname=name+zip; }
	 */


	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	

	
	
	
	
}
