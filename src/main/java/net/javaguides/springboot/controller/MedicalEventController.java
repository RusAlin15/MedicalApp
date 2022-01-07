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

	@PostMapping()
	public ResponseEntity<MedicalEvent> saveMedicalEvent(@RequestBody MedicalEvent medicalEvent) {
		return new ResponseEntity<MedicalEvent>(medicalEventService.saveMedicalEvent(medicalEvent), HttpStatus.CREATED);
	}

	@PutMapping("institution/{eventId}/{institutionId}")
	public ResponseEntity<MedicalEvent> setInstitution(@PathVariable("eventId") long eventId,
			@PathVariable("institutionId") long institutionId) {
		return new ResponseEntity<MedicalEvent>(medicalEventService.setInstitution(eventId, institutionId),
				HttpStatus.OK);
	}

	@PutMapping("speciality/{eventId}/{specialityId}")
	public ResponseEntity<MedicalEvent> setSpeciality(@PathVariable("eventId") long eventId,
			@PathVariable("specialityId") long specialityId) {
		return new ResponseEntity<MedicalEvent>(medicalEventService.setSpeciality(eventId, specialityId),
				HttpStatus.OK);
	}

	@PutMapping("stage/{eventId}/{stageId}")
	public ResponseEntity<MedicalEvent> setStage(@PathVariable("eventId") long eventId,
			@PathVariable("stageId") long stageId) {
		return new ResponseEntity<MedicalEvent>(medicalEventService.setStage(eventId, stageId), HttpStatus.OK);
	}

	@PutMapping("doctor/{eventId}/{doctorId}")
	public ResponseEntity<MedicalEvent> setDoctor(@PathVariable("eventId") long eventId,
			@PathVariable("doctorId") long doctorId) {
		return new ResponseEntity<MedicalEvent>(medicalEventService.setDoctor(eventId, doctorId), HttpStatus.OK);
	}

	@GetMapping
	public List<MedicalEvent> getAllMedialEvents() {
		return medicalEventService.getAllMedialEvents();
	}

	@GetMapping("{id}")
	public ResponseEntity<MedicalEvent> getMedicalEventById(@PathVariable("id") long id) {
		return new ResponseEntity<MedicalEvent>(medicalEventService.getMedicalEventById(id), HttpStatus.OK);
	}
}
