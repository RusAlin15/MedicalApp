package net.javaguides.springboot.dto;

import lombok.Data;
import net.javaguides.springboot.model.Speciality;

@Data
public class SpecialityDTO {
	private Long id;
	private String specialityName;

	public SpecialityDTO(Speciality speciality) {
		this.id = speciality.getId();
		this.specialityName = speciality.getSpecialityName();
	}

	public Long getId() {
		return id;
	}

	public String getSpecialityName() {
		return specialityName;
	}

}
