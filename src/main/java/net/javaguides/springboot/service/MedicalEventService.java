package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.MedicalEvent;

public interface MedicalEventService {

	public MedicalEvent saveMedicalEvent(MedicalEvent medicalEvent);

	public List<MedicalEvent> getAllMedialEvents();

	public MedicalEvent getMedicalEventById(long id);

}
