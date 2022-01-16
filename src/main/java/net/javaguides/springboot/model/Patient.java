package net.javaguides.springboot.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(schema = "administration")
public class Patient extends Person {

	@NotEmpty
	@Pattern(regexp = "^[1-9]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)(00[1-9]|0[1-9]\\d|[1-9]\\d\\d)\\d$")
	@Column(name = "cnp", nullable = false, unique = true)
	private String cnp;

	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "gender", nullable = false)
	private String gender;

	@OneToMany(targetEntity = MedicalEvent.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<MedicalEvent> medicalEvents;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<LabAnalyse> labAnalysisResults;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<LabScreening> labScreeningResults;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Patient> patients;

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<MedicalEvent> getMedicalEvents() {
		return medicalEvents;
	}

	public List<LabAnalyse> getLabAnalysisResults() {
		return labAnalysisResults;
	}

	public List<LabScreening> getLabScreeningResults() {
		return labScreeningResults;
	}

}
