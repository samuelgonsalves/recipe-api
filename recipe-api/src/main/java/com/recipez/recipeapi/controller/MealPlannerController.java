package com.recipez.recipeapi.controller;

import com.recipez.recipeapi.MealPlannerService;
import com.recipez.recipeapi.model.mealplan.MealPlanRequest;
import com.recipez.recipeapi.model.recipe.Recipe;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8081/")
public class MealPlannerController {
    private final MealPlannerService mealPlannerService;

    public MealPlannerController(MealPlannerService mealPlannerService) {
        this.mealPlannerService = mealPlannerService;
    }

    @PostMapping("/schedule")
    public long addRecipe(@RequestBody MealPlanRequest mealPlanRequest) {
        return mealPlannerService.create(mealPlanRequest);
    }

    @GetMapping("/weeklyPlan")
    public Map<LocalDate, List<Recipe>> getMealPlan(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate) {
        return mealPlannerService.getWeeklyMealPlan(startDate, endDate);
    }
}
