package com.plateplanner.api.controller;

import com.plateplanner.api.exception.InformationNotFoundException;
import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.model.RecipeIngredient;
import com.plateplanner.api.repository.RecipeIngredientRepo;
import com.plateplanner.api.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeIngredientController {

    private RecipeIngredientRepo recipeIngredientRepo;

    private RecipeRepo recipeRepo;

    @Autowired
    public void setRecipeIngredientRepo(RecipeIngredientRepo recipeIngredientRepo) {
        this.recipeIngredientRepo = recipeIngredientRepo;
    }

    @Autowired
    public void setRecipeRepo(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    /**
     * getRecipeIngredients method provides an endpoint that will take in:
     *
     * @param recipeId and
     * @return the ingredients in a list of that recipe
     */
    @GetMapping(path = "/recipes/{recipeId}/ingredients")
    public List<Ingredient> getRecipeIngredients(@PathVariable Long recipeId) {
        Optional<Recipe> recipe = recipeRepo.findById(recipeId);
        if (recipe.isEmpty()) {
            throw new InformationNotFoundException("Recipe with ID " + recipeId + " not found");
        } else {
            return recipe.get().getIngredients();
        }
    }

    /**
     * getRecipeIngredient method provides an endpoint that will take in:
     * @param recipeId
     * @param ingredientId and
     * @return a single ingredient that matches the given id and recipe id
     */
    @GetMapping(path = "/{ingredientId}")
    public Optional<RecipeIngredient> getRecipeIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
        Optional<RecipeIngredient> ingredient = recipeIngredientRepo.findByRecipeIdAndIngredientId(recipeId, ingredientId);
        if (ingredient.isEmpty()) {
            throw new InformationNotFoundException("Ingredient with id " + ingredientId + " for recipe " + recipeId + " not found");
        } else {
            return ingredient;
        }
    }
}
