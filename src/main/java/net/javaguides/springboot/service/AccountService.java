package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Account;

public interface AccountService {
	Account saveAccount(Account account);

	List<Account> getAllAccounts();

	Account getAccountById(long id);

	Account updateAccountLastName(Account account, long id);

	Account updateAccountFirstName(Account account, long id);

	Account updateAccountEmail(Account account, long id);

	Account updateAccountBirthDate(Account account, long id);

	void deleteAccount(long id);

	void deleteAllAccounts();

}
