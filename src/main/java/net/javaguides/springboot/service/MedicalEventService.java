package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.MedicalEvent;

public interface MedicalEventService {

	public List<MedicalEvent> getAllMedialEvents();

	public MedicalEvent getMedicalEventById(long id);

	public MedicalEvent saveMedicalEvent(MedicalEvent medicalEvent);

	public MedicalEvent setInstitution(long eventId, long institutionId);

	public MedicalEvent setSpeciality(long eventId, long specialityId);

	public MedicalEvent setStage(long eventId, long stageId);

	public MedicalEvent setDoctor(long eventId, long doctorId);

}
