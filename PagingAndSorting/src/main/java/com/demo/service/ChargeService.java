package com.demo.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.model.Charge;
import com.demo.viewmodel.ChargeViewModel;




@Service
public interface ChargeService {
	public Charge createCharge(Charge model);
	public Optional<Charge> getChargeById(String chargeid);
	ChargeViewModel ChargeDetails(String id, ChargeViewModel chargeview);


}
