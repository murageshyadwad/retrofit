package com.demo.controller;

import java.io.BufferedReader;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.PatientModel;
import com.demo.model.PatientPage;
import com.demo.service.PatientDetails;
import com.demo.service.PatientService;
import com.demo.model.PatientPage;

@RestController
//@CacheConfig(cacheNames={"patient"})
public class PatientController  {

	@Autowired
	PatientService patientService;

	@Autowired
	PatientDetails patientDetails;
	

	/*
	 * @PostMapping("/patient") public ResponseEntity<?> createPatient(@RequestBody
	 * PatientModel model) { String id = patientService.createPatient(model); if (id
	 * != null) { return new ResponseEntity<>(id, HttpStatus.OK); } return new
	 * ResponseEntity<>(id, HttpStatus.NO_CONTENT); }
	 */
	private static final Logger log = LoggerFactory.getLogger(PatientExceptionController.class);

	@GetMapping("/patients")
	@Test

	public ResponseEntity<Page<PatientModel>> listPatients(PatientPage patientPage) {
		ResponseEntity response = null;
		try {
			log.info("Fetching Data");
			Page<PatientModel> PatientRetrieved = patientService.listPatients(patientPage);
			
			response = new ResponseEntity<>(PatientRetrieved, HttpStatus.OK);
		} catch (Exception ex) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			System.out.println(ex.toString());
		}
		return response;
	}

	@PostMapping("/createPatient")
	public ResponseEntity<?> createPatient(@RequestBody PatientModel model) {
		return new ResponseEntity<PatientModel>(patientService.createPatient(model), HttpStatus.OK);

	}

	@GetMapping("/patient/{patientid}")
	//@Cacheable(value = "patient")
	// @CacheEvict(value="patient")
	
	public ResponseEntity<PatientModel> getPatientById(@ModelAttribute("name") PatientModel model ,@PathVariable("patientid") String id) {
		PatientModel PatientRetrieved = patientService.getPatientById(id);
		HttpServletResponse response = null;
		//cookie
		Cookie ck = new Cookie("PatientName",model.getName() );
		ck.setMaxAge(60*60*24);
		response.addCookie(ck);
		
		// log.info("Retrieved Patient:", PatientRetrieved);
		if (PatientRetrieved == null) {
			throw new PatientNotFoundException();
		} else {
			return new ResponseEntity<PatientModel>(PatientRetrieved, HttpStatus.FOUND);
		}
	}

	@PutMapping("/patient/{patientid}")
	@CachePut(value = "patient")
	public ResponseEntity<PatientModel> updatePatient(@RequestBody PatientModel model,
			@PathVariable("patientid") String id) {
		PatientModel patientSaved = patientService.updatePatient(model);
		return new ResponseEntity<PatientModel>(HttpStatus.CREATED);

	}

	@DeleteMapping("/patient/{patientid}")
	@CacheEvict(value = "patient")
	public ResponseEntity<String> DeletePatientById(@PathVariable("patientid") String id) {
		// Logger.debug("Entering delete patient endpoint");
		try {
			patientService.deletePatient(id);
			// logger.info("Patient with id :" +id+"is deleted.");
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			// logger.error("Unable to delete patient :" +id+e.getMessage());
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

	// store procedure

	@GetMapping("/allpatients")

	public List<PatientModel> getAllPatient(@RequestBody PatientPage page) {
		return patientDetails.getAllPatient(page);
	}

	@GetMapping("/convert")
	public String convertFileToByteArray() throws FileNotFoundException {
		File file = new File("C:\\Users\\Murgesh\\OneDrive - Triarq Health\\Desktop\\My\\samplejson.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		// Creates OutputStream
		
		System.out.println(br);
		String st = null;

		try {
			while ((st = br.readLine()) != null)

				// Print the string
				System.out.println(st);
			
			byte[] array = st.getBytes();

			// Write data to OutputStream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.write(array);
			byte bytes[] = baos.toByteArray();

			System.out.println("Print output:");

			for (int x = 0; x < bytes.length; x++) {
				// Print original characters
				System.out.print((char) bytes[x] + "");
			}
			System.out.println("   ");
	
		}catch(

	IOException e)
	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return st;
}
	
	

}