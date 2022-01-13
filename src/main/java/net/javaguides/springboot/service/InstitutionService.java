package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.repository.InstitutionRepository;

@Service
public class InstitutionService {
	@Autowired
	InstitutionRepository institutionRepository;

	public InstitutionRepository getRepository() {
		return institutionRepository;
	}

}
