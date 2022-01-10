package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Clinic;
import net.javaguides.springboot.service.ClinicService;

@RestController
@RequestMapping("api/clinic")
public class ClinicController {
	private ClinicService clinicService;

	public ClinicController(ClinicService clinicService) {
		super();
		this.clinicService = clinicService;
	}

	@PostMapping
	public ResponseEntity<Clinic> saveClinic(@RequestBody Clinic clinic) {

		return new ResponseEntity<Clinic>(clinicService.saveClinic(clinic), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Clinic> getAllInstitutions() {
		return clinicService.getAllClinics();
	}

	@DeleteMapping
	public ResponseEntity<String> deleteAllClincs() {
		clinicService.deleteAllClincs();
		return new ResponseEntity<String>("All clinics successfuly deleted!", HttpStatus.OK);
	}
}
