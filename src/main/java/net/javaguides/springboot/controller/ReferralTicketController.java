package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.ReferralTicket;
import net.javaguides.springboot.service.ReferralTicketService;

@RestController
@RequestMapping("api/referral")
public class ReferralTicketController {
	private ReferralTicketService referralTicketService;

	public ReferralTicketController(ReferralTicketService referralTicketService) {
		super();
		this.referralTicketService = referralTicketService;
	}

	@PostMapping
	private ResponseEntity<ReferralTicket> saveReferralTicket(@RequestBody ReferralTicket referralTicket) {
		return new ResponseEntity<ReferralTicket>(referralTicketService.saveReferralTicket(referralTicket),
				HttpStatus.CREATED);
	}

	@GetMapping
	private List<ReferralTicket> getAllReferralTickets() {
		return referralTicketService.getAllReferralTickets();
	}
}
