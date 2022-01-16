package net.javaguides.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.ClinicRepository;
import net.javaguides.springboot.repository.DoctorRepository;
import net.javaguides.springboot.repository.InstitutionRepository;
import net.javaguides.springboot.repository.PatientRepository;
import net.javaguides.springboot.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private InstitutionRepository institutionRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private ClinicRepository clinicRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<UserDto> getByType(String type) {

		switch (type) {
		case "intitution": {
			return institutionRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		}
		case "clinic": {
			return clinicRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		}
		case "patient": {
			return patientRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		}
		case "doctor": {
			return doctorRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		}
		default:
			throw new InvalidDataException("DataType", "type", type);
		}
	}

	private UserDto convertToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setEmail(user.getEmail());
		userDto.setId(user.getId());
		userDto.setPhoneNumber(user.getPhoneNumber());

		return userDto;
	}
}
