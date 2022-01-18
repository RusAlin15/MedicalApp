package net.javaguides.springboot.dto;

import net.javaguides.springboot.model.Diagnostic;

public class DiagnosticDto {

	private String icdCode;
	private String titleName;
	private boolean finalDiagnostic;

	public DiagnosticDto(Diagnostic diagnostic) {
		this.icdCode = diagnostic.getIcdCode();
		this.titleName = diagnostic.getTitleName();
		this.finalDiagnostic = diagnostic.getFinalDiagnostic();
	}

	public String getIcdCode() {
		return icdCode;
	}

	public String getTitleName() {
		return titleName;
	}

	public boolean isFinalDiagnostic() {
		return finalDiagnostic;
	}

}
