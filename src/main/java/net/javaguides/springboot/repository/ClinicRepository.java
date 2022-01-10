package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {

}
