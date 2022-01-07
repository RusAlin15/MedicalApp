package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Doctor;

public interface DoctorService {

	Doctor saveDoctor(Doctor doctor, long institutionId, long specialityId);

	List<Doctor> getAllDoctors();

}
