package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.repository.DiagnosticRepository;

@Service
public class DiagnosticService {
	@Autowired
	DiagnosticRepository diagnosticRepository;

	public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
		diagnostic.setFinalDiagnostic(false);
		return diagnosticRepository.save(diagnostic);
	}

	public Diagnostic saveDiagnostic(Diagnostic diagnostic, String diagnosticId) {
		Diagnostic diagnosticCap = diagnosticRepository.findById(diagnosticId)
				.orElseThrow(() -> new ResourceNotFoundException("Diagnostic", "Id", diagnosticId));
		if (!diagnosticCap.equals(diagnostic)) {
			diagnosticCap.addSubDiagnostics(diagnostic);
		} else {
			throw new InvalidDataException("SameData", "Id", diagnosticId);
		}
		return diagnosticRepository.save(diagnostic);
	}

	public List<Diagnostic> getAllDiagnostics() {
		return diagnosticRepository.findAll();
	}

	public void deleteAllDiagnostics() {
		diagnosticRepository.deleteAll();
	};

}
