package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Clinic;
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
	public Clinic saveClinic(Clinic clinic) {
		return clinicRepository.save(clinic);
	}

	@Override
	public List<Clinic> getAllClinics() {
		return clinicRepository.findAll();
	}

	@Override
	public void deleteAllClincs() {
		clinicRepository.deleteAll();
	}

}
