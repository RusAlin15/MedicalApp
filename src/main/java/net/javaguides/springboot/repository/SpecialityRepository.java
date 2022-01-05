package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

}
