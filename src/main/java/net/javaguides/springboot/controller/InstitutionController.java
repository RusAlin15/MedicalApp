package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.service.InstitutionService;

@RestController
@RequestMapping("/api/institution")
public class InstitutionController {
	private InstitutionService institutionService;

	public InstitutionController(InstitutionService institutionService) {
		super();
		this.institutionService = institutionService;
	}

}
