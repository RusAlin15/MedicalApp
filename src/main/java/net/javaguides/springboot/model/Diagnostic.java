package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "diagnostic")
public class Diagnostic {

	@Id
	@Column(name = "icd_code")
	private String icdCode;

	@Column(name = "title_name", nullable = false)
	private String titleName;

	@Column(name = "final_diagnostic", nullable = false)
	private boolean finalDiagnostic;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "diagnostic_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Diagnostic> subDiagnostics;

	public boolean isFinalDiagnostic() {
		return finalDiagnostic;
	}

	public void setFinalDiagnostic(boolean finalDiagnostic) {
		this.finalDiagnostic = finalDiagnostic;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public List<Diagnostic> getSubDiagnostics() {
		return subDiagnostics;
	}

	public void subDiagnostics(Diagnostic diagnostic) {
		this.subDiagnostics.add(diagnostic);

	}
}