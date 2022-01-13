package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.repository.ClinicRepository;

@Service
public class ClinicService {
	@Autowired
	private ClinicRepository clinicRepository;

	public ClinicRepository getRepository() {
		return this.clinicRepository;
	}

}
