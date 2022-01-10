package net.javaguides.springboot.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "cnp", nullable = false, unique = true)
	private String cnp;

	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "gender", nullable = false)
	private String gender;

	@OneToMany(targetEntity = MedicalEvent.class, cascade = CascadeType.ALL)
	private List<MedicalEvent> medicalEvents;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private PatientAccount patientAccount;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getCnp() {
		return cnp;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void addMedicalEvent(MedicalEvent medicalEvent) {
		this.medicalEvents.add(medicalEvent);
	}

	public List<MedicalEvent> getMedicalEvents() {
		return medicalEvents;
	}

	public PatientAccount getPatientAccount() {
		return patientAccount;
	}

	public void setPatientAccount(PatientAccount patientAccount) {
		this.patientAccount = patientAccount;
	}

	public Long getId() {
		return id;
	}

}
