package net.javaguides.springboot.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import net.javaguides.springboot.enums.Gender;

@Data
@Entity
public class Patient extends UserAccount {

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
	@JoinColumn(name = "patient_id_fk", referencedColumnName = "id")
	private List<MedicalEvent> medicalEvents;

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

	public void setGender(Gender gender) {
		this.gender = gender.toString();
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
}
