package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
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

	public Speciality updateSpeciality(long specialityId, Speciality speciality) {
		Speciality speciality2Update = getSpecialityById(specialityId);

		speciality2Update.setId(speciality.getId());
		speciality2Update.setSpecialityName(speciality.getSpecialityName());

		return specialityRepository.saveAndFlush(speciality2Update);
	}

	public Speciality getSpecialityById(long specialityId) {
		return specialityRepository.findById(specialityId)
				.orElseThrow(() -> new ResourceNotFoundException("Speciality", "Id", specialityId));
	}

	public void deleteSpecialityById(long specialityId) {
		specialityRepository.deleteById(specialityId);
	}

	public void deleteAllSpecialities() {
		specialityRepository.deleteAll();
	}
}
