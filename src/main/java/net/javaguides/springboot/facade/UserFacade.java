package net.javaguides.springboot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.dto.mapper.UserMapper;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserService;

@Component
public class UserFacade {
	@Autowired
	UserMapper userMapper;

	@Autowired
	UserService userService;

	public UserDTO saveUser(UserDTO userDTO) {
		User user = userMapper.userDTO2User(userDTO);
		return userMapper.user2UserDTO(userService.saveUser(user));
	}

	public List<UserDTO> getByType(String type) {
		return userMapper.userList2UserListDTO(userService.getByType(type));
	}

}
