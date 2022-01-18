package net.javaguides.springboot.dto;

import java.time.LocalDate;

import lombok.Data;
import net.javaguides.springboot.model.ReferralTicket;

@Data
public class ReferralTicketDto {
	private Long id;
	private String description;
	private LocalDate resultDate;

	public ReferralTicketDto(ReferralTicket referalTichet) {
		this.id = referalTichet.getId();
		this.description = referalTichet.getDescription();
		this.resultDate = referalTichet.getResultDate();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getResultDate() {
		return resultDate;
	}

}
