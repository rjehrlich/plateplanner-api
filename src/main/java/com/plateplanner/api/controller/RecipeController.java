package com.plateplanner.api.controller;

import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    private RecipeRepo recipeRepo;

    @Autowired
    public void setRecipeRepo(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    /**
     * getRecipes method provides a get request Endpoint that will:
     * @return a list of all recipes
     */
    @GetMapping(path = "/recipes")
    public List<Recipe> getRecipes() {
        return recipeRepo.findAll();
    }

    /**
     * getRecipe method provides a get request Endpoint that will take in:
     * @param recipeId and
     * @return that recipe by ID
     */
    @GetMapping(path = "recipes/{recipeId}")
    public Optional<Recipe> getRecipe(@PathVariable(value = "recipeId") Long recipeId) {
        return recipeRepo.findById(recipeId);
    }
}
