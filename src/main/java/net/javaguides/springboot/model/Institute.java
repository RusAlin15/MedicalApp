package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public abstract class Institute extends User {
	@NotEmpty
	@Size(min = 5)
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Size(min = 10)
	@Column(name = "address", nullable = true)
	private String address;

	@Size(min = 10)
	@Column(name = "webSite", unique = true)
	private String webSite;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

}
