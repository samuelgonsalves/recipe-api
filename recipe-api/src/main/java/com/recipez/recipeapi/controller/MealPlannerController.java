package com.recipez.recipeapi.controller;

import com.recipez.recipeapi.MealPlannerService;
import com.recipez.recipeapi.model.MealPlanRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
