package net.javaguides.springboot.service.impl;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.repository.ClinicRepository;
import net.javaguides.springboot.service.ClinicService;

@Service
public class ClinicServiceImpl implements ClinicService {
	private ClinicRepository clinicRepository;

	public ClinicServiceImpl(ClinicRepository clinicRepository) {
		super();
		this.clinicRepository = clinicRepository;
	}

	@Override
	public ClinicRepository getRepository() {
		return this.clinicRepository;
	}

}
