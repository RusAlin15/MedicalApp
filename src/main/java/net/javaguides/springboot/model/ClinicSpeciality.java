package net.javaguides.springboot.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class ClinicSpeciality extends Speciality {

	public ClinicSpeciality() {
		super();
	}

}
