package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Doctor;
import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.model.Speciality;
import net.javaguides.springboot.model.Stage;
import net.javaguides.springboot.repository.DoctorRepository;
import net.javaguides.springboot.repository.InstitutionRepository;
import net.javaguides.springboot.repository.MedicalEventRepository;
import net.javaguides.springboot.repository.SpecialityRepository;
import net.javaguides.springboot.repository.StageRepository;
import net.javaguides.springboot.repository.userAccountRepository;
import net.javaguides.springboot.service.MedicalEventService;

@Service
public class MedicalEventServiceImpl implements MedicalEventService {

	private MedicalEventRepository medicalEventRepository;
	private userAccountRepository userAccountRepository;
	private SpecialityRepository specialityRepository;
	private InstitutionRepository institutionRepository;
	private StageRepository stageRepository;
	private DoctorRepository doctorRepository;

	public MedicalEventServiceImpl(MedicalEventRepository medicalEventRepository,
			userAccountRepository userAccountRepository, SpecialityRepository specialityRepository,
			InstitutionRepository institutionRepository, StageRepository stageRepository,
			DoctorRepository doctorRepository) {
		super();
		this.medicalEventRepository = medicalEventRepository;
		this.userAccountRepository = userAccountRepository;
		this.specialityRepository = specialityRepository;
		this.institutionRepository = institutionRepository;
		this.stageRepository = stageRepository;
		this.doctorRepository = doctorRepository;
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

	@Override
	public MedicalEvent setInstitution(long eventId, long institutionId) {

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		Institution institution = institutionRepository.findById(institutionId)
				.orElseThrow(() -> new ResourceNotFoundException("Institution", "Id", institutionId));

		medicalEvent.setInstitution(institution);
		return medicalEvent;
	}

	@Override
	public MedicalEvent setSpeciality(long eventId, long specialityId) {

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		Speciality speciality = specialityRepository.findById(specialityId)
				.orElseThrow(() -> new ResourceNotFoundException("Speciality", "Id", specialityId));

		medicalEvent.setSpeciality(speciality);
		return medicalEvent;
	}

	@Override
	public MedicalEvent setStage(long eventId, long stageId) {

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		Stage stage = stageRepository.findById(stageId)
				.orElseThrow(() -> new ResourceNotFoundException("Stage", "Id", stageId));

		medicalEvent.setStage(stage);
		return medicalEvent;
	}

	@Override
	public MedicalEvent setDoctor(long eventId, long doctorId) {

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		Doctor doctor = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));

		medicalEvent.setDoctor(doctor);
		return medicalEvent;
	}

}
