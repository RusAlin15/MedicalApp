package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.ReferralTicket;

public interface ReferralTicketRepository extends JpaRepository<ReferralTicket, Long> {

}
