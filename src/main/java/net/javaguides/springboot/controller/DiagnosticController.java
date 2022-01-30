package net.javaguides.springboot.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.DiagnosticDTO;
import net.javaguides.springboot.dto.mapper.DiagnosticMapper;
import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.service.DiagnosticService;

@RestController
@RequestMapping("api/diagnostic")
public class DiagnosticController {

	@Autowired
	DiagnosticService diagnosticService;

	@Autowired
	DiagnosticMapper diagnosticMapper;

	@PostMapping
	public ResponseEntity<DiagnosticDTO> createDiagnostic(@RequestBody DiagnosticDTO diagnosticDTO) {
		Diagnostic diagnostic = diagnosticMapper.diagnosticDTO2diagnostic(diagnosticDTO);
		diagnosticDTO = diagnosticMapper.diagnostic2diagnosticDTO(diagnosticService.createDiagnostic(diagnostic));
		return new ResponseEntity<DiagnosticDTO>(diagnosticDTO, HttpStatus.CREATED);
	}

	@PostMapping("/{diagnosticId}")
	public ResponseEntity<DiagnosticDTO> saveDiagnostic(@RequestBody Diagnostic diagnostic,
			@PathVariable String diagnosticId) {
		return new ResponseEntity<DiagnosticDTO>(diagnosticService.saveDiagnostic(diagnostic, diagnosticId),
				HttpStatus.CREATED);
	}

	@GetMapping
	public List<DiagnosticDTO> getAllDiagnostics() {
		return diagnosticService.getAllDiagnostics();
	}

	@Transactional
	@DeleteMapping()
	public ResponseEntity<String> deleteAllDiagnostics() {
		diagnosticService.deleteAllDiagnostics();
		return new ResponseEntity<String>("Diagnostics deleted successfuly!", HttpStatus.OK);
	}

}
