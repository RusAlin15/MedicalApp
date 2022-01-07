package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.UserAccount;

public interface userAccountService {

	UserAccount savePatient(Patient patient);

//	UserAccount saveDoctor(Doctor doctor, long institutionId, long specialityId);

	List<UserAccount> getAllUserAccounts();

//	UserAccount getUserAccountById(long id);

	UserAccount addEvent(long UserAccountAccountId, long eventId);

//	void deleteAllUserAccounts();

}
