package net.javaguides.springboot.dto;

import lombok.Data;
import net.javaguides.springboot.model.Person;

@Data
public class PersonDto extends UserDto {
	private String firstName;
	private String lastName;

	public PersonDto(Person user) {
		super(user);
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
