package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.InstitutionAccount;
import net.javaguides.springboot.model.PatientAccount;
import net.javaguides.springboot.model.UserAccount;

public interface UserAccountService {

	PatientAccount savePatientAcoount(PatientAccount patientAccount);

	List<UserAccount> getAllUserAccounts();

	InstitutionAccount saveInstitutionAccount(InstitutionAccount institutionAccount);

	UserAccount addPatient(long accountId, long patientId);

	UserAccount addClinic(long accountId, long clinicId);

}
