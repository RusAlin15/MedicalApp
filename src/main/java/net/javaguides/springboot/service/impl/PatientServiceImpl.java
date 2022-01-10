package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.PatientAccount;
import net.javaguides.springboot.model.UserAccount;
import net.javaguides.springboot.repository.MedicalEventRepository;
import net.javaguides.springboot.repository.PatientRepository;
import net.javaguides.springboot.repository.UserAccountRepository;
import net.javaguides.springboot.service.PatientService;
import net.javaguides.springboot.validator.CnpValidator;

@Service
public class PatientServiceImpl implements PatientService {
	private PatientRepository patientRepository;
	private MedicalEventRepository medicalEventRepository;
	private UserAccountRepository accountRepository;

	public PatientServiceImpl(PatientRepository patientRepository, MedicalEventRepository medicalEventRepository,
			UserAccountRepository accountRepository) {
		super();
		this.patientRepository = patientRepository;
		this.medicalEventRepository = medicalEventRepository;
		this.accountRepository = accountRepository;
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

	@Override
	public Patient addEvent(long patientId, long eventId) {

		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		patient.addMedicalEvent(medicalEvent);
		patientRepository.save(patient);
		return patient;
	}

	@Override
	public Patient addPatientAccount(long accountId, long patientId) {

		UserAccount userAccount = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("UserAccount", "Id", accountId));

		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patiente", "Id", patientId));

		if (userAccount.getClass() == PatientAccount.class) {
			patient.setPatientAccount((PatientAccount) userAccount);
		} else {
			throw new InvalidDataException("Invalid", "Id", patientId);
		}

		patientRepository.save(patient);
		return patient;
	}

}
