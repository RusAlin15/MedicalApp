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

import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.service.InstitutionService;

@RestController
@RequestMapping("api/institution")
public class InstitutionController {
	private InstitutionService institutionService;

	public InstitutionController(InstitutionService institutionService) {
		super();
		this.institutionService = institutionService;
	}

	@PostMapping()
	public ResponseEntity<Institution> saveInstitution(@RequestBody Institution institution) {
		return new ResponseEntity<Institution>(institutionService.saveInstitution(institution), HttpStatus.CREATED);
	}

	@PutMapping("/account/{accountId}/{institutionId}")
	public ResponseEntity<Institution> setInstitutionAccount(@PathVariable("accountId") long accountId,
			@PathVariable("institutionId") long institutionId) {
		return new ResponseEntity<Institution>(institutionService.setInstitutionAccount(accountId, institutionId),
				HttpStatus.OK);
	}

	@GetMapping()
	public List<Institution> getAllInstitutions() {
		return institutionService.getAllInstitutions();
	}
}
