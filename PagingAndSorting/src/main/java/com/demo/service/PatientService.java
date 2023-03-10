package com.demo.service;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.demo.model.PatientModel;
import com.demo.model.PatientPage;


@Service
public interface PatientService {
	
	public PatientModel createPatient(PatientModel model);
	public Page<PatientModel> listPatients(PatientPage patientPage);
	public PatientModel getPatientById(long id);
	public PatientModel updatePatient(PatientModel model);
	public String deletePatient(long id);
	public String getDate();
}
