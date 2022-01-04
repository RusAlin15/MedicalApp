package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "morbidities")
public class MorbidityCode {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@OneToMany(targetEntity = Diagnostic.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "morbidity_code_fk", referencedColumnName = "id")
	private List<Diagnostic> diagnostics;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public void addDiagnostic(Diagnostic diagnostic) {
		diagnostics.add(diagnostic);

	}

//    {
//    "id": 5,
//    "title": "Diareea şi gastro-enterita probabil infecţioase"
//}
//    {
//    "id": 3,
//    "title": "Sigeloza"
//}
//
//    {
//    "id": 4,
//    "title": "Amibiaza"
//}
//
//{
//    "id": 6,
//    "title": "Alte boli infecţioase intestinale"
//}
//{
//    "id": 2,
//    "title": "Febre tifoide şi paratifoide"
//}
//
//{
//    "id": 1,
//    "title": "Holera"
//}

}
