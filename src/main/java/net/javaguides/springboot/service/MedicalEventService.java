package net.javaguides.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.MedicalEventDto;
import net.javaguides.springboot.enums.DiseaseStatus;
import net.javaguides.springboot.enums.EventStatus;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.repository.MedicalEventRepository;

@Service
public class MedicalEventService {
	@Autowired
	private MedicalEventRepository medicalEventRepository;

	public MedicalEventDto saveMedicalEvent(MedicalEvent medicalEvent) {
		medicalEvent.setDiseaseStatus(DiseaseStatus.valueOf(medicalEvent.getDiseaseStatus()).toString());
		medicalEvent.setEventStatus(EventStatus.valueOf(medicalEvent.getEventStatus()).toString());
		return convertToDto(medicalEventRepository.save(medicalEvent));
	}

	private MedicalEventDto convertToDto(MedicalEvent medicalEvent) {
		return new MedicalEventDto(medicalEvent);
	}

	public List<MedicalEventDto> getAllMedialEvents() {
		return medicalEventRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public MedicalEventDto getMedicalEventById(long id) {
		return convertToDto(medicalEventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medical Event", "Id", id)));
	}

}
