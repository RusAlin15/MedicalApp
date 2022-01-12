package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.service.PatientUserService;

@RestController
@RequestMapping("/api/account/patient")
public class PatientUserController {
	private PatientUserService patientUserService;
	private Patient patient;

	public PatientUserController(PatientUserService patientUserService) {
		super();
		this.patientUserService = patientUserService;
	}

}
