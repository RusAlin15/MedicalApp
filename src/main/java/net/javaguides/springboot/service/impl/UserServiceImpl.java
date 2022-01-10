package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.ClinicAccount;
import net.javaguides.springboot.model.DoctorAccount;
import net.javaguides.springboot.model.InstitutionAccount;
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
	public InstitutionAccount saveInstitutionAccount(InstitutionAccount institutionAccount) {
		return userAccountRepository.save(institutionAccount);
	}

	@Override
	public ClinicAccount saveClinicAccount(ClinicAccount clinicAccount) {
		return userAccountRepository.save(clinicAccount);
	}

	@Override
	public DoctorAccount saveDoctorAccount(DoctorAccount doctorAccount) {
		return userAccountRepository.save(doctorAccount);
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return userAccountRepository.findAll();
	}

}
