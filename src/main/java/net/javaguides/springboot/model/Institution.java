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
public class Institution extends Institute {

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Clinic> clinics;

	public List<Clinic> getClinics() {
		return clinics;
	}

	public void addClinics(Clinic clinic) {
		this.clinics.add(clinic);
	}
}
