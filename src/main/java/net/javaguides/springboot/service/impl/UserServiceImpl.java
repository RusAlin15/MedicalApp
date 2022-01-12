package net.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.ClinicService;
import net.javaguides.springboot.service.InstitutionService;
import net.javaguides.springboot.service.PatientUserService;
import net.javaguides.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private InstitutionService intitutionService;
	private ClinicService clinicService;
	private PatientUserService patientUserService;

	public UserServiceImpl(UserRepository userRepository, InstitutionService intitutionService,
			ClinicService clinicService, PatientUserService patientUserService) {
		super();
		this.userRepository = userRepository;
		this.intitutionService = intitutionService;
		this.clinicService = clinicService;
		this.patientUserService = patientUserService;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	// **
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();

		users.addAll(intitutionService.getRepository().findAll());
		users.addAll(clinicService.getRepository().findAll());
		users.addAll(patientUserService.getRepository().findAll());

		return users;
	}

}
