package net.javaguides.springboot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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

	@ManyToMany(targetEntity = Diagnostic.class, cascade = CascadeType.ALL)
	private List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();

	@Column(name = "disease_status")
	private String diseaseStatus;

	@Column(name = "event_status")
	private String eventStatus;

	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name = "event_date", nullable = false)
	private LocalDate eventDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinic_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Clinic clinic;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "speciality_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Speciality speciality;

	@OneToMany(targetEntity = ReferralTicket.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "referral_ticket_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<ReferralTicket> referralTickets;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Recipe recipe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Patient patient;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicalEvent_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<MedicalEvent> subMedicalEvents;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public List<ReferralTicket> getReferralTickets() {
		return referralTickets;
	}

	public void addDiagnostic(Diagnostic diagnostic) {
		this.diagnostics.add(diagnostic);
	}

	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public String getDiseaseStatus() {
		return diseaseStatus;
	}

	public void setDiseaseStatus(String diseaseStatus) {
		this.diseaseStatus = diseaseStatus;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
