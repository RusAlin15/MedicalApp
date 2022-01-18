package net.javaguides.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.RecipeDto;
import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.repository.RecipeRepository;

@Service
public class RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;

	public RecipeDto saveRecipe(Recipe recipe) {
		return convertToDto(recipeRepository.save(recipe));
	}

	private RecipeDto convertToDto(Recipe recipe) {
		return new RecipeDto(recipe);
	}

	public List<RecipeDto> getAllRecipes() {
		return recipeRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}
}
