package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.MedicalEventDto;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.service.MedicalEventService;

@RestController
@RequestMapping("api/event")
public class MedicalEventController {
	@Autowired
	private MedicalEventService medicalEventService;

	@PostMapping()
	public ResponseEntity<MedicalEventDto> saveMedicalEvent(@RequestBody MedicalEvent medicalEvent) {
		return new ResponseEntity<MedicalEventDto>(medicalEventService.saveMedicalEvent(medicalEvent),
				HttpStatus.CREATED);
	}

	@GetMapping
	public List<MedicalEventDto> getAllMedialEvents() {
		return medicalEventService.getAllMedialEvents();
	}

	@GetMapping("{id}")
	public ResponseEntity<MedicalEventDto> getMedicalEventById(@PathVariable("id") long id) {
		return new ResponseEntity<MedicalEventDto>(medicalEventService.getMedicalEventById(id), HttpStatus.OK);
	}
}
