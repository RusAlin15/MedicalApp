package net.javaguides.springboot.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.DiagnosticDTO;
import net.javaguides.springboot.model.Diagnostic;

@Service
public class DiagnosticMapper {

	public Diagnostic diagnosticDTO2diagnostic(DiagnosticDTO diagnosticDTO) {
		Diagnostic diagnostic = new Diagnostic();
		diagnostic.setIcdCode(diagnosticDTO.getIcdCode());
		diagnostic.setTitleName(diagnosticDTO.getTitleName());
		diagnostic.setFinalDiagnostic(diagnosticDTO.isFinalDiagnostic());
		return diagnostic;
	}

	public DiagnosticDTO diagnostic2diagnosticDTO(Diagnostic diagnostic) {
		DiagnosticDTO diagnosticDTO = new DiagnosticDTO();
		diagnosticDTO.setIcdCode(diagnostic.getIcdCode());
		diagnosticDTO.setTitleName(diagnostic.getTitleName());
		diagnosticDTO.setFinalDiagnostic(diagnostic.isFinalDiagnostic());
		return diagnosticDTO;
	}

	public List<DiagnosticDTO> diagnosticList2DiagnosticDTOList(List<Diagnostic> allDiagnostics) {
		return allDiagnostics.stream().map(this::diagnostic2diagnosticDTO).collect(Collectors.toList());
	}

}
