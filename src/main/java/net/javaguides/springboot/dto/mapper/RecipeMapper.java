package net.javaguides.springboot.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.RecipeDTO;
import net.javaguides.springboot.model.Recipe;

@Service
public class RecipeMapper {

	public RecipeDTO recipe2recipeDTO(Recipe recipe) {
		RecipeDTO recipeDTO = new RecipeDTO();
		recipeDTO.setId(recipe.getId());
		recipeDTO.setDescription(recipe.getDescription());
		return recipeDTO;
	}

	public Recipe recipeDTO2recipe(RecipeDTO recipeDTO) {
		Recipe recipe = new Recipe();
		recipe.setId(recipeDTO.getId());
		recipe.setDescription(recipeDTO.getDescription());
		return recipe;
	}

	public List<RecipeDTO> recipeList2recipeDTOList(List<Recipe> allRecipes) {
		return allRecipes.stream().map(this::recipe2recipeDTO).collect(Collectors.toList());
	}
}
