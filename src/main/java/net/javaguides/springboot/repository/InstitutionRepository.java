package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
