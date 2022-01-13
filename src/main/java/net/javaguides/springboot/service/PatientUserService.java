package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.repository.PatientUserRepository;

@Service
public class PatientUserService {
	@Autowired
	private PatientUserRepository patientUserRepository;

	public PatientUserRepository getRepository() {
		return this.patientUserRepository;
	}

}
