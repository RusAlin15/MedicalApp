package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.repository.MedicalEventRepository;
import net.javaguides.springboot.service.MedicalEventService;

@Service
public class MedicalEventServiceImpl implements MedicalEventService {

	private MedicalEventRepository medicalEventRepository;

	public MedicalEventServiceImpl(MedicalEventRepository medicalEventRepository) {
		super();
		this.medicalEventRepository = medicalEventRepository;
	}

	@Override
	public MedicalEvent saveMedicalEvent(MedicalEvent medicalEvent) {
		return medicalEventRepository.save(medicalEvent);
	}

	@Override
	public List<MedicalEvent> getAllMedialEvents() {
		return medicalEventRepository.findAll();
	}

	@Override
	public MedicalEvent getMedicalEventById(long id) {
		return medicalEventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medical Event", "Id", id));
	}

}
