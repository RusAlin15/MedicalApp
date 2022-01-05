package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Account;
import net.javaguides.springboot.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	// build create account REST API
	@PostMapping()
	public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.saveAccount(account), HttpStatus.CREATED);
	}

	// build all accounts REST API
	@GetMapping
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	// build specific account with specific ID
	// http://localhost:8070/api/account/1
	@GetMapping("{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable("id") long id) {
		return new ResponseEntity<Account>(accountService.getAccountById(id), HttpStatus.OK);
	}

	// http://localhost:8070/api/account/1
	// buld update account REST API
	@PutMapping("/lastName/{id}")
	public ResponseEntity<Account> updateAccountLastName(@PathVariable("id") long id, @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccountLastName(account, id), HttpStatus.OK);
	}

	@PutMapping("/firstName/{id}")
	public ResponseEntity<Account> updateAccountFirsttName(@PathVariable("id") long id, @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccountFirstName(account, id), HttpStatus.OK);
	}

	@PutMapping("/email/{id}")
	public ResponseEntity<Account> updateAccountEmail(@PathVariable("id") long id, @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccountEmail(account, id), HttpStatus.OK);
	}

	@PutMapping("/birthDate/{id}")
	public ResponseEntity<Account> updateAccountBirthDate(@PathVariable("id") long id, @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccountBirthDate(account, id), HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAccountById(@PathVariable("id") long id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<String>("Account deleted successfuly!", HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping()
	public ResponseEntity<String> deleteAllAccounts() {
		accountService.deleteAllAccounts();
		return new ResponseEntity<String>("All accounts successfuly deleted!", HttpStatus.OK);
	}

}
