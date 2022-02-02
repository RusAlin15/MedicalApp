package net.javaguides.springboot.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.model.User;

@Primary
@Service
public abstract class UserMapper {

	public abstract User userDTO2User(UserDTO userDTO);

	public abstract UserDTO user2UserDTO(User saveUser);

	public List<UserDTO> userList2UserListDTO(List<User> allByType) {
		return allByType.stream().map(this::user2UserDTO).collect(Collectors.toList());
	}

}
