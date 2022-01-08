package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Institution extends UserAccount {

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "webSite", unique = true)
	private String webSite;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
}
