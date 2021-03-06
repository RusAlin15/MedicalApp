package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findByCnp(String cnp);

}
