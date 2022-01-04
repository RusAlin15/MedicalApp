package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Diagnostic;

public interface DiagnosticService {

	Diagnostic saveDiagnostic(Diagnostic diagnostic);

	List<Diagnostic> getAllDiagnostics();

	void deleteAllDiagnostics();

}
