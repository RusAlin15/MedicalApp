package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Clinic;
import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.model.PatientAccount;
import net.javaguides.springboot.model.User;

public interface UserService {

	PatientAccount savePatientAcoount(PatientAccount patientAccount);

	Institution saveInstitution(Institution institution);

	Clinic saveClinic(Clinic clinic);

	List<User> getAllUsers();

}
