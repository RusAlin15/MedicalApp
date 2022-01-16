package net.javaguides.springboot.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class SurgerySpeciality extends Speciality {

	public SurgerySpeciality() {
		super();
	}

}
