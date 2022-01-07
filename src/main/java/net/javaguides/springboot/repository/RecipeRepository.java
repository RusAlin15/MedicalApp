package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
