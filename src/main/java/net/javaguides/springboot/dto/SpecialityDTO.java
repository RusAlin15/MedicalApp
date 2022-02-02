package net.javaguides.springboot.dto;

import lombok.Data;

@Data
public abstract class SpecialityDTO {
	private Long id;
	private String specialityName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecialityName() {
		return specialityName;
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

}
