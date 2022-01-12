package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Institution extends User {

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "webSite", unique = true)
	private String webSite;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Clinic> clinics;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public List<Clinic> getClinics() {
		return clinics;
	}

	public void addClinics(Clinic clinic) {
		this.clinics.add(clinic);
	}
}
