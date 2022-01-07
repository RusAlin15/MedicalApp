package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.ReferralTicket;

public interface ReferralTicketService {

	ReferralTicket saveReferralTicket(ReferralTicket referralTicket);

	List<ReferralTicket> getAllReferralTickets();

}
