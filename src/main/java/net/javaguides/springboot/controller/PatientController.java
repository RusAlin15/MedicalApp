package net.javaguides.springboot.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping()
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		return new ResponseEntity<Patient>(patientService.savePatient(patient), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/{cnp}")
	public ResponseEntity<Patient> findByCnp(@PathVariable String cnp) {

		return new ResponseEntity<Patient>(patientService.findByCnp(cnp), HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping()
	public ResponseEntity<String> deleteAllPatients() {
		patientService.getAllPatients();
		return new ResponseEntity<String>("All patients successfuly deleted!", HttpStatus.OK);
	}

}
