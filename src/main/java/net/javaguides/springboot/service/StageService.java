package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Stage;

public interface StageService {

	Stage saveStage(Stage stage);

	List<Stage> getAllStages();

}
