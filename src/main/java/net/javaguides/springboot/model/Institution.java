package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer", "FieldHandler" })
@Entity
@Data
@Table(name = "institutions")
public class Institution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

//	@Column(name = "phone_nr", nullable = false)
//	private String[] phoneNr;

//	@Column(name = "location", nullable = false)
//	private Location location; 

	@Column(name = "webSite")
	private String webSite;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Long getId() {
		return id;
	}

}
