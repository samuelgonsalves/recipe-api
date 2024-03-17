package com.recipez.recipeapi.model;

import java.util.Optional;
import java.util.Set;

public class RecipeRequest {
    private String title;
    private String description;
    private Set<Long> ingredientIds;
    private Optional<String> imageUrl;

    public RecipeRequest(String title, String description, Set<Long> ingredientIds, Optional<String> imageUrl) {
        this.title = title;
        this.description = description;
        this.ingredientIds = ingredientIds;
        this.imageUrl = imageUrl;
    }

    public RecipeRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Long> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(Set<Long> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }

    public Optional<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Optional<String> imageUrl) {
        this.imageUrl = imageUrl;
    }
}
