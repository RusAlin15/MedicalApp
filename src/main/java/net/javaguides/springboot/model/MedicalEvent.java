package net.javaguides.springboot.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import net.javaguides.springboot.model.speciality.Speciality;

@Data
@Entity
@Table(name = "medical_events")
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

	@Transient
	private Long accountId;

//	@Column(name = "medical_institution", nullable = false)
//	private MedicalInstitution institution;
//

	@OneToOne(targetEntity = Speciality.class, cascade = CascadeType.ALL)
	private Speciality speciality;
//
//	@Column(name = "status", nullable = false)
//	private Status status;
//
//	@Column(name = "appoitments", nullable = false)
//	private Appointment[] appoitments;
//
//	@Column(name = "diagnose", nullable = false)
//	private Diagnose diagnose;
//
//	@Column(name = "stage", nullable = false)
//	private Stage stage;
//
//	@Column(name = "events", nullable = false)
//	private Events[] relatedMedicalEvents;
//
//	@Column(name = "recomandation_ticket", nullable = false)
//	private RecomandationTicket recomandationTicket;
//
//	@Column(name = "recipe", nullable = false)
//	private Recipe recipe;
//
//	@Column(name = "screening_results", nullable = false)
//	private ScreeningResults screeningResults;
//
//	@Column(name = "labs_results", nullable = false)
//	private LabsResults labsResults;
//
//	@Column(name = "doctor", nullable = false)
//	private Doctor doctor;
//
//	@Column(name = "event_report", nullable = false)
//	private File eventReport;

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

	public Long getAccountId() {
		return accountId;
	}

}
