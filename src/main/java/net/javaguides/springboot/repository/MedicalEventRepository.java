package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.MedicalEvent;

public interface MedicalEventRepository extends JpaRepository<MedicalEvent, Long> {

}
