package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.repository.RecipeRepository;

@Service
public class RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;

	public Recipe saveRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public Recipe updateRecipe(long recipeId, Recipe recipe) {
		Recipe recipe2Update = recipeRepository.getById(recipeId);
		recipe2Update.setId(recipe.getId());
		recipe2Update.setDescription(recipe.getDescription());
		recipe2Update.setPurchasedDate(recipe.getPurchasedDate());
		return recipeRepository.saveAndFlush(recipe2Update);
	}

	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	public Recipe getRecipeById(long recipeId) {
		return recipeRepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe", "Id", recipeId));
	}

	public void deleteRecipeById(long recipeId) {
		recipeRepository.deleteById(recipeId);
	}

	public void deleteAllRecipes() {
		recipeRepository.deleteAll();
	}

}
