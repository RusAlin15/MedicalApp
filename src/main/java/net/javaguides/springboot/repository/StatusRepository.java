package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
