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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@JoinColumn(name = "patient_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<MedicalEvent> medicalEvents;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private PatientUser patientAccount;

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

	public Long getId() {
		return id;
	}

	public PatientUser getPatientAccount() {
		return patientAccount;
	}

	public void setPatientAccount(PatientUser patientAccount) {
		this.patientAccount = patientAccount;
	}

}
