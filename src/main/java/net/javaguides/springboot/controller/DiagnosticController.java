package net.javaguides.springboot.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.service.DiagnosticService;

@RestController
@RequestMapping("api/diagnostic")
public class DiagnosticController {
	DiagnosticService diagnosticService;

	public DiagnosticController(DiagnosticService diagnosticService) {
		super();
		this.diagnosticService = diagnosticService;
	}

	@PostMapping
	public ResponseEntity<Diagnostic> saveDiagnostic(@RequestBody Diagnostic diagnostic) {
		return new ResponseEntity<Diagnostic>(diagnosticService.saveDiagnostic(diagnostic), HttpStatus.CREATED);
	}

	@PostMapping("/{diagnosticId}")
	public ResponseEntity<Diagnostic> saveDiagnostic(@RequestBody Diagnostic diagnostic,
			@PathVariable String diagnosticId) {
		return new ResponseEntity<Diagnostic>(diagnosticService.saveDiagnostic(diagnostic, diagnosticId),
				HttpStatus.CREATED);
	}

	@GetMapping
	public List<Diagnostic> getAllDiagnostics() {
		return diagnosticService.getAllDiagnostics();
	}

	@Transactional
	@DeleteMapping()
	public ResponseEntity<String> deleteAllDiagnostics() {
		diagnosticService.deleteAllDiagnostics();
		return new ResponseEntity<String>("Diagnostics deleted successfuly!", HttpStatus.OK);
	}

}
