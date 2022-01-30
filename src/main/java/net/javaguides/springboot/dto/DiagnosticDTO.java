package net.javaguides.springboot.dto;

public class DiagnosticDTO {

	private String icdCode;
	private String titleName;
	private boolean finalDiagnostic;

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public boolean isFinalDiagnostic() {
		return finalDiagnostic;
	}

	public void setFinalDiagnostic(boolean finalDiagnostic) {
		this.finalDiagnostic = finalDiagnostic;
	}

}
