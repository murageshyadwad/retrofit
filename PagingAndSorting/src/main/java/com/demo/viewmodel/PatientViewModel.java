package com.demo.viewmodel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class PatientViewModel {

	
	
	

	
	


		//@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		

		private String name;
		
		private String city;
		
		private String zip;
		private String lname;
		
		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}


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


