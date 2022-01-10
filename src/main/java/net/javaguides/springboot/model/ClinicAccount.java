package net.javaguides.springboot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class ClinicAccount extends UserAccount {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinic_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Clinic clinic;

}
