package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class PatientUser extends User {

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Patient> patients;

	public List<Patient> getPatients() {
		return patients;
	}

	public void addPatients(Patient patient) {
		this.patients.add(patient);
	}

}
