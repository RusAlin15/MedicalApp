package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Clinic extends User {

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "webSite", unique = true)
	private String webSite;

	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Doctor> doctors;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Institution institution;

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

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void addDoctor(Doctor doctor) {
		this.doctors.add(doctor);
	}

}
