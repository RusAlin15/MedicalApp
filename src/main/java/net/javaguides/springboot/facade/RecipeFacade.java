package net.javaguides.springboot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.dto.RecipeDTO;
import net.javaguides.springboot.dto.mapper.RecipeMapper;
import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.service.RecipeService;

@Component
public class RecipeFacade {
	@Autowired
	private RecipeMapper recipeMapper;

	@Autowired
	private RecipeService recipeService;

	public RecipeDTO saveRecipe(RecipeDTO recipeDTO) {
		Recipe recipe = recipeMapper.recipeDTO2recipe(recipeDTO);
		return recipeMapper.recipe2recipeDTO(recipeService.saveRecipe(recipe));
	}

	public RecipeDTO updateRecipe(long recipeId, RecipeDTO recipeDTO) {
		Recipe recipe = recipeMapper.recipeDTO2recipe(recipeDTO);
		return recipeMapper.recipe2recipeDTO(recipeService.updateRecipe(recipeId, recipe));
	}

	public RecipeDTO getRecipeById(long recipeId) {
		return recipeMapper.recipe2recipeDTO(recipeService.getRecipeById(recipeId));
	}

	public List<RecipeDTO> getAllRecipes() {
		return recipeMapper.recipeList2recipeDTOList(recipeService.getAllRecipes());
	}

	public void deleteRecipeById(long recipeId) {
		recipeService.deleteRecipeById(recipeId);
	}

	public void deleteAllRecipes() {
		recipeService.deleteAllRecipes();
	}

}
