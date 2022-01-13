package net.javaguides.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private InstitutionService intitutionService;
	@Autowired
	private ClinicService clinicService;
	@Autowired
	private PatientUserService patientUserService;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	// **
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();

		users.addAll(intitutionService.getRepository().findAll());
		users.addAll(clinicService.getRepository().findAll());
		users.addAll(patientUserService.getRepository().findAll());

		return users;
	}

}
