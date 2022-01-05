package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.MedicalEvent;

public interface MedicalEventService {

	public MedicalEvent saveMedicalEvent(MedicalEvent medicalEvent, long accountId, long specialityId,
			long institutionId);

	public List<MedicalEvent> getAllMedialEvents();

	public MedicalEvent getMedicalEventById(long id);

}
