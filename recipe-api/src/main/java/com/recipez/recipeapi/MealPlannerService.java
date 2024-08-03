package com.recipez.recipeapi;

import com.recipez.recipeapi.model.mealplan.MealPlan;
import com.recipez.recipeapi.model.mealplan.MealPlanRequest;
import com.recipez.recipeapi.model.recipe.Recipe;
import com.recipez.recipeapi.repository.MealPlannerRepository;
import com.recipez.recipeapi.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Map<LocalDate, List<Recipe>> getWeeklyMealPlan(LocalDate startDate, LocalDate endDate) {

        // TODO: Optimize this later
        List<MealPlan> mealPlans = mealPlannerRepository.findAll().stream()
                .filter(m -> (m.getMealDate().isEqual(startDate)
                        || m.getMealDate().isAfter(startDate))
                )
                .filter(m -> (m.getMealDate().isEqual(endDate)
                        || m.getMealDate().isBefore(endDate))).toList();

        return mealPlans.stream().collect(Collectors.groupingBy(MealPlan::getMealDate,
                Collectors.mapping(MealPlan::getRecipe, Collectors.toList())));
    }

}
