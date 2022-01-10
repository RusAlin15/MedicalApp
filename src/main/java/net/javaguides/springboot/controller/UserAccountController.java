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

import net.javaguides.springboot.model.InstitutionAccount;
import net.javaguides.springboot.model.PatientAccount;
import net.javaguides.springboot.model.UserAccount;
import net.javaguides.springboot.service.UserAccountService;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {

	private UserAccountService userAccountService;

	public UserAccountController(UserAccountService userAccountService) {
		super();
		this.userAccountService = userAccountService;
	}

	@PostMapping("/patient")
	public ResponseEntity<PatientAccount> savePatientAcoount(@RequestBody PatientAccount patientAccount) {
		return new ResponseEntity<PatientAccount>(userAccountService.savePatientAcoount(patientAccount),
				HttpStatus.CREATED);
	}

	@GetMapping
	public List<UserAccount> getAllUserAccounts() {
		return userAccountService.getAllUserAccounts();
	}

	@PostMapping("/institution")
	public ResponseEntity<InstitutionAccount> saveInstitutionAccount(
			@RequestBody InstitutionAccount institutionAccount) {
		return new ResponseEntity<InstitutionAccount>(userAccountService.saveInstitutionAccount(institutionAccount),
				HttpStatus.CREATED);
	}

//	// build create doctor REST API
//	@PostMapping("doctor/{institutionId}/{specialityId}")
//	public ResponseEntity<UserAccount> saveDoctor(@RequestBody Doctor doctor, @PathVariable long institutionId,
//			@PathVariable long specialityId) {
//		return new ResponseEntity<UserAccount>(UserAccountAccountService.saveDoctor(doctor, institutionId, specialityId),
//				HttpStatus.CREATED);
//	}

	@PutMapping("/patient/{accountId}/{patientId}")
	public ResponseEntity<UserAccount> addPatient(@PathVariable("accountId") long accountId,
			@PathVariable("patientId") long patientId) {
		return new ResponseEntity<UserAccount>(userAccountService.addPatient(accountId, patientId), HttpStatus.OK);
	}

	@PutMapping("/institution/{accountId}/{clinicId}")
	public ResponseEntity<UserAccount> addClinic(@PathVariable("accountId") long accountId,
			@PathVariable("clinicId") long clinicId) {
		return new ResponseEntity<UserAccount>(userAccountService.addClinic(accountId, clinicId), HttpStatus.OK);
	}

//	@Transactional
//	@DeleteMapping()
//	public ResponseEntity<String> deleteAllUserAccounts() {
//		UserAccountAccountService.deleteAllUserAccounts();
//		return new ResponseEntity<String>("All patients successfuly deleted!", HttpStatus.OK);
//	}

}
