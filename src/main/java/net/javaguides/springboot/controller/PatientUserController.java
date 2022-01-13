package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.service.PatientUserService;

@RestController
@RequestMapping("/api/account/patient")
public class PatientUserController {
	@Autowired
	private PatientUserService patientUserService;

	public PatientUserController(PatientUserService patientUserService) {
		super();
		this.patientUserService = patientUserService;
	}

}
