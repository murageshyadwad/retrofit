package com.demo.service;


import org.springframework.stereotype.Service;

import com.demo.model.Charge;
import com.demo.viewmodel.ChargeBalanceView;




@Service
public interface ChargeService {
	public Charge createCharge(Charge model);
	public Charge getChargeById(long chargeid);
	//ChargeViewModel ChargeDetails(String id, Optional<Charge> patientRetrieved);
	//Charge getChargeById(Long chargeid);
	Charge ChargeDetails(long id,Charge  patientRetrieved);
	ChargeBalanceView saveChargeBalance(Charge model);
	//ChargeViewModel ChargeDetails(long id, ChargeViewModel PatientRetrieved);


}
