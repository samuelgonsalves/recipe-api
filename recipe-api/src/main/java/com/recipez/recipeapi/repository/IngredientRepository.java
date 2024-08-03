package com.recipez.recipeapi.repository;

import com.recipez.recipeapi.model.ingredient.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
