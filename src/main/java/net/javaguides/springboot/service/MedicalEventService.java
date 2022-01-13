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
	private MedicalEventRepository medicalEventRepository;

	public MedicalEvent saveMedicalEvent(MedicalEvent medicalEvent) {
		return medicalEventRepository.save(medicalEvent);
	}

	public List<MedicalEvent> getAllMedialEvents() {
		return medicalEventRepository.findAll();
	}

	public MedicalEvent getMedicalEventById(long id) {
		return medicalEventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medical Event", "Id", id));
	}

}
