package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.model.MorbidityCode;
import net.javaguides.springboot.repository.DiagnosticRepository;
import net.javaguides.springboot.repository.MorbidityCodeRepository;
import net.javaguides.springboot.service.DiagnosticService;

@Service
public class DiagnosticServiceImpl implements DiagnosticService {
	DiagnosticRepository diagnosticRepository;
	MorbidityCodeRepository morbidityCodeRepository;

	public DiagnosticServiceImpl(DiagnosticRepository diagnosticRepository,
			MorbidityCodeRepository morbidityCodeRepository) {
		super();
		this.diagnosticRepository = diagnosticRepository;
		this.morbidityCodeRepository = morbidityCodeRepository;
	}

	@Override
	public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
		Long id = diagnostic.getMorbidityCodeId();
		MorbidityCode morbidityCode = morbidityCodeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("MorbidityCode", "Id", id));

		morbidityCode.addDiagnostic(diagnostic);
		return diagnosticRepository.save(diagnostic);
	}

	@Override
	public List<Diagnostic> getAllDiagnostics() {
		return diagnosticRepository.findAll();
	}

	@Override
	public void deleteAllDiagnostics() {
		diagnosticRepository.deleteAll();
	};

}
