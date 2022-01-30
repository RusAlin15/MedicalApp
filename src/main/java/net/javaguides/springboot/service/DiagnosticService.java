package net.javaguides.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.DiagnosticDTO;
import net.javaguides.springboot.exception.InvalidDataException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.repository.DiagnosticRepository;

@Service
public class DiagnosticService {
	@Autowired
	private DiagnosticRepository diagnosticRepository;

	public Diagnostic createDiagnostic(Diagnostic diagnostic) {
		diagnostic.setFinalDiagnostic(false);
		return diagnosticRepository.save(diagnostic);
	}

	public DiagnosticDTO saveDiagnostic(Diagnostic diagnostic, String diagnosticId) {
		Diagnostic diagnosticCap = diagnosticRepository.findById(diagnosticId)
				.orElseThrow(() -> new ResourceNotFoundException("Diagnostic", "Id", diagnosticId));
		if (!diagnosticCap.equals(diagnostic)) {
			diagnosticCap.addSubDiagnostics(diagnostic);
		} else {
			throw new InvalidDataException("SameData", "Id", diagnosticId);
		}
		return convertToDto(diagnosticRepository.save(diagnostic));
	}

	public List<DiagnosticDTO> getAllDiagnostics() {
		return diagnosticRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public void deleteAllDiagnostics() {
		diagnosticRepository.deleteAll();
	};

}
