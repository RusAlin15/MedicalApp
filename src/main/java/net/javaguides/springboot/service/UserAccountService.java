package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.ClinicAccount;
import net.javaguides.springboot.model.DoctorAccount;
import net.javaguides.springboot.model.InstitutionAccount;
import net.javaguides.springboot.model.PatientAccount;
import net.javaguides.springboot.model.UserAccount;

public interface UserAccountService {

	PatientAccount savePatientAcoount(PatientAccount patientAccount);

	InstitutionAccount saveInstitutionAccount(InstitutionAccount institutionAccount);

	ClinicAccount saveClinicAccount(ClinicAccount clinicAccount);

	DoctorAccount saveDoctorAccount(DoctorAccount doctorAccount);

	List<UserAccount> getAllUserAccounts();

}
