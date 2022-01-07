package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.ReferralTicket;
import net.javaguides.springboot.repository.ReferralTicketRepository;
import net.javaguides.springboot.service.ReferralTicketService;

@Service
public class ReferralTicketServiceImpl implements ReferralTicketService {
	private ReferralTicketRepository referralTicketRepository;

	public ReferralTicketServiceImpl(ReferralTicketRepository referralTicketRepository) {
		super();
		this.referralTicketRepository = referralTicketRepository;
	}

	@Override
	public ReferralTicket saveReferralTicket(ReferralTicket referralTicket) {
		return referralTicketRepository.save(referralTicket);
	}

	@Override
	public List<ReferralTicket> getAllReferralTickets() {
		return referralTicketRepository.findAll();
	}

}
