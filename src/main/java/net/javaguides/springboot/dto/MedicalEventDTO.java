package net.javaguides.springboot.dto;

import java.time.LocalDate;
import java.util.List;

import net.javaguides.springboot.model.Clinic;
import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.model.Speciality;

public class MedicalEventDTO {

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public void setDiagnostics(List<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

}
