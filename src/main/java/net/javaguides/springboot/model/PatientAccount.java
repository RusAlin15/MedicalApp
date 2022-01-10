package net.javaguides.springboot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class PatientAccount extends UserAccount {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Patient patient;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
