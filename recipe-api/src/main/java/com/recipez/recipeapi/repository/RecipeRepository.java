package com.recipez.recipeapi.repository;

import com.recipez.recipeapi.model.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
