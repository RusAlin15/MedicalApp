package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.repository.PatientRepository;
import net.javaguides.springboot.service.PatientService;
import net.javaguides.springboot.validator.CnpValidator;

@Service
public class PatientServiceImpl implements PatientService {
	private PatientRepository patientRepository;

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient savePatient(Patient patient) {
		CnpValidator cnpValidator = new CnpValidator(patient.getCnp());

		setPatientAtributes(patient, cnpValidator);

		return patientRepository.save(patient);
	}

	private void setPatientAtributes(Patient patient, CnpValidator cnpValidator) {
		patient.setAge(cnpValidator.getAge());
		patient.setBirthDate(cnpValidator.getBirthDate());
		patient.setGender(cnpValidator.getGender().toString());
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

}
