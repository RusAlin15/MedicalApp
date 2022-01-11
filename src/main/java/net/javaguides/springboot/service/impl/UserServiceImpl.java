package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Clinic;
import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.model.PatientAccount;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.ClinicRepository;
import net.javaguides.springboot.repository.MedicalEventRepository;
import net.javaguides.springboot.repository.PatientRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private MedicalEventRepository medicalEventRepository;
	private PatientRepository patientRepository;
	private ClinicRepository clicicRepository;

	public UserServiceImpl(UserRepository userRepository, MedicalEventRepository medicalEventRepository,
			PatientRepository patientRepository, ClinicRepository clicicRepository) {
		super();
		this.userRepository = userRepository;
		this.medicalEventRepository = medicalEventRepository;
		this.patientRepository = patientRepository;
		this.clicicRepository = clicicRepository;
	}

	@Override
	public PatientAccount savePatientAcoount(PatientAccount patientAccount) {
		return userRepository.save(patientAccount);
	}

	@Override
	public Institution saveInstitution(Institution institution) {
		return userRepository.save(institution);
	}

	@Override
	public Clinic saveClinic(Clinic clinic) {
		return userRepository.save(clinic);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
