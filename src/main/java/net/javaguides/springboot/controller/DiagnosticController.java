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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.DiagnosticDTO;
import net.javaguides.springboot.facade.DiagnosticFacade;

@RestController
@RequestMapping("diagnostic")
public class DiagnosticController {
	@Autowired
	private DiagnosticFacade diagnosticFacade;

	@PostMapping
	public ResponseEntity<DiagnosticDTO> saveDiagnostic(@RequestBody DiagnosticDTO diagnosticDTO) {
		return new ResponseEntity<DiagnosticDTO>(diagnosticFacade.saveDiagnostic(diagnosticDTO), HttpStatus.CREATED);
	}

	@PostMapping("/{diagnosticId}")
	public ResponseEntity<DiagnosticDTO> saveDiagnostic(@RequestBody DiagnosticDTO diagnosticDTO,
			@PathVariable String diagnosticId) {
		return new ResponseEntity<DiagnosticDTO>(diagnosticFacade.saveDiagnostic(diagnosticDTO, diagnosticId),
				HttpStatus.CREATED);
	}

	@PutMapping("/{diagnosticId")
	public ResponseEntity<DiagnosticDTO> updateDiagnostic(@PathVariable("diagnosticID") String diagnosticId,
			@RequestBody DiagnosticDTO diagnosticDTO) {
		return new ResponseEntity<DiagnosticDTO>(diagnosticFacade.updateDiagnostic(diagnosticId, diagnosticDTO),
				HttpStatus.OK);
	}

	@GetMapping("/{diagnosticId}")
	public ResponseEntity<DiagnosticDTO> getDiagnosticById(@RequestBody String diagnosticId) {
		return new ResponseEntity<DiagnosticDTO>(diagnosticFacade.getDiagnosticById(diagnosticId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<DiagnosticDTO>> getAllDiagnostics() {
		return new ResponseEntity<List<DiagnosticDTO>>(diagnosticFacade.getAllDiagnostics(), HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping("/{diagnosticId}")
	public ResponseEntity<String> deleteDiagnosticById(@RequestBody String diagnosticId) {
		diagnosticFacade.deleteDiagnosticById(diagnosticId);
		return new ResponseEntity<String>("Diagnostic successfuly deleted!", HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping
	public ResponseEntity<String> deleteAllDiagnostics() {
		diagnosticFacade.deleteAllDiagnostics();
		return new ResponseEntity<String>("Diagnostic successfuly deleted!", HttpStatus.OK);
	}

}
