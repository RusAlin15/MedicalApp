package net.javaguides.springboot.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.MedicalEventDTO;
import net.javaguides.springboot.model.MedicalEvent;

@Service
public class MedicalEventMapper {

	public MedicalEvent medicalEventDTO2MedicalEvent(MedicalEventDTO medicalEventDTO) {
		MedicalEvent medicalEvent = new MedicalEvent();
		medicalEvent.setId(medicalEventDTO.getId());
		medicalEvent.setSympthoms(medicalEventDTO.getSympthoms());
		medicalEvent.setSympthomsHistory(medicalEventDTO.getSympthomsHistory());
		medicalEvent.setPresumtiveDiagnosis(medicalEventDTO.getPresumtiveDiagnosis());
		medicalEvent.setPerforemedMedicalServices(medicalEventDTO.getPerforemedMedicalServices());
		medicalEvent.setRecommendedMedicalServices(medicalEventDTO.getRecommendedMedicalServices());
		medicalEvent.setRecomandedTreatment(medicalEventDTO.getRecomandedTreatment());
		medicalEvent.setDiseaseStatus(medicalEventDTO.getDiseaseStatus());
		medicalEvent.setEventStatus(medicalEventDTO.getEventStatus());
		medicalEvent.setEventDate(medicalEventDTO.getEventDate());
		medicalEvent.setDiagnostics(medicalEventDTO.getDiagnostics());
		medicalEvent.setClinic(medicalEventDTO.getClinic());
		medicalEvent.setSpeciality(medicalEventDTO.getSpeciality());
		return medicalEvent;
	}

	public MedicalEventDTO medicalEvent2MedicalEventDTO(MedicalEvent medicalEvent) {
		MedicalEventDTO medicalEventDTO = new MedicalEventDTO();
		medicalEventDTO.setId(medicalEvent.getId());
		medicalEventDTO.setSympthoms(medicalEvent.getSympthoms());
		medicalEventDTO.setSympthomsHistory(medicalEvent.getSympthomsHistory());
		medicalEventDTO.setPresumtiveDiagnosis(medicalEvent.getPresumtiveDiagnosis());
		medicalEventDTO.setPerforemedMedicalServices(medicalEvent.getPerforemedMedicalServices());
		medicalEventDTO.setRecommendedMedicalServices(medicalEvent.getRecommendedMedicalServices());
		medicalEventDTO.setRecomandedTreatment(medicalEvent.getRecomandedTreatment());
		medicalEventDTO.setDiseaseStatus(medicalEvent.getDiseaseStatus());
		medicalEventDTO.setEventStatus(medicalEvent.getEventStatus());
		medicalEventDTO.setEventDate(medicalEvent.getEventDate());
		medicalEventDTO.setDiagnostics(medicalEvent.getDiagnostics());
		medicalEventDTO.setClinic(medicalEvent.getClinic());
		medicalEventDTO.setSpeciality(medicalEvent.getSpeciality());
		return medicalEventDTO;
	}

	public List<MedicalEventDTO> medicalEventList2MedicalEventListDTO(List<MedicalEvent> allMedialEvents) {
		return allMedialEvents.stream().map(this::medicalEvent2MedicalEventDTO).collect(Collectors.toList());
	}

}
