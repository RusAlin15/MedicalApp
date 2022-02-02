package net.javaguides.springboot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.dto.ReferralTicketDTO;
import net.javaguides.springboot.dto.mapper.ReferralTIcketMapper;
import net.javaguides.springboot.model.ReferralTicket;
import net.javaguides.springboot.service.ReferralTicketService;

@Component
public class RefferalTicketFacade {
	@Autowired
	private ReferralTicketService ticketService;

	@Autowired
	private ReferralTIcketMapper ticketMapper;

	public ReferralTicketDTO saveTicket(ReferralTicketDTO ticketDTO) {
		ReferralTicket ticket = ticketMapper.ticketDTO2Ticket(ticketDTO);
		return ticketMapper.ticket2TicketDTO(ticketService.saveTicket(ticket));
	}

	public ReferralTicketDTO updateTicket(long ticketId, ReferralTicketDTO ticketDTO) {
		ReferralTicket ticket = ticketMapper.ticketDTO2Ticket(ticketDTO);
		return ticketMapper.ticket2TicketDTO(ticketService.updateTicket(ticketId, ticket));
	}

	public ReferralTicketDTO getTicketById(long ticketId) {
		return ticketMapper.ticket2TicketDTO(ticketService.getTicketById(ticketId));
	}

	public List<ReferralTicketDTO> getAllTickets() {
		return ticketMapper.ticketList2TicketListDTO(ticketService.getAllTickets());
	}

	public void deleteTicketById(long ticketId) {
		ticketService.deleteTicketById(ticketId);
	}

	public void deleteAllTickets() {
		ticketService.deleteAllTickets();
	}

}
