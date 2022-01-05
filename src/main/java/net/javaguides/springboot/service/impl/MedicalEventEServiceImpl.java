package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Account;
import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.model.Speciality;
import net.javaguides.springboot.repository.AccountRepository;
import net.javaguides.springboot.repository.InstitutionRepository;
import net.javaguides.springboot.repository.MedicalEventRepository;
import net.javaguides.springboot.repository.SpecialityRepository;
import net.javaguides.springboot.service.MedicalEventService;

@Service
public class MedicalEventEServiceImpl implements MedicalEventService {

	private MedicalEventRepository medicalEventRepository;
	private AccountRepository accountRepository;
	private SpecialityRepository specialityRepository;
	private InstitutionRepository institutionRepository;

	public MedicalEventEServiceImpl(MedicalEventRepository medicalEventRepository, AccountRepository accountRepository,
			SpecialityRepository specialityRepository, InstitutionRepository institutionRepository) {
		super();
		this.medicalEventRepository = medicalEventRepository;
		this.accountRepository = accountRepository;
		this.specialityRepository = specialityRepository;
		this.institutionRepository = institutionRepository;
	}

	@Override
	public MedicalEvent saveMedicalEvent(MedicalEvent medicalEvent, long accountId, long specialityId,
			long institutionId) {

		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "Id", accountId));
		account.addMedicalEvent(medicalEvent);

		Speciality speciality = specialityRepository.findById(specialityId)
				.orElseThrow(() -> new ResourceNotFoundException("Speciality", "Id", specialityId));
		medicalEvent.setSpeciality(speciality);

		Institution institution = institutionRepository.findById(institutionId)
				.orElseThrow(() -> new ResourceNotFoundException("Institution", "Id", institutionId));
		medicalEvent.setInstitution(institution);

		return medicalEventRepository.save(medicalEvent);
	}

	@Override
	public List<MedicalEvent> getAllMedialEvents() {
		return medicalEventRepository.findAll();
	}

	@Override
	public MedicalEvent getMedicalEventById(long id) {
		return medicalEventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medical Event", "Id", id));
	}

}
