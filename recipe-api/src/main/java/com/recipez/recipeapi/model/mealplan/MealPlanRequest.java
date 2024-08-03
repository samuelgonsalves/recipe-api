package com.recipez.recipeapi.model.mealplan;

import java.time.LocalDate;

public class MealPlanRequest {
    private LocalDate mealDate;
    private Long recipeId;

    public MealPlanRequest(LocalDate mealDate, Long recipeId) {
        this.mealDate = mealDate;
        this.recipeId = recipeId;
    }

    public LocalDate getMealDate() {
        return mealDate;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
