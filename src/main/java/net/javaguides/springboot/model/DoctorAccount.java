package net.javaguides.springboot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class DoctorAccount extends UserAccount {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Doctor doctor;

}
