package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Speciality;
import net.javaguides.springboot.repository.SpecialityRepository;

@Service
public class SpecialityService {
	@Autowired
	SpecialityRepository specialityRepository;

	public Speciality saveSpeciality(Speciality speciality) {
		return specialityRepository.save(speciality);
	}

	public List<Speciality> getAllSpecialities() {
		return specialityRepository.findAll();
	}
}
