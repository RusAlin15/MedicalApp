package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.UserAccount;

public interface userAccountRepository extends JpaRepository<UserAccount, Long> {

}
