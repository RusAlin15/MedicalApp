package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Stage;
import net.javaguides.springboot.repository.StageRepository;
import net.javaguides.springboot.service.StageService;

@Service
public class StageServiceImpl implements StageService {

	StageRepository stageRepository;

	public StageServiceImpl(StageRepository stageRepository) {
		super();
		this.stageRepository = stageRepository;
	}

	@Override
	public Stage saveStage(Stage stage) {
		return stageRepository.save(stage);
	}

	@Override
	public List<Stage> getAllStages() {
		return stageRepository.findAll();
	}

}
