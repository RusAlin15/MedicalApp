package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Stage;
import net.javaguides.springboot.service.StageService;

@RestController
@RequestMapping("api/stage")
public class StageController {
	private StageService stageService;

	public StageController(StageService stageService) {
		super();
		this.stageService = stageService;
	}

	@PostMapping()
	public ResponseEntity<Stage> saveStage(@RequestBody Stage stage) {
		return new ResponseEntity<Stage>(stageService.saveStage(stage), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Stage> getAllStages() {
		return stageService.getAllStages();
	}
}
