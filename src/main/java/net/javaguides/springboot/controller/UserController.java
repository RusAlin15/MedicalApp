package net.javaguides.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserService;

@RestController
@RequestMapping("/api/account")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody User user) {
		return new ResponseEntity<UserDto>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/{type}")
	public List<UserDto> getByType(@PathVariable String type) {
		return userService.getByType(type);
	}

	@GetMapping("/patientBy/{cnp}")
	public UserDto getPatientByCnp(@PathVariable String cnp) {
		return userService.getPatientByCnp(cnp);
	}
}
