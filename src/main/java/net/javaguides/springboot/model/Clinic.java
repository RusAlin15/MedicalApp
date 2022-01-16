package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Clinic extends Institute {

	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Doctor> doctors;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Institution institution;

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void addDoctor(Doctor doctor) {
		this.doctors.add(doctor);
	}

}
