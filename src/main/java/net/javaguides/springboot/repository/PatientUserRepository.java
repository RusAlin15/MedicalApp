package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.PatientUser;

public interface PatientUserRepository extends JpaRepository<PatientUser, Long> {

}
