package net.javaguides.springboot.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import net.javaguides.springboot.enums.Gender;

@Data
@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "cnp", nullable = false, unique = true)
	private String cnp;

	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@Column(name = "age", nullable = false)
	private int age;

//	@Column(name = "phone_nr")
//	private String phoneNr;

	@Column(name = "gender", nullable = false)
	private String gender;

	@OneToMany(targetEntity = MedicalEvent.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id_fk", referencedColumnName = "id")
	private List<MedicalEvent> medicalEvents;

//	@Column(name = "history_form")
//	private HistoryForm[] historyForm;

//	@Column(name = "lab_analysis")
//	private LabAnalysis[] labAnalysis;

//	@Column(name = "lab_screening")
//	private LabScreening[] labScreening;

//	@Column(name = "access_key")
//	private AccessKey accessKey;

	public Account() {
		super();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Long getId() {
		return id;
	}

	public List<MedicalEvent> getMedicalEvents() {
		return medicalEvents;
	}

}
