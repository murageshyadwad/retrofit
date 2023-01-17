package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Charge;

import com.demo.service.ChargeService;
import com.demo.viewmodel.ChargeBalanceView;
import com.demo.viewmodel.PatientViewModel;



@RestController
public class ChargeController {
	
	
	@Autowired
	ChargeService chargeService;
	
	@PostMapping("/createCharge")
	public ResponseEntity<?> createPatient(@RequestBody Charge model) {
		
//		PatientViewModel response = null;
//			RestTemplate restTemplate = new RestTemplate();
//			String url = "http://localhost:8081/patient/"+model.getId();
//			System.out.println(url);
//			response=restTemplate.getForObject(url, PatientViewModel.class);
//			System.out.println(response.getName());
//			
//			model.setName(response.getName());
//			model.setCity(response.getCity());
//			model.setLname(response.getName());
			
			Charge createCharge = chargeService.createCharge(model);
			chargeService.saveChargeBalance(model);
		return new ResponseEntity<Charge>(createCharge, HttpStatus.OK);
		

	}
	
	
	@GetMapping("/getCharge/{id}")
	public ResponseEntity<Charge> getPatientById(@PathVariable("id") long id) {
		Charge PatientRetrieved = chargeService.getChargeById(id);
		//ChargeViewModel chargeview = new ChargeViewModel();
		//////chargeService.ChargeDetails(id, PatientRetrieved);
		
		//HttpServletResponse response = null;
		//return new ResponseEntity<PatientRetrieved>(HttpStatus.FOUND);
		return new ResponseEntity<Charge>(PatientRetrieved,HttpStatus.OK);
		
	
	}

	
	

}
