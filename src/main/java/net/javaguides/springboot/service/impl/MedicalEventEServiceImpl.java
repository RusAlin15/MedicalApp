package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Account;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.repository.AccountRepository;
import net.javaguides.springboot.repository.MedicalEventRepository;
import net.javaguides.springboot.service.MedicalEventService;

@Service
public class MedicalEventEServiceImpl implements MedicalEventService {

	private MedicalEventRepository medicalEventRepository;
	private AccountRepository accountRepository;

	public MedicalEventEServiceImpl(MedicalEventRepository medicalEventRepository,
			AccountRepository accountRepository) {
		super();
		this.medicalEventRepository = medicalEventRepository;
		this.accountRepository = accountRepository;
	}

	@Override
	public MedicalEvent saveMedicalEvent(MedicalEvent medicalEvent) {
		Long id = medicalEvent.getAccountId();

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
		account.addMedicalEvent(medicalEvent);

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
