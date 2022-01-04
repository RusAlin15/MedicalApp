package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.speciality.Speciality;
import net.javaguides.springboot.service.SpecialityService;

@RestController
@RequestMapping("api/speciality")

public class SpecialityController {
	private SpecialityService specialityService;

	public SpecialityController(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	// build create MedicalEvent REST API
	@PostMapping
	public ResponseEntity<Speciality> saveSpeciality(@RequestBody Speciality speciality) {
		return new ResponseEntity<>(specialityService.saveSpeciality(speciality), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Speciality> getAllSpecialities() {
		return specialityService.getAllSpecialities();
	}
}
