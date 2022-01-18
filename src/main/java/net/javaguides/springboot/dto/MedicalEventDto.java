package net.javaguides.springboot.dto;

import java.time.LocalDate;
import java.util.List;

import net.javaguides.springboot.model.Clinic;
import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.model.Speciality;

public class MedicalEventDto {

	private Long id;
	private String sympthoms;
	private String sympthomsHistory;
	private String presumtiveDiagnosis;
	private String perforemedMedicalServices;
	private String recommendedMedicalServices;
	private String recomandedTreatment;
	private String diseaseStatus;
	private String eventStatus;
	private LocalDate eventDate;
	private List<Diagnostic> diagnostics;
	private Clinic clinic;
	private Speciality speciality;

	public MedicalEventDto(MedicalEvent medicalEvent) {
		this.id = medicalEvent.getId();
		this.sympthoms = medicalEvent.getSympthoms();
		this.sympthomsHistory = medicalEvent.getSympthomsHistory();
		this.presumtiveDiagnosis = medicalEvent.getPresumtiveDiagnosis();
		this.perforemedMedicalServices = medicalEvent.getPerforemedMedicalServices();
		this.recommendedMedicalServices = medicalEvent.getRecommendedMedicalServices();
		this.recomandedTreatment = medicalEvent.getRecomandedTreatment();
		this.diseaseStatus = medicalEvent.getDiseaseStatus();
		this.eventStatus = medicalEvent.getEventStatus();
		this.eventDate = medicalEvent.getEventDate();
		this.diagnostics = medicalEvent.getDiagnostics();
		this.clinic = medicalEvent.getClinic();
		this.speciality = medicalEvent.getSpeciality();
	}

	public Long getId() {
		return id;
	}

	public String getSympthoms() {
		return sympthoms;
	}

	public String getSympthomsHistory() {
		return sympthomsHistory;
	}

	public String getPresumtiveDiagnosis() {
		return presumtiveDiagnosis;
	}

	public String getPerforemedMedicalServices() {
		return perforemedMedicalServices;
	}

	public String getRecommendedMedicalServices() {
		return recommendedMedicalServices;
	}

	public String getRecomandedTreatment() {
		return recomandedTreatment;
	}

	public String getDiseaseStatus() {
		return diseaseStatus;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

}
