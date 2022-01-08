package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.UserAccount;

public interface UserAccountService {

	Patient savePatient(Patient patient);

//	UserAccount saveDoctor(Doctor doctor, long institutionId, long specialityId);

	List<Patient> getAllUserAccounts();

//	UserAccount getUserAccountById(long id);

	UserAccount addEvent(long UserAccountAccountId, long eventId);

	UserAccount saveInstitution(Institution institution);

//	void deleteAllUserAccounts();

}
