package net.javaguides.springboot.dto;

import lombok.Data;

@Data
public class UserDTO {
	private Long Id;
	private String email;
	private String phoneNumber;
	private String password;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return null;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
