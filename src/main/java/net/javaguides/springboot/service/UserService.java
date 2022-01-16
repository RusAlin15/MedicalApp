package net.javaguides.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.InstituteDto;
import net.javaguides.springboot.dto.PersonDto;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.model.Institute;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.Person;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.ClinicRepository;
import net.javaguides.springboot.repository.DoctorRepository;
import net.javaguides.springboot.repository.InstitutionRepository;
import net.javaguides.springboot.repository.PatientRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.validator.CnpValidator;

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

	CnpValidator cnpValidator = new CnpValidator();

	public User saveUser(User user) {
		if (user instanceof Patient) {
			Patient patientUser = (Patient) user;
			String cnp = patientUser.getCnp();
			cnpValidator.init(cnp);

			patientUser.setAge(cnpValidator.getAge());
			patientUser.setBirthDate(cnpValidator.getBirthDate());
			patientUser.setGender(cnpValidator.getGender().toString());

			return userRepository.save(patientUser);
		}

		return userRepository.save(user);
	}

	public List<UserDto> getByType(String type) {

		switch (type) {
		case "institution": {
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

	private UserDto convertToDto(Person user) {
		PersonDto userDto = new PersonDto(user);

		return userDto;
	}

	private UserDto convertToDto(Institute user) {
		InstituteDto userDto = new InstituteDto(user);

		return userDto;
	}
}
