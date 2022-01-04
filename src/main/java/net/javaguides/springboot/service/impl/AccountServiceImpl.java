package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Account;
import net.javaguides.springboot.model.validator.CnpValidator;
import net.javaguides.springboot.repository.AccountRepository;
import net.javaguides.springboot.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public Account saveAccount(Account account) {
		CnpValidator cnpValidator = new CnpValidator(account.getCnp());
		account.setBirthDate(cnpValidator.getBirthDate());
		account.setGender(cnpValidator.getGender());
		account.setAge(cnpValidator.getAge());

		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(long id) {
//	Optional<Account> account= accountRepository.findById(id);
//	if(account.isPresent()) {
//		return account;
//	}else {
//		throw new ResourceNotFoundException("Account", "Id", id);
//	}

		return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
	}

	@Override
	public Account updateAccountFirstName(Account account, long id) {
		// check if account with given id is existing in DB or not
		Account existingAccount = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
		existingAccount.setFirstName(account.getFirstName());
		accountRepository.save(existingAccount);
		return existingAccount;
	}

	@Override
	public Account updateAccountLastName(Account account, long id) {
		// check if account with given id is existing in DB or not
		Account existingAccount = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
		existingAccount.setLastName(account.getLastName());
		accountRepository.save(existingAccount);
		return existingAccount;
	}

	@Override
	public Account updateAccountEmail(Account account, long id) {
		// check if account with given id is existing in DB or not
		Account existingAccount = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
		existingAccount.setEmail(account.getEmail());

		accountRepository.save(existingAccount);
		return existingAccount;
	}

	@Override
	public Account updateAccountBirthDate(Account account, long id) {
		// check if account with given id is existing in DB or not
		Account existingAccount = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
		existingAccount.setBirthDate(account.getBirthDate());
//		existingAccount.setAge(account.getBirthDate());
		accountRepository.save(existingAccount);
		return existingAccount;
	}

	@Override
	public void deleteAccount(long id) {
		// check if account with give id is existing in BD or not
		accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", "Id", id));
		accountRepository.deleteById(id);
	}

	@Override
	public void deleteAllAccounts() {
		accountRepository.deleteAll();
	}

}
