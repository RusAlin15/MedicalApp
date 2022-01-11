package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Clinic;
import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.model.PatientAccount;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserService;

@RestController
@RequestMapping("/api/account")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/patient")
	public ResponseEntity<PatientAccount> savePatientAcoount(@RequestBody PatientAccount patientAccount) {
		return new ResponseEntity<PatientAccount>(userService.savePatientAcoount(patientAccount), HttpStatus.CREATED);
	}

	@PostMapping("/institution")
	public ResponseEntity<Institution> saveInstitution(@RequestBody Institution institution) {
		return new ResponseEntity<Institution>(userService.saveInstitution(institution), HttpStatus.CREATED);
	}

	@PostMapping("/clinic")
	public ResponseEntity<Clinic> saveClinic(@RequestBody Clinic clinic) {
		return new ResponseEntity<Clinic>(userService.saveClinic(clinic), HttpStatus.CREATED);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

//	@Transactional
//	@DeleteMapping()
//	public ResponseEntity<String> deleteAllUsers() {
//		UserService.deleteAllUsers();
//		return new ResponseEntity<String>("All patients successfuly deleted!", HttpStatus.OK);
//	}

}
