package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.repository.RecipeRepository;

@Service
public class RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;

	public Recipe saveRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

}
