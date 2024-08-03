package com.recipez.recipeapi.controller;

import com.recipez.recipeapi.model.recipe.RecipeRequest;
import com.recipez.recipeapi.RecipeService;
import com.recipez.recipeapi.model.recipe.Recipe;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<Recipe> getRecipes() {
        return recipeService.list();
    }

    @PostMapping("/recipes")
    public long addRecipe(@RequestBody RecipeRequest recipeRequest) {
        return recipeService.create(recipeRequest);
    }

    @PutMapping("/recipes/{id}")
    public void updateRecipe(@PathVariable("id") long id, @RequestBody RecipeRequest recipeRequest) {
        recipeService.update(id, recipeRequest);
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable("id") long id) {
        recipeService.delete(id);
    }
}
