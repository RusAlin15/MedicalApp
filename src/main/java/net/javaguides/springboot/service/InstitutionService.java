package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Institution;

public interface InstitutionService {

	Institution saveInstitution(Institution institution);

	List<Institution> getAllInstitutions();

}
