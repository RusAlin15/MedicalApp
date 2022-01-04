package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.MorbidityCode;
import net.javaguides.springboot.service.MorbidityCodeService;

@RestController
@RequestMapping("api/morbidities")
public class MordbidityCodeController {
	private MorbidityCodeService morbidityCodeService;

	public MordbidityCodeController(MorbidityCodeService morbidityCodeService) {
		super();
		this.morbidityCodeService = morbidityCodeService;
	}

	@PostMapping
	public ResponseEntity<MorbidityCode> saveMorbidityCode(@RequestBody MorbidityCode morbidityCode) {
		return new ResponseEntity<MorbidityCode>(morbidityCodeService.saveMorbidityCode(morbidityCode),
				HttpStatus.CREATED);
	}

	@GetMapping
	public List<MorbidityCode> getAllMorbidityCodes() {
		return morbidityCodeService.getAllMorbidityCodes();
	}
}
