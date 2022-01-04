package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.service.MedicalEventService;

@RestController
@RequestMapping("api/event")
public class MedicalEventController {
	private MedicalEventService medicalEventService;

	public MedicalEventController(MedicalEventService medicalEventService) {
		super();
		this.medicalEventService = medicalEventService;
	}

	// build create MedicalEvent REST API
	@PostMapping
	public ResponseEntity<MedicalEvent> saveMedialEvent(@RequestBody MedicalEvent medicalEvent) {
		return new ResponseEntity<MedicalEvent>(medicalEventService.saveMedicalEvent(medicalEvent), HttpStatus.CREATED);
	}

	// build all accounts REST API
	@GetMapping
	public List<MedicalEvent> getAllMedialEvents() {
		return medicalEventService.getAllMedialEvents();
	}

	// build specific account with specific ID
	// http://localhost:8070/api/account/1
	@GetMapping("{id}")
	public ResponseEntity<MedicalEvent> getMedicalEventById(@PathVariable("id") long id) {
		return new ResponseEntity<MedicalEvent>(medicalEventService.getMedicalEventById(id), HttpStatus.OK);
	}
}
