package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.model.Patient;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserService;

@Controller
@RequestMapping()
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody User user) {
		return new ResponseEntity<UserDTO>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/users/new")
	public String createUserFrom(Model model) {

		User user = new Patient();
		model.addAttribute("user", user);
		return "create_user";
	}

	@GetMapping("/{type}")
	public List<UserDTO> getByType(@PathVariable String type) {
		return userService.getByType(type);
	}

	@GetMapping("/patientBy/{cnp}")
	public UserDTO getPatientByCnp(@PathVariable String cnp) {
		return userService.getPatientByCnp(cnp);
	}

//	@GetMapping("/patients")
//	public String listPatients(Model model) {
//		model.addAttribute("patients", userService.getByType("patient"));
//		return "patients";
//	}

	@GetMapping("/persons")
	public String listPersons(Model model) {
		List<UserDTO> users = new ArrayList<>();
		users.addAll(userService.getByType("doctor"));
		users.addAll(userService.getByType("patient"));
		model.addAttribute("persons", users);
		return "persons";
	}
}
