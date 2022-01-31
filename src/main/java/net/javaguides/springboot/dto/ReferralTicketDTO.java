package net.javaguides.springboot.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReferralTicketDTO {
	private Long id;
	private String description;
	private LocalDate resultDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getResultDate() {
		return resultDate;
	}

	public void setResultDate(LocalDate resultDate) {
		this.resultDate = resultDate;
	}

}
