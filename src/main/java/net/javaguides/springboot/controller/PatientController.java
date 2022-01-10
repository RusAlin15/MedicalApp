package net.javaguides.springboot.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@PostMapping()
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		return new ResponseEntity<Patient>(patientService.savePatient(patient), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

//	// build create doctor REST API
//	@PostMapping("doctor/{institutionId}/{specialityId}")
//	public ResponseEntity<UserAccount> saveDoctor(@RequestBody Doctor doctor, @PathVariable long institutionId,
//			@PathVariable long specialityId) {
//		return new ResponseEntity<UserAccount>(UserAccountAccountService.saveDoctor(doctor, institutionId, specialityId),
//				HttpStatus.CREATED);
//	}

	@PutMapping("/{patientId}/{eventId}")
	public ResponseEntity<Patient> addEvent(@PathVariable("patientId") long patientId,
			@PathVariable("eventId") long eventId) {
		return new ResponseEntity<Patient>(patientService.addEvent(patientId, eventId), HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping()
	public ResponseEntity<String> deleteAllPatients() {
		patientService.getAllPatients();
		return new ResponseEntity<String>("All patients successfuly deleted!", HttpStatus.OK);
	}

}
