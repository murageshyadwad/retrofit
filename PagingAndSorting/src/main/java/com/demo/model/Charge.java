package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "charge")
public class Charge {
	
	@Id
	private long chargeid;
	private long id;
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
	public Charge(long chargeid, long id, String planname, String provider, String billingprovider, double total) {
		super();
		this.chargeid = chargeid;
		this.id = id;
		this.planname = planname;
		this.provider = provider;
		this.billingprovider = billingprovider;
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Charge [chargeid=" + chargeid + ", id=" + id + ", planname=" + planname + ", provider=" + provider
				+ ", billingprovider=" + billingprovider + ", total=" + total + ", getChargeid()=" + getChargeid()
				+ ", getId()=" + getId() + ", getPlanname()=" + getPlanname() + ", getProvider()=" + getProvider()
				+ ", getBillingprovider()=" + getBillingprovider() + ", getTotal()=" + getTotal() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
