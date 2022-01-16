package net.javaguides.springboot.dto;

import lombok.Data;
import net.javaguides.springboot.model.Institute;

@Data
public class InstituteDto extends UserDto {
	private String name;
	private String address;
	private String webSite;

	public InstituteDto(Institute user) {
		this.setId(user.getId());
		this.name = user.getName();
		this.address = user.getAddress();
		this.setEmail(user.getEmail());
		this.webSite = user.getWebSite();
		this.setPhoneNumber(user.getPhoneNumber());
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
