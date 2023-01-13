package com.demo.service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import javax.persistence.Cacheable;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;

import com.demo.controller.PatientExceptionController;
import com.demo.controller.PatientNotFoundException;
import com.demo.model.PatientModel;
import com.demo.model.PatientPage;
import com.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository repository;

	@Override
	public PatientModel createPatient(@RequestBody PatientModel model) {
		return repository.save(model);
	}
	
	


	@Override
	public Page<PatientModel> listPatients(PatientPage patientPage) {
		Sort sort = Sort.by(patientPage.getSortDirection(), patientPage.getSortBy());
		Pageable pageable = PageRequest.of(patientPage.getPageNumber(), patientPage.getPageSize(), sort);
		System.out.println("from database");
		return repository.findAll(pageable);
	}

	@Override
	public PatientModel getPatientById(String id) {
		System.out.println("called from db");
		return repository.findByid(Long.parseLong(id));

	}
	@Override
	public String deletePatient(String id) {
		
		 repository.deleteById(Long.parseLong(id));
		 return id;
	}

	@Override
	public PatientModel updatePatient(PatientModel model) {
		
		return repository.save(model);
	}




	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
//	@Scheduled(fixedRate = 5000,fixedDelay=2000)
//	public void saveData() {
//		PatientModel model = new PatientModel();
//		model.setName("Andy");
//		model.setCity("pune");
//		model.setZip("591304");
//		model.setLname("A");
//		repository.save(model);
//	}
//	
//	@Scheduled(cron="0/15 * * * * *")
//	public void getData() {
//		List<PatientModel> findAll = (List<PatientModel>) repository.findAll();
//		System.out.println("fetched data from Database");
//		System.out.println(findAll);
//	}

}