package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Speciality;
import net.javaguides.springboot.repository.SpecialityRepository;
import net.javaguides.springboot.service.SpecialityService;

@Service
public class SpecialityServiceImpl implements SpecialityService {
	SpecialityRepository specialityRepository;

	public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Speciality saveSpeciality(Speciality speciality) {
		return specialityRepository.save(speciality);
	}

	@Override
	public List<Speciality> getAllSpecialities() {
		return specialityRepository.findAll();
	}

	public SpecialityRepository getSpecialityRepository() {
		return specialityRepository;
	}

}
