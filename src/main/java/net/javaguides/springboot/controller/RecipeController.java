package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.service.RecipeService;

@RestController
@RequestMapping("api/recipe")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@PostMapping
	private ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe) {
		return new ResponseEntity<Recipe>(recipeService.saveRecipe(recipe), HttpStatus.CREATED);
	}

	@GetMapping
	private List<Recipe> getAllRecipes() {
		return recipeService.getAllRecipes();
	}
}
