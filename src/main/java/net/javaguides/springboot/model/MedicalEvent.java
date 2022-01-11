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

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private DiseaseStatus deseaseStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private MedicalEventStatus medicalEventStatus;

	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name = "event_date", nullable = false)
	private LocalDate eventDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Clinic clinic;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Speciality speciality;

	@OneToMany(targetEntity = ReferralTicket.class, cascade = CascadeType.ALL)
	private List<ReferralTicket> referralTickets;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Recipe recipe;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Doctor doctor;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Patient patient;

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

	public DiseaseStatus getDeseaseStatus() {
		return deseaseStatus;
	}

	public void setDeseaseStatus(DiseaseStatus deseaseStatus) {
		this.deseaseStatus = deseaseStatus;
	}

	public MedicalEventStatus getMedicalEventStatus() {
		return medicalEventStatus;
	}

	public void setMedicalEventStatus(MedicalEventStatus medicalEventStatus) {
		this.medicalEventStatus = medicalEventStatus;
	}

	public void addDiagnostic(Diagnostic diagnostic) {
		this.diagnostics.add(diagnostic);
	}

	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

}
