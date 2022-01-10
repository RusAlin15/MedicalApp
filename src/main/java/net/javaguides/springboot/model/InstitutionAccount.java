package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class InstitutionAccount extends UserAccount {

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_account_id_fk")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<ClinicAccount> clinicAccounts;

	public List<ClinicAccount> getClinics() {
		return clinicAccounts;
	}

	public void addClinic(ClinicAccount clinicAccount) {
		this.clinicAccounts.add(clinicAccount);
	}

}
