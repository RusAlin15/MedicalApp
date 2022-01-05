package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Speciality;

public interface SpecialityService {

	public Speciality saveSpeciality(Speciality speciality);

	public List<Speciality> getAllSpecialities();

}
