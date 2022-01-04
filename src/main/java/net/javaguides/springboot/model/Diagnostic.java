package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "diagnostic")
public class Diagnostic {

	@Id
	@Column(name = "icd_code")
	private String icdCode;

	@Column(name = "title")
	private String title;

	@Column(name = "scientific_title", nullable = false)
	private String scientificTitle;

	@Transient
	private Long morbidityCodeId;

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getScientificTitle() {
		return scientificTitle;
	}

	public void setScientificTitle(String scientificTitle) {
		this.scientificTitle = scientificTitle;
	}

	@Transient
	public Long getMorbidityCodeId() {
		return morbidityCodeId;
	}

//	{
//	    "icdCode": "A2.0",
//	    "title":"Enterita cu salmonella",
//	    "scientificTitle":"Enteritis salmonellosa",
//	    "morbidityCodeId":6
//
//	}
//	{
//	    "icdCode": "A01.4",
//	    "title":"Paratifos, nespecificat",
//	    "scientificTitle":"Paratyphus, non specificatus",
//	    "morbidityCodeId":2
//
//	}
//	{
//	    "icdCode": "A01.3",
//	    "title":"Paratifosul C",
//	    "scientificTitle":"Paratyphus C",
//	    "morbidityCodeId":2
//
//	}
//	{
//	    "icdCode": "A01.2",
//	    "title":"Paratifosul B",
//	    "scientificTitle":"Paratyphus B",
//	    "morbidityCodeId":2
//
//	}
//	{
//	    "icdCode": "A01.1",
//	    "title":"Paratifosul A",
//	    "scientificTitle":"Paratyphus A",
//	    "morbidityCodeId":2
//
//	}
//	{
//	    "icdCode": "A01.0",
//	    "title":"Febra tifoida",
//	    "scientificTitle":"Typhus abdominalis",
//	    "morbidityCodeId":2
//
//	}
//	{
//	    "icdCode": "A00.1",
//	    "title":"Holera cu vibrio cholerae 01, biovar eltor",
//	    "scientificTitle":"Cholera El Tor",
//	    "morbidityCodeId":1
//
//	}
//	{
//	    "icdCode": "A00.0",
//	    "title":"Holera cu vibrio cholerae 01, biovar cholerae",
//	    "scientificTitle":"Cholera classica",
//	    "morbidityCodeId":1
//
//	}

}
