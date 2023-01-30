package com.pd.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.binding.CitizenBinding;
import com.pd.service.CitizenService;

@RestController
public class CitizenRestController {

	@Autowired
	private CitizenService service;

	@PostMapping("/createCitizen")
	public ResponseEntity<String> crateCitizen(@RequestBody 
			CitizenBinding citizenBinding) {
		String status = service.createCitizen(citizenBinding);
		return new ResponseEntity<>(status, HttpStatus.OK);

	}
}
