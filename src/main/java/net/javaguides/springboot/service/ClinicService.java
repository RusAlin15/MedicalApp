package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Clinic;

public interface ClinicService {

	Clinic saveClinic(Clinic clinic);

	List<Clinic> getAllClinics();

	void deleteAllClincs();

}
