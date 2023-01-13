package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.model.Charge;
import com.demo.model.PatientModel;
import com.demo.repository.ChargeRepository;
import com.demo.util.RetrofitConfig;
import com.demo.util.RetrofitService;
import com.demo.viewmodel.ChargeViewModel;

import retrofit2.Call;




@Service
public class ChargeServiceIpml implements ChargeService {
	
	
	
	
	@Autowired
	ChargeRepository repo;
	
	@Override
	public Charge createCharge(@RequestBody Charge model) {
		return repo.save(model);
	}

	@Override
	public Optional<Charge> getChargeById(String chargeid) {
		
		return repo.findById(Long.parseLong(chargeid));

	}
	
	@Override
	public ChargeViewModel ChargeDetails(String id, ChargeViewModel chargeview) {
		
		PatientModel patientmodel = null;
		ChargeViewModel aptTemp = new ChargeViewModel();
		try {
			
			RetrofitService retrofitcall = RetrofitConfig.createPatientServerService(RetrofitService.class);
			Call<PatientModel> patientDetails = retrofitcall.getPatientDetails(id);
			patientmodel = patientDetails.execute().body();
	

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return aptTemp;
	}

}
