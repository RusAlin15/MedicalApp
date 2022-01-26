package net.javaguides.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.InstituteDto;
import net.javaguides.springboot.dto.PersonDto;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.model.CnpData;
import net.javaguides.springboot.model.Institute;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.Person;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.ClinicRepository;
import net.javaguides.springboot.repository.DoctorRepository;
import net.javaguides.springboot.repository.InstitutionRepository;
import net.javaguides.springboot.repository.PatientRepository;
import net.javaguides.springboot.repository.PersonRepository;
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
	@Autowired
	private PersonRepository personRepository;

	private CnpDataService cnpService = new CnpDataService();

	public UserDto saveUser(User user) {
		if (user instanceof Patient) {
			Patient patientUser = (Patient) user;

			String cnp = patientUser.getCnp();
			int[] cnpDigits = extractCnpDigits(cnp);

			CnpValidator cnpValidator = new CnpValidator();
			cnpValidator.isValid(cnpDigits);

			setPatientProperties(patientUser, cnpDigits);

			return convertToDto(userRepository.save(patientUser));
		}
		return convertToDto(userRepository.save(user));
	}

	private void setPatientProperties(Patient patientUser, int[] cnpDigits) {
		CnpData cnpData = cnpService.extract(cnpDigits);

		patientUser.setAge(cnpData.getAge());
		patientUser.setBirthDate(cnpData.getBirthDate());
		patientUser.setGender(cnpData.getGender().toString());
	}

	private int[] extractCnpDigits(String cnp) {

		int[] digits = new int[13];
		for (int i = 0; i < 13; i++) {
			char c = cnp.charAt(i);
			if (!Character.isDigit(c)) {
				throw new InvalidDataException("Account", "CNP", cnp);
			}
			digits[i] = (byte) Character.digit(c, 10);
		}
		return digits;
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
		return new UserDto(user);
	}

	private UserDto convertToDto(Person user) {
		return new PersonDto(user);
	}

	private UserDto convertToDto(Institute user) {
		return new InstituteDto(user);
	}

	public UserDto getPatientByCnp(String cnp) {
		return convertToDto(patientRepository.findByCnp(cnp));
	}
}
