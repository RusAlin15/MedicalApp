package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

@Data
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "specialityType", defaultImpl = Object.class)
@JsonSubTypes({ @JsonSubTypes.Type(value = DentalSpeciality.class, name = "DentalSpeciality"),
		@JsonSubTypes.Type(value = ClinicSpeciality.class, name = "ClinicSpeciality"),
		@JsonSubTypes.Type(value = SurgerySpeciality.class, name = "SurgerySpeciality") })
public abstract class Speciality {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotEmpty
	@Size(min = 5)
	@Column(name = "speciality_name", nullable = false, unique = true)
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
