package net.javaguides.springboot.dto.mapper;

import net.javaguides.springboot.dto.InstituteDTO;
import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.model.Clinic;
import net.javaguides.springboot.model.User;

public class ClinicMapper extends UserMapper {

	@Override
	public User userDTO2User(UserDTO userDTO) {
		User user = new Clinic();
		user.setId(userDTO.getId());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		return user;
	}

	@Override
	public UserDTO user2UserDTO(User user) {
		UserDTO userDTO = new InstituteDTO();
		Clinic clinic = (Clinic) user;
		userDTO.setId(clinic.getId());
		userDTO.setEmail(clinic.getEmail());
		userDTO.setPassword(clinic.getPassword());
		userDTO.setPhoneNumber(clinic.getPhoneNumber());
		return userDTO;
	}

}
