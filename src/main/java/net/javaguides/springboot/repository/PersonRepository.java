package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
