package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Doctor;

public interface DoctorService {

	List<Doctor> getAllDoctors();

	Doctor saveDoctor(Doctor doctor);

}
