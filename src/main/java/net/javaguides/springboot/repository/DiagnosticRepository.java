package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Diagnostic;

public interface DiagnosticRepository extends JpaRepository<Diagnostic, String> {

}
