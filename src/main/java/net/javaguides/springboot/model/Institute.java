package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "institute", schema = "administration")
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
}
