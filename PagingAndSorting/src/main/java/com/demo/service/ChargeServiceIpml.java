package com.demo.service;

import java.util.Date;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Charge;
import com.demo.model.PatientModel;
import com.demo.repository.ChargeRepository;
import com.demo.util.Externalref;
import com.demo.util.GeneralUtil;
import com.demo.util.RetrofitConfig;
import com.demo.util.RetrofitService;
import com.demo.viewmodel.ChargeBalanceView;
import com.demo.viewmodel.ChargeViewModel;
import com.demo.viewmodel.PatientViewModel;

import retrofit2.Call;




@Service
public class ChargeServiceIpml implements ChargeService {
	
	
	
	
	@Autowired
	ChargeRepository repo;
	
	@Override
	public Charge createCharge(@RequestBody Charge cmodel) {
		Charge chargeDetails = ChargeDetails(cmodel.getId(),cmodel);
		//repo.save(model);
		//return model;
		
		return chargeDetails;
	}

	@Override
	public Charge getChargeById(long chargeid) {
		 
		
		//return repo.findById(chargeid);
		return repo.findById(chargeid);

	}
	
	@Override
	public Charge ChargeDetails(long id, Charge cmodel) {
		
		PatientViewModel patientviewmodel = null;
		//Charge charge = new Charge();
		try {
			
			RetrofitService retrofitcall = RetrofitConfig.createPatientServerService(RetrofitService.class);
			Call<PatientViewModel> patientDetails = retrofitcall.getPatientDetails(id);
			patientviewmodel = patientDetails.execute().body();
			System.out.println("id:"+patientviewmodel.getId());
			
			if(patientviewmodel!=null) {
			cmodel.setCity(patientviewmodel.getCity());
			cmodel.setName(patientviewmodel.getName());
			cmodel.setLname(patientviewmodel.getName());
			}
//			charge.setBillingprovider(cmodel.getBillingprovider());
//			charge.setChargeid(cmodel.getChargeid());
//			charge.setId(cmodel.getId());
//			charge.setPlanname(cmodel.getPlanname());
//			charge.setProvider(cmodel.getProvider());
//			charge.setTotal(cmodel.getTotal());
			
			repo.save(cmodel);

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return cmodel;
	}
	

	@Override
	public ChargeBalanceView saveChargeBalance(Charge model) {
		//Charge charge = getChargeById(charge.getNchargebalanceid());
		ChargeBalanceView chargeBalance = new ChargeBalanceView();
		chargeBalance.setCreatedon(new Date());
		chargeBalance.setDcharges(model.getTotal());
		chargeBalance.setDtotal(model.getTotal());

		String uchargebalanceid = GeneralUtil.getUUID1();
		chargeBalance.setUchargebalanceid(uchargebalanceid);
		chargeBalance.setNpatientid((int) model.getId());
		chargeBalance.setBillingprovider(model.getBillingprovider());
		chargeBalance.setNpaccountid((int) model.getId());
		chargeBalance.setNtransactionid((int) GeneralUtil.getUUID());
		chargeBalance.setTotalpaid(model.getTotal());
		
		//Externalref exreff = new Externalref();
		//chargeBalance.setEmrid(charge.getExternalref().getEmrid());
		//chargebal.setExternalref(chargeBalance);
		repo.save(chargeBalance);
		return chargeBalance;
	}}
