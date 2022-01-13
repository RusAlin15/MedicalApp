package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.ReferralTicket;
import net.javaguides.springboot.repository.ReferralTicketRepository;

@Service
public class ReferralTicketService {
	@Autowired
	private ReferralTicketRepository referralTicketRepository;

	public ReferralTicket saveReferralTicket(ReferralTicket referralTicket) {
		return referralTicketRepository.save(referralTicket);
	}

	public List<ReferralTicket> getAllReferralTickets() {
		return referralTicketRepository.findAll();
	}

}
