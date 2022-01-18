package net.javaguides.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.ReferralTicketDto;
import net.javaguides.springboot.model.ReferralTicket;
import net.javaguides.springboot.repository.ReferralTicketRepository;

@Service
public class ReferralTicketService {
	@Autowired
	private ReferralTicketRepository referralTicketRepository;

	public ReferralTicketDto saveReferralTicket(ReferralTicket referralTicket) {
		return convertToDto(referralTicketRepository.save(referralTicket));
	}

	private ReferralTicketDto convertToDto(ReferralTicket referalTichet) {
		return new ReferralTicketDto(referalTichet);
	}

	public List<ReferralTicketDto> getAllReferralTickets() {
		return referralTicketRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

}
