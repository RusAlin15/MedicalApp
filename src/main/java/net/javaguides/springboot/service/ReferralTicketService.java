package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.ReferralTicket;
import net.javaguides.springboot.repository.ReferralTicketRepository;

@Service
public class ReferralTicketService {
	@Autowired
	private ReferralTicketRepository ticketRepository;

	public ReferralTicket saveTicket(ReferralTicket referralTicket) {
		return ticketRepository.save(referralTicket);
	}

	public ReferralTicket updateTicket(long ticketId, ReferralTicket ticket) {
		ReferralTicket ticket2Update = ticketRepository.getById(ticketId);
		ticket2Update.setId(ticket.getId());
		ticket2Update.setDescription(ticket.getDescription());
		ticket2Update.setResultDate(ticket.getResultDate());
		ticket2Update.setMedicalEvent(ticket.getMedicalEvent());

		return ticketRepository.saveAndFlush(ticket2Update);
	}

	public ReferralTicket getTicketById(long ticketId) {
		return ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Refferal Ticket", "Id", ticketId));
	}

	public List<ReferralTicket> getAllTickets() {
		return ticketRepository.findAll();
	}

}
