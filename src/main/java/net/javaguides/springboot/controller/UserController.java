package net.javaguides.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.facade.UserFacade;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserFacade userFacade;

	@PostMapping
	public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
		return new ResponseEntity<UserDTO>(userFacade.saveUser(userDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{type}")
	public List<UserDTO> getByType(@PathVariable String type) {
		return userFacade.getByType(type);
	}

}
