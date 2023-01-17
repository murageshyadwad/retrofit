package com.demo.viewmodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.demo.util.Externalref;

@Entity
@Table(name = "bl_calbal_chargebalance")
public class ChargeBalanceView {
	
	public ChargeBalanceView() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private String uchargebalanceid;
	private Integer nchargebalanceid; 
    private Integer npaccountid; 
    private Integer npatientid; 
    private Integer nclaimno;  
    private Integer ntransactionid; 
    private double dcharges; 
    private double dtotal; 
    private double totalinsurancepaid; 
    private double totalpaid; 
    private double totalbalanceamount; 
    private String planname; 
    private String billingprovider; 
    private Date createdon; 
    private Date lastmodifiedon; 
    private String tenantid; 
//    @Type(type = "json")
//	@Column(name = "externalref")
//	Externalref externalref;
    
   public String getUchargebalanceid() {
		return uchargebalanceid;
	}
	public void setUchargebalanceid(String uchargebalanceid) {
		this.uchargebalanceid = uchargebalanceid;
	}
	public Integer getNchargebalanceid() {
		return nchargebalanceid;
	}
	public void setNchargebalanceid(Integer nchargebalanceid) {
		this.nchargebalanceid = nchargebalanceid;
	}
	public Integer getNpaccountid() {
		return npaccountid;
	}
	public void setNpaccountid(Integer npaccountid) {
		this.npaccountid = npaccountid;
	}
	public Integer getNpatientid() {
		return npatientid;
	}
	public void setNpatientid(Integer npatientid) {
		this.npatientid = npatientid;
	}
	public Integer getNclaimno() {
		return nclaimno;
	}
	public void setNclaimno(Integer nclaimno) {
		this.nclaimno = nclaimno;
	}
	public Integer getNtransactionid() {
		return ntransactionid;
	}
	public void setNtransactionid(Integer ntransactionid) {
		this.ntransactionid = ntransactionid;
	}
	public double getDcharges() {
		return dcharges;
	}
	public void setDcharges(double dcharges) {
		this.dcharges = dcharges;
	}
	public double getDtotal() {
		return dtotal;
	}
	public void setDtotal(double dtotal) {
		this.dtotal = dtotal;
	}
	public double getTotalinsurancepaid() {
		return totalinsurancepaid;
	}
	public void setTotalinsurancepaid(double totalinsurancepaid) {
		this.totalinsurancepaid = totalinsurancepaid;
	}
	public double getTotalpaid() {
		return totalpaid;
	}
	public void setTotalpaid(double totalpaid) {
		this.totalpaid = totalpaid;
	}
	public double getTotalbalanceamount() {
		return totalbalanceamount;
	}
	public void setTotalbalanceamount(double totalbalanceamount) {
		this.totalbalanceamount = totalbalanceamount;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getBillingprovider() {
		return billingprovider;
	}
	public void setBillingprovider(String billingprovider) {
		this.billingprovider = billingprovider;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	public Date getLastmodifiedon() {
		return lastmodifiedon;
	}
	public void setLastmodifiedon(Date lastmodifiedon) {
		this.lastmodifiedon = lastmodifiedon;
	}
	public String getTenantid() {
		return tenantid;
	}
	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}
//	public Externalref getExternalref() {
//		return externalref;
//	}
//	public void setExternalref(Externalref externalref) {
//		this.externalref = externalref;
//	}
	
	public ChargeBalanceView(String uchargebalanceid, Integer nchargebalanceid, Integer npaccountid, Integer npatientid,
			Integer nclaimno, Integer ntransactionid, double dcharges, double dtotal, double totalinsurancepaid,
			double totalpaid, double totalbalanceamount, String planname, String billingprovider, Date createdon,
			Date lastmodifiedon, String tenantid, Externalref externalref) {
		super();
		this.uchargebalanceid = uchargebalanceid;
		this.nchargebalanceid = nchargebalanceid;
		this.npaccountid = npaccountid;
		this.npatientid = npatientid;
		this.nclaimno = nclaimno;
		this.ntransactionid = ntransactionid;
		this.dcharges = dcharges;
		this.dtotal = dtotal;
		this.totalinsurancepaid = totalinsurancepaid;
		this.totalpaid = totalpaid;
		this.totalbalanceamount = totalbalanceamount;
		this.planname = planname;
		this.billingprovider = billingprovider;
		this.createdon = createdon;
		this.lastmodifiedon = lastmodifiedon;
		this.tenantid = tenantid;
		//this.externalref = externalref;
	}
	

}
