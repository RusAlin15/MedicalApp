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
import net.javaguides.springboot.validator.CnpData;
import net.javaguides.springboot.validator.CnpDataService;

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

	CnpDataService cnpExtractor = new CnpDataService();

	public UserDto saveUser(User user) {
		if (user instanceof Patient) {
			Patient patientUser = (Patient) user;
			String cnp = patientUser.getCnp();

			CnpData cnpData = cnpExtractor.extract(cnp);

			patientUser.setAge(cnpData.getAge());
			patientUser.setBirthDate(cnpData.getBirthDate());
			patientUser.setGender(cnpData.getGender().toString());

			return convertToDto(userRepository.save(patientUser));
		}
		return convertToDto(userRepository.save(user));
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

	private UserDto convertToDto(User user) {
		UserDto userDto = new UserDto(user);

		return userDto;
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
