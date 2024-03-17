package com.recipez.recipeapi.controller;

import com.recipez.recipeapi.model.RecipeRequest;
import com.recipez.recipeapi.RecipeService;
import com.recipez.recipeapi.model.Recipe;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081/")
public class RecipeController {

    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public Recipe getRecipe(@RequestParam(value = "id") long id) {
        return recipeService.get(id);
    }

    @GetMapping("/recipes")
    public List<Recipe> getRecipe() {
        return recipeService.list();
    }

    @PostMapping("/recipe")
    public long addRecipe(@RequestBody RecipeRequest recipeRequest) {
        return recipeService.create(recipeRequest);
    }
}
