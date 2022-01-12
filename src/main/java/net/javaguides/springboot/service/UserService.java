package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.User;

public interface UserService {

	User saveUser(User User);

	List<User> getAllUsers();

}
