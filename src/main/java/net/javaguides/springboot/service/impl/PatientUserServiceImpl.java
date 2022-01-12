package net.javaguides.springboot.service.impl;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.repository.PatientUserRepository;
import net.javaguides.springboot.service.PatientUserService;

@Service
public class PatientUserServiceImpl implements PatientUserService {
	private PatientUserRepository patientUserRepository;

	public PatientUserServiceImpl(PatientUserRepository patientUserRepository) {
		super();
		this.patientUserRepository = patientUserRepository;
	}

	@Override
	public PatientUserRepository getRepository() {
		return this.patientUserRepository;
	}

}
