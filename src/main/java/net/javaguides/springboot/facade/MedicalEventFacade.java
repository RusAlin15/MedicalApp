package net.javaguides.springboot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.dto.MedicalEventDTO;
import net.javaguides.springboot.dto.mapper.MedicalEventMapper;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.service.MedicalEventService;

@Component
public class MedicalEventFacade {
	@Autowired
	private MedicalEventService eventService;
	@Autowired
	private MedicalEventMapper eventMapper;

	public MedicalEventDTO saveEvent(MedicalEventDTO eventDTO) {
		MedicalEvent event = eventMapper.medicalEventDTO2MedicalEvent(eventDTO);
		return eventMapper.medicalEvent2MedicalEventDTO(eventService.saveMedicalEvent(event));
	}

	public List<MedicalEventDTO> getAllEvents() {
		return eventMapper.medicalEventList2MedicalEventListDTO(eventService.getAllEvents());
	}

	public MedicalEventDTO getEventById(long eventId) {
		return eventMapper.medicalEvent2MedicalEventDTO(eventService.getEventById(eventId));
	}

	public void deleteAllEvents() {
		eventService.deleteAllEvents();
	}

	public void deleteEventById(long eventId) {
		eventService.deleteEventById(eventId);
	}

	public MedicalEventDTO updateEvent(long eventId, MedicalEventDTO eventDTO) {
		MedicalEvent event = eventMapper.medicalEventDTO2MedicalEvent(eventDTO);
		return eventMapper.medicalEvent2MedicalEventDTO(eventService.updateEvent(eventId, event));
	}

}
