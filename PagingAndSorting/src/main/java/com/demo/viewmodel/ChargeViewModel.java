package com.demo.viewmodel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChargeViewModel {
	@Id
	private long chargeid;
	
	private long id;
	private String name;
	private String city;
	private String planname;
	private String provider;
	private String billingprovider;
	private double total;
	
	public long getChargeid() {
		return chargeid;
	}
	public void setChargeid(long chargeid) {
		this.chargeid = chargeid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
}
