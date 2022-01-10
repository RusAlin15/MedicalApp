package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.ClinicAccount;
import net.javaguides.springboot.model.DoctorAccount;
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

	@PostMapping("/institution")
	public ResponseEntity<InstitutionAccount> saveInstitutionAccount(
			@RequestBody InstitutionAccount institutionAccount) {
		return new ResponseEntity<InstitutionAccount>(userAccountService.saveInstitutionAccount(institutionAccount),
				HttpStatus.CREATED);
	}

	@PostMapping("/clinic")
	public ResponseEntity<ClinicAccount> saveClinicAccount(@RequestBody ClinicAccount clinicAccount) {
		return new ResponseEntity<ClinicAccount>(userAccountService.saveClinicAccount(clinicAccount),
				HttpStatus.CREATED);
	}

	@PostMapping("/doctor")
	public ResponseEntity<DoctorAccount> saveDoctorAccount(@RequestBody DoctorAccount doctorAccount) {
		return new ResponseEntity<DoctorAccount>(userAccountService.saveDoctorAccount(doctorAccount),
				HttpStatus.CREATED);
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
