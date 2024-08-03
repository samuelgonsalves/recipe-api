package com.recipez.recipeapi.model.ingredient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.recipez.recipeapi.model.recipe.Recipe;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    @JsonBackReference
    private Set<Recipe> recipes;

    public Ingredient(long id, String name, Set<Recipe> recipes) {
        this.id = id;
        this.name = name;
        this.recipes = recipes;
    }

    public Ingredient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
