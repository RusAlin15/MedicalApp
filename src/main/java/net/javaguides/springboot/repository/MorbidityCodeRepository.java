package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.MorbidityCode;

public interface MorbidityCodeRepository extends JpaRepository<MorbidityCode, Long> {

}
