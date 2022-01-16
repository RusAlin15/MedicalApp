package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Doctor extends Person {

	@Column(name = "cuim")
	private String cuim;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Speciality speciality;

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public String getCuim() {
		return cuim;
	}

	public void setCuim(String cuim) {
		this.cuim = cuim;
	}

}
