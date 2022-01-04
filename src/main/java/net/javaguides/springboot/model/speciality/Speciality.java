package net.javaguides.springboot.model.speciality;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

@Data
@Entity
@Table(name = "speciality")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "specialityType", defaultImpl = Object.class)
@JsonSubTypes({ @JsonSubTypes.Type(value = DentalSpeciality.class, name = "DentalSpeciality"),
		@JsonSubTypes.Type(value = ClinicSpeciality.class, name = "ClinicSpeciality"),
		@JsonSubTypes.Type(value = SurgerySpeciality.class, name = "SurgerySpeciality") })
public abstract class Speciality {

	@Id
	@Column(name = "speciality_name")
	private String specialityName;

	public String getSpeciality() {
		return specialityName;
	}

	public void setSpeciality(String speciality) {
		this.specialityName = speciality;
	}

}
