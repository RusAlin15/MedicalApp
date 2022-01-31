package net.javaguides.springboot.dto;

import lombok.Data;
import net.javaguides.springboot.model.Institute;

@Data
public class InstituteDTO extends UserDTO {
	private String name;
	private String address;
	private String webSite;

	public InstituteDTO(Institute user) {
		super(user);

		this.name = user.getName();
		this.address = user.getAddress();
		this.webSite = user.getWebSite();
	}

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
