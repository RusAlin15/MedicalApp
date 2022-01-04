package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
