package net.javaguides.springboot.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.RecipeDTO;
import net.javaguides.springboot.facade.RecipeFacade;

@RestController
@RequestMapping("recipe")
public class RecipeController {

	@Autowired
	private RecipeFacade recipeFacade;

	@PostMapping
	public ResponseEntity<RecipeDTO> saveRecipe(@RequestBody RecipeDTO recipeDTO) {
		return new ResponseEntity<RecipeDTO>(recipeFacade.saveRecipe(recipeDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{recipeId}")
	public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable("recipeId") long recipeId,
			@RequestBody RecipeDTO recipeDTO) {
		return new ResponseEntity<RecipeDTO>(recipeFacade.updateRecipe(recipeId, recipeDTO), HttpStatus.OK);
	}

	@GetMapping("/{recipeId")
	public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable("recipeId") long recipeId) {
		return new ResponseEntity<RecipeDTO>(recipeFacade.getRecipeById(recipeId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
		return new ResponseEntity<List<RecipeDTO>>(recipeFacade.getAllRecipes(), HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping("/recipeId")
	public ResponseEntity<String> deleteRecipeById(@PathVariable("recipeID") long recipeId) {
		recipeFacade.deleteRecipeById(recipeId);
		return new ResponseEntity<String>("Recipe succesfuly deleted!", HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping
	public ResponseEntity<String> deleteAllRecipes() {
		recipeFacade.deleteAllRecipes();
		return new ResponseEntity<String>("All recipes succesfuly deleted!", HttpStatus.OK);
	}
}
