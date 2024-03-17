package com.recipez.recipeapi;

import com.recipez.recipeapi.model.MealPlan;
import com.recipez.recipeapi.model.MealPlanRequest;
import com.recipez.recipeapi.model.Recipe;
import com.recipez.recipeapi.repository.MealPlannerRepository;
import com.recipez.recipeapi.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class MealPlannerService {
    private final MealPlannerRepository mealPlannerRepository;
    private final RecipeRepository recipeRepository;

    public MealPlannerService(MealPlannerRepository mealPlannerRepository, RecipeRepository recipeRepository) {
        this.mealPlannerRepository = mealPlannerRepository;
        this.recipeRepository = recipeRepository;
    }

    public long create(MealPlanRequest mealPlanRequest) {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMealDate(mealPlanRequest.getMealDate());

        Optional<Recipe> recipeMaybe = recipeRepository.findById(mealPlanRequest.getRecipeId());
        if (recipeMaybe.isEmpty()) {
            throw new IllegalArgumentException("Could not find recipe with id: " + mealPlanRequest.getRecipeId());
        }
        mealPlan.setRecipe(recipeMaybe.get());
        mealPlannerRepository.save(mealPlan);
        return mealPlan.getId();
    }
}
