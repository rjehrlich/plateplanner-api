package com.plateplanner.api.controller;

import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.model.RecipeIngredient;
import com.plateplanner.api.service.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeIngredientController {

    private RecipeIngredientService recipeIngredientService;

    @Autowired
    public void setRecipeIngredientService(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    /**
     * getRecipeIngredients method provides an endpoint that will take in:
     *
     * @param recipeId and
     * @return the ingredients in a list of that recipe
     */
    @GetMapping(path = "/recipes/{recipeId}/ingredients")
    public List<Ingredient> getRecipeIngredients(@PathVariable Long recipeId) {
        return recipeIngredientService.getRecipeIngredients(recipeId);
    }

    /**
     * getRecipeIngredient method provides an endpoint that will take in:
     * @param recipeId
     * @param ingredientId and
     * @return a single ingredient that matches the given id and recipe id
     */
    @GetMapping(path = "/{ingredientId}")
    public Optional<RecipeIngredient> getRecipeIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
        return recipeIngredientService.getRecipeIngredient(recipeId, ingredientId);
    }

}
