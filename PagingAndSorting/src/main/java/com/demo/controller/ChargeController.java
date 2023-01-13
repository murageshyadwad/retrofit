package com.demo.controller;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Charge;

import com.demo.service.ChargeService;



@RestController
public class ChargeController {
	
	
	@Autowired
	ChargeService chargeService;
	
	@PostMapping("/createCharge")
	public ResponseEntity<?> createPatient(@RequestBody Charge model) {
		return new ResponseEntity<Charge>(chargeService.createCharge(model), HttpStatus.OK);

	}
	
	
	public ResponseEntity<Charge> getPatientById(@ModelAttribute("name") Charge model ,@PathVariable("chargeid") String chargeid) {
		Charge PatientRetrieved = chargeService.getChargeById(chargeid);
		HttpServletResponse response = null;
		return new ResponseEntity<Charge>(PatientRetrieved, HttpStatus.FOUND);
		
	
	}

}
