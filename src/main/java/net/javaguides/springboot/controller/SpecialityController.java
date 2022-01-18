package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.SpecialityDto;
import net.javaguides.springboot.model.Speciality;
import net.javaguides.springboot.service.SpecialityService;

@RestController
@RequestMapping("api/speciality")

public class SpecialityController {
	@Autowired
	private SpecialityService specialityService;

	@PostMapping
	public ResponseEntity<SpecialityDto> saveSpeciality(@RequestBody Speciality speciality) {
		return new ResponseEntity<>(specialityService.saveSpeciality(speciality), HttpStatus.CREATED);
	}

	@GetMapping
	public List<SpecialityDto> getAllSpecialities() {
		return specialityService.getAllSpecialities();
	}
}
