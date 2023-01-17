package com.demo.model;




import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "charge")
public class Charge {
	
	public Charge() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private Long chargeid;
	

	public Long getChargeid() {
		return chargeid;
	}
	public void setChargeid(Long chargeid) {
		this.chargeid = chargeid;
	}

	private long id;
	private String planname;
	private String provider;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	private String lname;
	private String city;
	private String billingprovider;
	private double total;
	
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getBillingprovider() {
		return billingprovider;
	}
	public void setBillingprovider(String billingprovider) {
		this.billingprovider = billingprovider;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	@Override
	public String toString() {
		return "Charge [chargeid=" + chargeid + ", id=" + id + ", planname=" + planname + ", provider=" + provider
				+ ", billingprovider=" + billingprovider + ", total=" + total + ", getId()=" + getId()
				+ ", getPlanname()=" + getPlanname() + ", getProvider()=" + getProvider() + ", getBillingprovider()="
				+ getBillingprovider() + ", getTotal()=" + getTotal() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
