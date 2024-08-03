package com.recipez.recipeapi;

import com.recipez.recipeapi.model.ingredient.Ingredient;
import com.recipez.recipeapi.model.recipe.Recipe;
import com.recipez.recipeapi.model.recipe.RecipeRequest;
import com.recipez.recipeapi.repository.IngredientRepository;
import com.recipez.recipeapi.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public Recipe get(long id) {
        Optional<Recipe> recipeMaybe = recipeRepository.findById(id);
        if (recipeMaybe.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Could not find recipe with id: " + id);
        }
        return recipeMaybe.get();
    }

    public List<Recipe> list() {
        return recipeRepository.findAll();
    }


    public Long create(RecipeRequest recipeRequest) {
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeRequest.getTitle());
        recipe.setDescription(recipeRequest.getDescription());
        if (recipeRequest.getImageUrl().isPresent()) {
            recipe.setImageUrl(recipeRequest.getImageUrl().get());
        }
        Set<Ingredient> ingredients = new HashSet<>();
        for (Long ingredientId : recipeRequest.getIngredientIds()) {
            Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(() -> new IllegalArgumentException("Invalid ingredient ID: " + ingredientId));
            ingredients.add(ingredient);
        }
        recipe.setIngredients(ingredients);
        recipe.setTags(recipeRequest.getTags() == null ? "" : String.join(",", recipeRequest.getTags()));
        Recipe savedRecipe = recipeRepository.save(recipe);
        return savedRecipe.getId();
    }

    public void update(long id, RecipeRequest recipeRequest) {
        Recipe recipe = recipeRepository.getReferenceById(id);
        recipe.setDescription(recipeRequest.getDescription());
        recipe.setTitle(recipeRequest.getTitle());
        if (recipeRequest.getImageUrl().isPresent()) {
            recipe.setImageUrl(recipeRequest.getImageUrl().get());
        }
        Set<Ingredient> ingredients = new HashSet<>();
        for (Long ingredientId : recipeRequest.getIngredientIds()) {
            Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(() -> new IllegalArgumentException("Invalid ingredient ID: " + ingredientId));
            ingredients.add(ingredient);
        }
        recipe.setIngredients(ingredients);
        recipe.setTags(recipeRequest.getTags() == null ? "" : String.join(",", recipeRequest.getTags()));
        recipeRepository.save(recipe);
    }

    public void delete(long id) {
        recipeRepository.deleteById(id);
    }
}