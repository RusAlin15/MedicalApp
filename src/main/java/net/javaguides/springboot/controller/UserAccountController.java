package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.UserAccount;
import net.javaguides.springboot.service.userAccountService;

@RestController
@RequestMapping("/api/user")
public class UserAccountController {

	private userAccountService userAccountService;

	public UserAccountController(userAccountService userAccountService) {
		super();
		this.userAccountService = userAccountService;
	}

	// build create patient REST API
	@PostMapping("/patient")
	public ResponseEntity<UserAccount> savePatient(@RequestBody Patient patient) {
		return new ResponseEntity<UserAccount>(userAccountService.savePatient(patient), HttpStatus.CREATED);
	}

//	// build create doctor REST API
//	@PostMapping("doctor/{institutionId}/{specialityId}")
//	public ResponseEntity<UserAccount> saveDoctor(@RequestBody Doctor doctor, @PathVariable long institutionId,
//			@PathVariable long specialityId) {
//		return new ResponseEntity<UserAccount>(UserAccountAccountService.saveDoctor(doctor, institutionId, specialityId),
//				HttpStatus.CREATED);
//	}

	@PutMapping("event/{patientId}/{eventId}")
	public ResponseEntity<UserAccount> addEvent(@PathVariable("patientId") long patientId,
			@PathVariable("eventId") long eventId) {
		return new ResponseEntity<UserAccount>(userAccountService.addEvent(patientId, eventId), HttpStatus.OK);
	}

	@GetMapping
	public List<UserAccount> getAllUserAccounts() {
		return userAccountService.getAllUserAccounts();
	}

//	@Transactional
//	@DeleteMapping()
//	public ResponseEntity<String> deleteAllUserAccounts() {
//		UserAccountAccountService.deleteAllUserAccounts();
//		return new ResponseEntity<String>("All patients successfuly deleted!", HttpStatus.OK);
//	}

}
