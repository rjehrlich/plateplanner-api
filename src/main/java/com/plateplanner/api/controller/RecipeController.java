package com.plateplanner.api.controller;

import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * getRecipes method provides a get request Endpoint that will:
     * @return a list of all recipes
     */
    @GetMapping(path = "/recipes")
    public List<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }

    /**
     * getRecipe method provides a get request Endpoint that will take in:
     * @param recipeId and
     * @return that recipe by ID
     */
    @GetMapping(path = "recipes/{recipeId}")
    public Optional<Recipe> getRecipe(@PathVariable(value = "recipeId") Long recipeId) {
        return recipeService.getRecipe(recipeId);
    }
}
