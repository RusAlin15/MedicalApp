package net.javaguides.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.SpecialityDto;
import net.javaguides.springboot.model.Speciality;
import net.javaguides.springboot.repository.SpecialityRepository;

@Service
public class SpecialityService {
	@Autowired
	SpecialityRepository specialityRepository;

	public SpecialityDto saveSpeciality(Speciality speciality) {
		return convertToDto(specialityRepository.save(speciality));
	}

	private SpecialityDto convertToDto(Speciality speciality) {
		return new SpecialityDto(speciality);
	}

	public List<SpecialityDto> getAllSpecialities() {
		return specialityRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}
}
