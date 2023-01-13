package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PatientExceptionController extends ResponseEntityExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(PatientExceptionController.class);
	

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String> exception(PatientNotFoundException ex) {
		// LOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<String>("Patient not found", HttpStatus.NOT_FOUND);
	}
}
