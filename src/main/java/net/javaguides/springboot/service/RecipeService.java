package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Recipe;

public interface RecipeService {

	Recipe saveRecipe(Recipe recipe);

	List<Recipe> getAllRecipes();

}
