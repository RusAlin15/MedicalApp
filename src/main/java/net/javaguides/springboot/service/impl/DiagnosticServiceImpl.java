package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.repository.DiagnosticRepository;
import net.javaguides.springboot.service.DiagnosticService;

@Service
public class DiagnosticServiceImpl implements DiagnosticService {
	DiagnosticRepository diagnosticRepository;

	public DiagnosticServiceImpl(DiagnosticRepository diagnosticRepository) {
		super();
		this.diagnosticRepository = diagnosticRepository;
	}

	@Override
	public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
		diagnostic.setFinalDiagnostic(false);
		return diagnosticRepository.save(diagnostic);
	}

	@Override
	public Diagnostic saveDiagnostic(Diagnostic diagnostic, String diagnosticId) {
		Diagnostic diagnosticCap = diagnosticRepository.findById(diagnosticId)
				.orElseThrow(() -> new ResourceNotFoundException("Diagnostic", "Id", diagnosticId));
		diagnosticCap.subDiagnostics(diagnostic);
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
