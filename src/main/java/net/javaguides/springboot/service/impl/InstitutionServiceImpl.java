package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.model.InstitutionAccount;
import net.javaguides.springboot.model.UserAccount;
import net.javaguides.springboot.repository.InstitutionRepository;
import net.javaguides.springboot.repository.UserAccountRepository;
import net.javaguides.springboot.service.InstitutionService;

@Service
public class InstitutionServiceImpl implements InstitutionService {
	InstitutionRepository institutionRepository;
	UserAccountRepository accountRepository;

	public InstitutionServiceImpl(InstitutionRepository institutionRepository,
			UserAccountRepository accountRepository) {
		super();
		this.institutionRepository = institutionRepository;
		this.accountRepository = accountRepository;
	}

	@Override
	public Institution saveInstitution(Institution institution) {
		return institutionRepository.save(institution);
	}

	@Override
	public Institution setInstitutionAccount(long accountId, long institutionId) {

		UserAccount userAccount = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("UserAccount", "Id", accountId));

		Institution institution = institutionRepository.findById(institutionId)
				.orElseThrow(() -> new ResourceNotFoundException("Patiente", "Id", institutionId));

		if (userAccount.getClass() == InstitutionAccount.class) {
			institution.setInstitutionAccount((InstitutionAccount) userAccount);
		} else {
			throw new InvalidDataException("Invalid", "Id", institutionId);
		}

		institutionRepository.save(institution);
		return institution;
	}

	@Override
	public List<Institution> getAllInstitutions() {
		return institutionRepository.findAll();
	}

}
