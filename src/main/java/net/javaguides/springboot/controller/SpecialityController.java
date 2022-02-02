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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.SpecialityDTO;
import net.javaguides.springboot.facade.SpecialityFacade;

@RestController
@RequestMapping("speciality")
public class SpecialityController {

	@Autowired
	private SpecialityFacade specialityFacade;

	@PostMapping
	public ResponseEntity<SpecialityDTO> saveSpeciality(@RequestBody SpecialityDTO specialityDTO) {
		return new ResponseEntity<SpecialityDTO>(specialityFacade.saveSpeciality(specialityDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{specialityId}")
	public ResponseEntity<SpecialityDTO> updateSpeciality(@PathVariable("specialityId") long specialityId,
			@RequestBody SpecialityDTO specialityDTO) {
		return new ResponseEntity<SpecialityDTO>(specialityFacade.updateSpeciality(specialityId, specialityDTO),
				HttpStatus.CREATED);
	}

	@GetMapping("/{specialityId}")
	public ResponseEntity<SpecialityDTO> getSpecialityById(@PathVariable("specialityId") long specialityId) {
		return new ResponseEntity<SpecialityDTO>(specialityFacade.getSpecialityById(specialityId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<SpecialityDTO>> getAllSpecialities() {
		return new ResponseEntity<List<SpecialityDTO>>(specialityFacade.getAllSpecialities(), HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping("/{specialityId}")
	public ResponseEntity<String> deleteSpecialityById(@PathVariable("specialityId") long specialityId) {
		return new ResponseEntity<String>("Speciality succesfuly deleted!", HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping()
	public ResponseEntity<String> deleteAllSpecialities() {
		specialityFacade.deleteAllSpecialities();
		return new ResponseEntity<String>("Specialities succesfuly deleted!", HttpStatus.OK);
	}
}
