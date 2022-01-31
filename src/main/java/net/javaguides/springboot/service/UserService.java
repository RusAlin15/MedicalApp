package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.model.CnpData;
import net.javaguides.springboot.model.Patient;
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

	public User saveUser(User user) {
		if (user instanceof Patient) {

			String cnp = ((Patient) user).getCnp();
			int[] cnpDigits = extractCnpDigits(cnp);

			CnpValidator cnpValidator = new CnpValidator();
			cnpValidator.isValid(cnpDigits);

			setPatientProperties(((Patient) user), cnpDigits);

			return userRepository.save(user);
		}
		return userRepository.save(user);
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

	public List<User> getByType(String type) {

		switch (type) {
		case "institution": {
			return institutionRepository.findAll();
		}
		case "clinic": {
			return clinicRepository.findAll();
		}
		case "patient": {
			return patientRepository.findAll();
		}
		case "doctor": {
			return doctorRepository.findAll();
		}
		default:
			throw new InvalidDataException("DataType", "type", type);
		}
	}

	public User getPatientByCnp(String cnp) {
		return patientRepository.findByCnp(cnp);
	}
}
