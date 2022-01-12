package net.javaguides.springboot.service.impl;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.repository.InstitutionRepository;
import net.javaguides.springboot.service.InstitutionService;

@Service
public class InstitutionServiceImpl implements InstitutionService {
	InstitutionRepository institutionRepository;

	public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
		super();
		this.institutionRepository = institutionRepository;
	}

	@Override
	public InstitutionRepository getRepository() {
		return institutionRepository;
	}

}
