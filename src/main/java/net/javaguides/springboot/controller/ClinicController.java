package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.service.ClinicService;

@RestController
@RequestMapping("/api/clinic")
public class ClinicController {
	@Autowired
	private ClinicService clinicService;

}
