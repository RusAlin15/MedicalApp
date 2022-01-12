package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.service.ClinicService;

@RestController
@RequestMapping("/api/clinic")
public class ClinicController {
	private ClinicService clinicService;

	public ClinicController(ClinicService clinicService) {
		super();
		this.clinicService = clinicService;
	}

}
