package net.javaguides.springboot.dto;

import net.javaguides.springboot.model.Recipe;

public class RecipeDto {
	private Long id;
	private String description;

	public RecipeDto(Recipe recipe) {
		this.id = recipe.getId();
		this.description = recipe.getDescription();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

}
