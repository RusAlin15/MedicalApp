package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
