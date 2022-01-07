package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Stage;

public interface StageRepository extends JpaRepository<Stage, Long> {

}
