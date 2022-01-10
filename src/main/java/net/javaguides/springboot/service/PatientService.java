package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);

	List<Patient> getAllPatients();

	Patient addEvent(long patientId, long eventId);

	Patient addPatientAccount(long accountId, long patientId);

}
