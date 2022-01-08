package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.model.DiseaseStatus;
import net.javaguides.springboot.model.Doctor;
import net.javaguides.springboot.model.Institution;
import net.javaguides.springboot.model.MedicalEvent;
import net.javaguides.springboot.model.MedicalEventStatus;
import net.javaguides.springboot.model.Speciality;
import net.javaguides.springboot.model.Status;
import net.javaguides.springboot.repository.DiagnosticRepository;
import net.javaguides.springboot.repository.DoctorRepository;
import net.javaguides.springboot.repository.InstitutionRepository;
import net.javaguides.springboot.repository.MedicalEventRepository;
import net.javaguides.springboot.repository.SpecialityRepository;
import net.javaguides.springboot.repository.StatusRepository;
import net.javaguides.springboot.service.MedicalEventService;

@Service
public class MedicalEventServiceImpl implements MedicalEventService {

	private MedicalEventRepository medicalEventRepository;
	private SpecialityRepository specialityRepository;
	private InstitutionRepository institutionRepository;
	private DoctorRepository doctorRepository;
	private StatusRepository statusRepository;
	private DiagnosticRepository diagnosticRepository;

	public MedicalEventServiceImpl(MedicalEventRepository medicalEventRepository,
			net.javaguides.springboot.repository.userAccountRepository userAccountRepository,
			SpecialityRepository specialityRepository, InstitutionRepository institutionRepository,
			DoctorRepository doctorRepository, StatusRepository statusRepository,
			DiagnosticRepository diagnosticRepository) {
		super();
		this.medicalEventRepository = medicalEventRepository;
		this.specialityRepository = specialityRepository;
		this.institutionRepository = institutionRepository;
		this.doctorRepository = doctorRepository;
		this.statusRepository = statusRepository;
		this.diagnosticRepository = diagnosticRepository;
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
		medicalEventRepository.save(medicalEvent);
		return medicalEvent;
	}

	@Override
	public MedicalEvent setSpeciality(long eventId, long specialityId) {

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		Speciality speciality = specialityRepository.findById(specialityId)
				.orElseThrow(() -> new ResourceNotFoundException("Speciality", "Id", specialityId));

		medicalEvent.setSpeciality(speciality);
		medicalEventRepository.save(medicalEvent);
		return medicalEvent;
	}

	@Override
	public MedicalEvent setDiseaseStatus(long eventId, long diseaseStatusId) {

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		Status status = statusRepository.findById(diseaseStatusId)
				.orElseThrow(() -> new ResourceNotFoundException("Status", "Id", diseaseStatusId));

		if (status instanceof DiseaseStatus) {
			medicalEvent.setDeseaseStatus((DiseaseStatus) status);
		} else {
			throw new InvalidDataException("DiseaseStatus", "Id", diseaseStatusId);
		}
		medicalEventRepository.save(medicalEvent);
		return medicalEvent;
	}

	@Override
	public MedicalEvent setEventStatus(long eventId, long eventstatusId) {

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		Status status = statusRepository.findById(eventstatusId)
				.orElseThrow(() -> new ResourceNotFoundException("Status", "Id", eventstatusId));

		if (status instanceof MedicalEventStatus) {
			medicalEvent.setMedicalEventStatus((MedicalEventStatus) status);
		} else {
			throw new InvalidDataException("MedicalEventStatus", "Id", eventstatusId);
		}

		medicalEventRepository.save(medicalEvent);
		return medicalEvent;
	}

	@Override
	public MedicalEvent setDoctor(long eventId, long doctorId) {

		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		Doctor doctor = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));

		medicalEvent.setDoctor(doctor);
		medicalEventRepository.save(medicalEvent);
		return medicalEvent;
	}

	@Override
	public MedicalEvent addDiagnostic(long eventId, String diagnosticIcd) {
		MedicalEvent medicalEvent = medicalEventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("MedicalEvent", "Id", eventId));

		Diagnostic diagnostic = diagnosticRepository.findById(diagnosticIcd)
				.orElseThrow(() -> new ResourceNotFoundException("Diagnostic", "Id", diagnosticIcd));

		if (diagnostic.isFinalDiagnostic()) {
			System.out.println("trsre");
			medicalEvent.addDiagnostic(diagnostic);
		} else {
			throw new InvalidDataException("Diagnostic", "ICD-10", diagnosticIcd);
		}
		medicalEventRepository.save(medicalEvent);
		return medicalEvent;
	}

}
