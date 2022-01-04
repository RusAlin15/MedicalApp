package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.repository.InstitutionRepository;
import net.javaguides.springboot.service.InstitutionService;

@Service
public class InstitutionServiceImpl implements InstitutionService {
	private InstitutionRepository institutionRepository;

	public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
		super();
		this.institutionRepository = institutionRepository;
	}

	@Override
	public Institution saveInstitution(Institution institution) {
		return institutionRepository.save(institution);
	}

	@Override
	public List<Institution> getAllInstitutions() {
		return institutionRepository.findAll();
	}

	@Override
	public void deleteAllInstitutions() {
		institutionRepository.deleteAll();
	}

}
