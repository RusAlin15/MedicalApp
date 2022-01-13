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

	public Patient savePatient(Patient patient) {

		// **
		CnpValidator cnpValidator = new CnpValidator(patient.getCnp());

		setPatientAtributes(patient, cnpValidator);

		return patientRepository.save(patient);
	}

	private void setPatientAtributes(Patient patient, CnpValidator cnpValidator) {
		patient.setAge(cnpValidator.getAge());
		patient.setBirthDate(cnpValidator.getBirthDate());
		patient.setGender(cnpValidator.getGender().toString());
	}

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Patient findByCnp(String cnp) {
		return patientRepository.findByCnp(cnp);
	}

}
