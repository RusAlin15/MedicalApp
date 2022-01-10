package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Clinic;
import net.javaguides.springboot.model.InstitutionAccount;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.PatientAccount;
import net.javaguides.springboot.model.UserAccount;
import net.javaguides.springboot.repository.ClinicRepository;
import net.javaguides.springboot.repository.MedicalEventRepository;
import net.javaguides.springboot.repository.PatientRepository;
import net.javaguides.springboot.repository.UserAccountRepository;
import net.javaguides.springboot.service.UserAccountService;

@Service
public class UserServiceImpl implements UserAccountService {

	private UserAccountRepository userAccountRepository;
	private MedicalEventRepository medicalEventRepository;
	private PatientRepository patientRepository;
	private ClinicRepository clicicRepository;

	public UserServiceImpl(UserAccountRepository userAccountRepository, MedicalEventRepository medicalEventRepository,
			PatientRepository patientRepository, ClinicRepository clicicRepository) {
		super();
		this.userAccountRepository = userAccountRepository;
		this.medicalEventRepository = medicalEventRepository;
		this.patientRepository = patientRepository;
		this.clicicRepository = clicicRepository;
	}

	@Override
	public PatientAccount savePatientAcoount(PatientAccount patientAccount) {
		return userAccountRepository.save(patientAccount);
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return userAccountRepository.findAll();
	}

	@Override
	public InstitutionAccount saveInstitutionAccount(InstitutionAccount institutionAccount) {
		return userAccountRepository.save(institutionAccount);
	}

	@Override
	public UserAccount addPatient(long accountId, long patientId) {
		UserAccount userAccount = userAccountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("UserAccount", "Id", accountId));

		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patiente", "Id", patientId));

		if (userAccount.getClass() == PatientAccount.class) {
			((PatientAccount) userAccount).setPatient(patient);
		} else {
			throw new InvalidDataException("Invalid", "Id", patientId);
		}

		userAccountRepository.save(userAccount);
		return userAccount;
	}

	@Override
	public UserAccount addClinic(long accountId, long clinicId) {
		UserAccount userAccount = userAccountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("UserAccount", "Id", accountId));

		Clinic clinic = clicicRepository.findById(clinicId)
				.orElseThrow(() -> new ResourceNotFoundException("Institution", "Id", clinicId));

		if (userAccount.getClass() == InstitutionAccount.class) {
			((InstitutionAccount) userAccount).addClinic(clinic);
		} else {
			throw new InvalidDataException("Invalid", "Id", clinicId);
		}

		userAccountRepository.save(userAccount);
		return userAccount;
	}

}
