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

import net.javaguides.springboot.dto.MedicalEventDTO;
import net.javaguides.springboot.facade.MedicalEventFacade;

@RestController
@RequestMapping("event")
public class MedicalEventController {

	@Autowired
	private MedicalEventFacade eventFacade;

	@PostMapping()
	public ResponseEntity<MedicalEventDTO> saveEvent(@RequestBody MedicalEventDTO eventDTO) {
		return new ResponseEntity<MedicalEventDTO>(eventFacade.saveEvent(eventDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<MedicalEventDTO> updateEvent(@PathVariable("eventId") long eventId,
			@RequestBody MedicalEventDTO eventDTO) {
		return new ResponseEntity<MedicalEventDTO>(eventFacade.updateEvent(eventId, eventDTO), HttpStatus.OK);
	}

	@GetMapping("{eventId}")
	public ResponseEntity<MedicalEventDTO> getEventById(@PathVariable("eventId") long eventId) {
		return new ResponseEntity<MedicalEventDTO>(eventFacade.getEventById(eventId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<MedicalEventDTO>> getAllEvents() {
		return new ResponseEntity<List<MedicalEventDTO>>(eventFacade.getAllEvents(), HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping("{eventId}")
	public ResponseEntity<String> deleteEventById(@PathVariable("eventId") long eventId) {
		eventFacade.deleteEventById(eventId);
		return new ResponseEntity<String>("Medical events successfuly deleted!", HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping
	public ResponseEntity<String> deleteAllEvents() {
		eventFacade.deleteAllEvents();
		return new ResponseEntity<String>("Medical events successfuly deleted!", HttpStatus.OK);
	}
}
