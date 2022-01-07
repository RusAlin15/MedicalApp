package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.repository.RecipeRepository;
import net.javaguides.springboot.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
	private RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Recipe saveRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

}
