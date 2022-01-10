package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.MedicalEvent;

public interface MedicalEventService {

	public List<MedicalEvent> getAllMedialEvents();

	public MedicalEvent getMedicalEventById(long id);

	public MedicalEvent saveMedicalEvent(MedicalEvent medicalEvent);

	public MedicalEvent setClinic(long eventId, long clinicId);

	public MedicalEvent setSpeciality(long eventId, long specialityId);

	public MedicalEvent setDoctor(long eventId, long doctorId);

	public MedicalEvent addDiagnostic(long eventId, String diagnosticIcd);

	public MedicalEvent setStatus(long eventId, long statusId);

}
