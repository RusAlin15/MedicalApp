package net.javaguides.springboot.model;

import java.util.List;
import java.util.Objects;

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
@Table(name = "diagnostic", schema = "administration")
public class Diagnostic {

	@Id
	@Column(name = "icd_code", unique = true)
	private String icdCode;

	@Column(name = "title_name", nullable = false)
	private String titleName;

	@Column(name = "final_diagnostic", nullable = false)
	private boolean finalDiagnostic;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "diagnostic_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Diagnostic> subDiagnostics;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diagnostic other = (Diagnostic) obj;
		return Objects.equals(icdCode, other.icdCode);
	}

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

	public void addSubDiagnostics(Diagnostic diagnostic) {
		this.subDiagnostics.add(diagnostic);
	}

}