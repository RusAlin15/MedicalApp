package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.ReferralTicketDTO;
import net.javaguides.springboot.facade.RefferalTicketFacade;

@RestController
@RequestMapping("ticket")
public class ReferralTicketController {
	@Autowired
	private RefferalTicketFacade ticketFacade;

	@PostMapping
	public ResponseEntity<ReferralTicketDTO> saveTicket(@RequestBody ReferralTicketDTO ticketDTO) {
		return new ResponseEntity<ReferralTicketDTO>(ticketFacade.saveTicket(ticketDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{ticketId}")
	public ResponseEntity<ReferralTicketDTO> updateTicket(@PathVariable("ticketId") long ticketId,
			@RequestBody ReferralTicketDTO ticketDTO) {
		return new ResponseEntity<ReferralTicketDTO>(ticketFacade.updateTicket(ticketId, ticketDTO), HttpStatus.OK);
	}

	@GetMapping("/{ticketId}")
	public ResponseEntity<ReferralTicketDTO> getTicketById(@PathVariable("ticketId") long ticketId) {
		return new ResponseEntity<ReferralTicketDTO>(ticketFacade.getTicketById(ticketId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ReferralTicketDTO>> getAllTickets() {
		return new ResponseEntity<List<ReferralTicketDTO>>(ticketFacade.getAllTickets(), HttpStatus.OK);
	}

	@DeleteMapping("/{ticketId}")
	public ResponseEntity<String> deleteTicketById(@PathVariable("ticketId") long ticketId) {
		ticketFacade.deleteTicketById(ticketId);
		return new ResponseEntity<String>("Referral Ticket succesfuly deleted!", HttpStatus.OK);
	}

	@DeleteMapping()
	public ResponseEntity<String> deleteAllTickets() {
		ticketFacade.deleteAllTickets();
		return new ResponseEntity<String>("All Referral Tickets succesfuly deleted!", HttpStatus.OK);
	}

}
