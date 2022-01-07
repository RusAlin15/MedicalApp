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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "medical_event")
public class MedicalEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "sympthoms", nullable = false)
	private String sympthoms;

	@Column(name = "sympthoms_history")
	private String sympthomsHistory;

	@Column(name = "presumtive_diagnosis")
	private String presumtiveDiagnosis;

	@Column(name = "perforemed_medical_services", nullable = false)
	private String perforemedMedicalServices;

	@Column(name = "recommended_medical_services")
	private String recommendedMedicalServices;

	@Column(name = "recomanded_treatment")
	private String recomandedTreatment;

	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name = "event_date", nullable = false)
	private LocalDate eventDate;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Institution institution;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "speciality_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Speciality speciality;

//	@Column(name = "status", nullable = false)
//	private Status status;

	@ManyToOne(targetEntity = Diagnostic.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "diagnostic_id_fk", referencedColumnName = "icd_code")
	private List<Diagnostic> diagnostics;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stage_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Stage stage;

//	@Column(name = "events", nullable = false)
//	private Events[] relatedMedicalEvents;

	@OneToMany(targetEntity = ReferralTicket.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "referal_id_fk")
	private List<ReferralTicket> referralTickets;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Recipe recipe;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSympthoms() {
		return sympthoms;
	}

	public void setSympthoms(String sympthoms) {
		this.sympthoms = sympthoms;
	}

	public String getSympthomsHistory() {
		return sympthomsHistory;
	}

	public void setSympthomsHistory(String sympthomsHistory) {
		this.sympthomsHistory = sympthomsHistory;
	}

	public String getPresumtiveDiagnosis() {
		return presumtiveDiagnosis;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setPresumtiveDiagnosis(String presumtiveDiagnosis) {
		this.presumtiveDiagnosis = presumtiveDiagnosis;
	}

	public String getPerforemedMedicalServices() {
		return perforemedMedicalServices;
	}

	public void setPerforemedMedicalServices(String perforemedMedicalServices) {
		this.perforemedMedicalServices = perforemedMedicalServices;
	}

	public String getRecommendedMedicalServices() {
		return recommendedMedicalServices;
	}

	public void setRecommendedMedicalServices(String recommendedMedicalServices) {
		this.recommendedMedicalServices = recommendedMedicalServices;
	}

	public String getRecomandedTreatment() {
		return recomandedTreatment;
	}

	public void setRecomandedTreatment(String recomandedTreatment) {
		this.recomandedTreatment = recomandedTreatment;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public Long getId() {
		return id;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Institution getInstitution() {
		return institution;
	}

}
