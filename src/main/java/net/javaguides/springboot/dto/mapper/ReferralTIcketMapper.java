package net.javaguides.springboot.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.ReferralTicketDTO;
import net.javaguides.springboot.model.ReferralTicket;

@Service
public class ReferralTIcketMapper {

	public ReferralTicket ticketDTO2Ticket(ReferralTicketDTO ticketDTO) {
		ReferralTicket ticket = new ReferralTicket();
		ticket.setId(ticketDTO.getId());
		ticket.setDescription(ticketDTO.getDescription());
		ticket.setResultDate(ticketDTO.getResultDate());
		return ticket;
	}

	public ReferralTicketDTO ticket2TicketDTO(ReferralTicket ticket) {
		ReferralTicketDTO ticketDTO = new ReferralTicketDTO();
		ticketDTO.setId(ticket.getId());
		ticketDTO.setDescription(ticket.getDescription());
		ticketDTO.setResultDate(ticket.getResultDate());
		return null;
	}

	public List<ReferralTicketDTO> ticketList2TicketListDTO(List<ReferralTicket> allTickets) {
		return allTickets.stream().map(this::ticket2TicketDTO).collect(Collectors.toList());
	}

}
