package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.ReferralTicketDto;
import net.javaguides.springboot.model.ReferralTicket;
import net.javaguides.springboot.service.ReferralTicketService;

@RestController
@RequestMapping("api/referral")
public class ReferralTicketController {
	@Autowired
	private ReferralTicketService referralTicketService;

	@PostMapping
	private ResponseEntity<ReferralTicketDto> saveReferralTicket(@RequestBody ReferralTicket referralTicket) {
		return new ResponseEntity<ReferralTicketDto>(referralTicketService.saveReferralTicket(referralTicket),
				HttpStatus.CREATED);
	}

	@GetMapping
	private List<ReferralTicketDto> getAllReferralTickets() {
		return referralTicketService.getAllReferralTickets();
	}
}
