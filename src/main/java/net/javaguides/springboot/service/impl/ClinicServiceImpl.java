package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Clinic;
import net.javaguides.springboot.model.ClinicAccount;
import net.javaguides.springboot.model.InstitutionAccount;
import net.javaguides.springboot.model.UserAccount;
import net.javaguides.springboot.repository.ClinicRepository;
import net.javaguides.springboot.repository.UserAccountRepository;
import net.javaguides.springboot.service.ClinicService;

@Service
public class ClinicServiceImpl implements ClinicService {
	private ClinicRepository clinicRepository;
	private UserAccountRepository accountRepository;

	public ClinicServiceImpl(ClinicRepository clinicRepository, UserAccountRepository accountRepository) {
		super();
		this.clinicRepository = clinicRepository;
		this.accountRepository = accountRepository;
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

	@Override
	public Clinic addClinicAccount(long accountId, long clinicId) {
		UserAccount userAccount = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("UserAccount", "Id", accountId));

		Clinic clinic = clinicRepository.findById(clinicId)
				.orElseThrow(() -> new ResourceNotFoundException("Institution", "Id", clinicId));

		if (userAccount.getClass() == InstitutionAccount.class) {
			clinic.setClinicAccount((ClinicAccount) userAccount);
		} else {
			throw new InvalidDataException("Invalid", "Id", clinicId);
		}
		clinicRepository.save(clinic);
		return clinic;
	}

}
