package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Status;
import net.javaguides.springboot.service.StatusService;

@RestController
@RequestMapping("api/status")
public class StatusController {

	private StatusService statusService;

	public StatusController(StatusService statusService) {
		super();
		this.statusService = statusService;
	}

	@PostMapping
	public ResponseEntity<Status> saveStatus(@RequestBody Status status) {
		return new ResponseEntity<Status>(statusService.saveStatus(status), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Status> getAllStatuses() {
		return statusService.getAllStatuses();
	}
}
