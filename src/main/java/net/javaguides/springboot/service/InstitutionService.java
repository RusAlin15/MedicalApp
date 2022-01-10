package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Institution;

public interface InstitutionService {

	Institution setInstitutionAccount(long accountId, long patientId);

	Institution saveInstitution(Institution institution);

	List<Institution> getAllInstitutions();

}
