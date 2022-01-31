package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.repository.MedicalEventRepository;

@Service
public class MedicalEventService {
	@Autowired
	private MedicalEventRepository eventRepository;

	public MedicalEvent saveMedicalEvent(MedicalEvent medicalEvent) {
		return eventRepository.save(medicalEvent);
	}

	public MedicalEvent updateEvent(long eventId, MedicalEvent event) {
		MedicalEvent event2Update = eventRepository.getById(eventId);
		event2Update.setId(event.getId());
		event2Update.setSympthoms(event.getSympthoms());
		event2Update.setSympthomsHistory(event.getSympthomsHistory());
		event2Update.setPresumtiveDiagnosis(event.getPresumtiveDiagnosis());
		event2Update.setPerforemedMedicalServices(event.getPerforemedMedicalServices());
		event2Update.setRecommendedMedicalServices(event.getRecommendedMedicalServices());
		event2Update.setRecomandedTreatment(event.getRecomandedTreatment());
		event2Update.setDiseaseStatus(event.getDiseaseStatus());
		event2Update.setEventStatus(event.getEventStatus());
		event2Update.setEventDate(event.getEventDate());
		event2Update.setDiagnostics(event.getDiagnostics());
		event2Update.setClinic(event.getClinic());
		event2Update.setSpeciality(event.getSpeciality());

		return eventRepository.saveAndFlush(event2Update);
	}

	public MedicalEvent getEventById(long eventId) {
		return eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Medical Event", "Id", eventId));
	}

	public List<MedicalEvent> getAllEvents() {
		return eventRepository.findAll();
	}

	public void deleteEventById(long eventId) {
		eventRepository.deleteById(eventId);
	}

	public void deleteAllEvents() {
		eventRepository.deleteAll();
	}

}
