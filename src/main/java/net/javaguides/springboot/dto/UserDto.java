package net.javaguides.springboot.dto;

import lombok.Data;
import net.javaguides.springboot.model.User;

@Data
public class UserDto {
	private Long Id;
	private String email;
	private String phoneNumber;

	public UserDto(User user) {
		this.Id = user.getId();
		this.email = user.getEmail();
		this.phoneNumber = user.getPhoneNumber();
	}

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

}
