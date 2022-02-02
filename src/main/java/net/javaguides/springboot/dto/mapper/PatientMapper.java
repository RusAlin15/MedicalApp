package net.javaguides.springboot.dto.mapper;

import net.javaguides.springboot.dto.PersonDTO;
import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.User;

public class PatientMapper extends UserMapper {

	@Override
	public User userDTO2User(UserDTO userDTO) {
		User user = new Patient();
		user.setId(userDTO.getId());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		return user;
	}

	@Override
	public UserDTO user2UserDTO(User user) {
		UserDTO userDTO = new PersonDTO();
		Patient patient = (Patient) user;
		userDTO.setId(patient.getId());
		userDTO.setEmail(patient.getEmail());
		userDTO.setPassword(patient.getPassword());
		userDTO.setPhoneNumber(patient.getPhoneNumber());
		return userDTO;
	}
}
