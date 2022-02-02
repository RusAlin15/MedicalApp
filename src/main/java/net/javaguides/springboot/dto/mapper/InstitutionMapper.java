package net.javaguides.springboot.dto.mapper;

import net.javaguides.springboot.dto.InstituteDTO;
import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.model.User;

public class InstitutionMapper extends UserMapper {

	@Override
	public User userDTO2User(UserDTO userDTO) {
		User user = new Institution();
		user.setId(userDTO.getId());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		return user;
	}

	@Override
	public UserDTO user2UserDTO(User user) {
		UserDTO userDTO = new InstituteDTO();
		Institution institution = (Institution) user;
		userDTO.setId(institution.getId());
		userDTO.setEmail(institution.getEmail());
		userDTO.setPassword(institution.getPassword());
		userDTO.setPhoneNumber(institution.getPhoneNumber());
		return userDTO;
	}

}
