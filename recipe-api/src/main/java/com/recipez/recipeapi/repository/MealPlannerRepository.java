package com.recipez.recipeapi.repository;

import com.recipez.recipeapi.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealPlannerRepository extends JpaRepository<MealPlan, Long> {
}
