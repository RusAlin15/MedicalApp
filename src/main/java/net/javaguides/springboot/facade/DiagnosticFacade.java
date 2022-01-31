package net.javaguides.springboot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.dto.DiagnosticDTO;
import net.javaguides.springboot.dto.mapper.DiagnosticMapper;
import net.javaguides.springboot.model.Diagnostic;
import net.javaguides.springboot.service.DiagnosticService;

@Component
public class DiagnosticFacade {
	@Autowired
	private DiagnosticService diagnosticService;
	@Autowired
	private DiagnosticMapper diagnosticMapper;

	public DiagnosticDTO saveDiagnostic(DiagnosticDTO diagnosticDTO) {
		Diagnostic diagnostic = diagnosticMapper.diagnosticDTO2diagnostic(diagnosticDTO);
		return diagnosticMapper.diagnostic2diagnosticDTO(diagnosticService.saveDiagnostic(diagnostic));
	}

	public DiagnosticDTO saveDiagnostic(DiagnosticDTO diagnosticDTO, String diagnosticId) {
		Diagnostic diagnostic = diagnosticMapper.diagnosticDTO2diagnostic(diagnosticDTO);
		return diagnosticMapper.diagnostic2diagnosticDTO(diagnosticService.saveDiagnostic(diagnostic, diagnosticId));
	}

	public List<DiagnosticDTO> getAllDiagnostics() {
		return diagnosticMapper.diagnosticList2DiagnosticDTOList(diagnosticService.getAllDiagnostics());
	}

	public void deleteAllDiagnostics() {
		diagnosticService.deleteAllDiagnostics();
	}

	public DiagnosticDTO getDiagnosticById(String diagnosticId) {
		return diagnosticMapper.diagnostic2diagnosticDTO(diagnosticService.getDiagnosticById(diagnosticId));
	}

	public void deleteDiagnosticById(String diagnosticId) {
		diagnosticService.deleteDiagnosticById(diagnosticId);
	}

	public DiagnosticDTO updateDiagnostic(String diagnosticId, DiagnosticDTO diagnosticDTO) {
		Diagnostic diagnostic = diagnosticMapper.diagnosticDTO2diagnostic(diagnosticDTO);
		return diagnosticMapper.diagnostic2diagnosticDTO(diagnosticService.updateDiagnostic(diagnosticId, diagnostic));
	}
}
