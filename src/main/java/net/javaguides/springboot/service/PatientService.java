package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.repository.PatientRepository;
import net.javaguides.springboot.validator.CnpValidator;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	CnpValidator cnpValidator = new CnpValidator();

	public Patient savePatient(Patient patient) {
		String cnp = patient.getCnp();
		cnpValidator.init(cnp);

		patient.setAge(cnpValidator.getAge());
		patient.setBirthDate(cnpValidator.getBirthDate());
		patient.setGender(cnpValidator.getGender().toString());

		return patientRepository.save(patient);
	}

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Patient findByCnp(String cnp) {
		return patientRepository.findByCnp(cnp);
	}

}
