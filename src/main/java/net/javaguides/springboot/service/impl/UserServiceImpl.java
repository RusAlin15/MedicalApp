package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.UserAccount;
import net.javaguides.springboot.repository.MedicalEventRepository;
import net.javaguides.springboot.repository.userAccountRepository;
import net.javaguides.springboot.service.userAccountService;
import net.javaguides.springboot.validator.CnpValidator;

@Service
public class UserServiceImpl implements userAccountService {

	private userAccountRepository userAccountRepository;
	private MedicalEventRepository medicalEventRepository;

	public UserServiceImpl(net.javaguides.springboot.repository.userAccountRepository userAccountRepository,
			MedicalEventRepository medicalEventRepository) {
		super();
		this.userAccountRepository = userAccountRepository;
		this.medicalEventRepository = medicalEventRepository;
	}

	@Override
	public UserAccount savePatient(Patient patient) {
		patientSeters(patient);
		return userAccountRepository.save(patient);
	}

//	@Override
//	public UserAccount saveDoctor(Doctor doctor, long institutionId, long specialityId) {
//		patientSeters(doctor);
//
//		Speciality speciality = specialityRepository.findById(specialityId)
//				.orElseThrow(() -> new ResourceNotFoundException("Speciality", "Id", specialityId));
//		doctor.setSpeciality(speciality);
//
//		Institution institution = institutionRepository.findById(institutionId)
//				.orElseThrow(() -> new ResourceNotFoundException("Institution", "Id", institutionId));
//		doctor.setInstitution(institution);
//
//		return UserAccountRepository.save(doctor);
//	}

	private void patientSeters(Patient patient) {
		CnpValidator cnpValidator = new CnpValidator(patient.getCnp());
		patient.setBirthDate(cnpValidator.getBirthDate());
		patient.setGender(cnpValidator.getGender());
		patient.setAge(cnpValidator.getAge());
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return userAccountRepository.findAll();
	}

//	@Override
//	public UserAccount getUserAccountById(long id) {
////	Optional<Patient> patient= patientRepository.findById(id);
////	if(patient.isPresent()) {
////		return patient;
////	}else {
////		throw new ResourceNotFoundException("Patient", "Id", id);
////	}
//
//		return UserAccountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserAccount", "Id", id));
//	}
//
//	@Override
//	public void deleteAllUserAccounts() {
//		UserAccountRepository.deleteAll();
//	}

	@Override
	public UserAccount addEvent(long patientId, long eventId) {
		UserAccount userAccount = userAccountRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		userAccount.addMedicalEvent(medicalEvent);
		userAccountRepository.save(userAccount);
		return userAccount;
	}

}