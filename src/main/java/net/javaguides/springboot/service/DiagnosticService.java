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
	private DiagnosticRepository diagnosticRepository;

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
			throw new InvalidDataException("Existing already ", "Id", diagnosticId);
		}
		return diagnosticRepository.save(diagnostic);
	}

	public Diagnostic updateDiagnostic(String diagnosticId, Diagnostic diagnostic) {
		Diagnostic diagnostic2Update = getDiagnosticById(diagnosticId);

		diagnostic2Update.setIcdCode(diagnostic.getIcdCode());
		diagnostic2Update.setTitleName(diagnostic.getTitleName());
		diagnostic2Update.setSubDiagnostics(diagnostic.getSubDiagnostics());
		diagnostic2Update.setFinalDiagnostic(diagnostic.isFinalDiagnostic());
		return diagnosticRepository.saveAndFlush(diagnostic2Update);
	}

	public Diagnostic getDiagnosticById(String diagnosticId) {
		return diagnosticRepository.findById(diagnosticId)
				.orElseThrow(() -> new ResourceNotFoundException("Diagnostic", "Id", diagnosticId));
	}

	public List<Diagnostic> getAllDiagnostics() {
		return diagnosticRepository.findAll();
	}

	public void deleteDiagnosticById(String diagnosticId) {
		diagnosticRepository.deleteById(diagnosticId);
	}

	public void deleteAllDiagnostics() {
		diagnosticRepository.deleteAll();
	}

}
