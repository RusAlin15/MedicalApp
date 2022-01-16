package net.javaguides.springboot.dto;

import lombok.Data;

@Data
public class ClinicDto extends UserDto {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
