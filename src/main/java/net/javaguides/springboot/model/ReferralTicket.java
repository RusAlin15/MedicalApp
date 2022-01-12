package net.javaguides.springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "referral_ticket")
public class ReferralTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "description")
	private String description;

	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name = "result_date")
	private LocalDate resultDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "referral_ticket_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private MedicalEvent medicalEvent;

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

	public Long getId() {
		return id;
	}
}
