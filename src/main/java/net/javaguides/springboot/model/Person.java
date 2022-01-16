package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class Person extends User {
	@NotEmpty
	@Size(min = 2)
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotEmpty
	@Size(min = 2)
	@Column(name = "last_name", nullable = false)
	private String lastName;

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
