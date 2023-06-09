package com.plateplanner.api.controller;

import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.model.RecipeIngredient;
import com.plateplanner.api.service.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/recipes")
public class RecipeIngredientController {

    private RecipeIngredientService recipeIngredientService;

    @Autowired
    public void setRecipeIngredientService(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    /**
     * getRecipeIngredients method provides an endpoint that will take in:
     * @param recipeId and
     * @return the ingredients in a list of that recipe
     */
    @GetMapping(path = "/{recipeId}/recipe-ingredients")
    public List<Ingredient> getRecipeIngredients(@PathVariable Long recipeId) {
        return recipeIngredientService.getRecipeIngredients(recipeId);
    }

    /**
     * getRecipeIngredient method provides an endpoint that will take in:
     * @param recipeId
     * @param ingredientId and
     * @return a single ingredient that matches the given id and recipe id
     */
    @GetMapping(path = "/{recipeId}/recipe-ingredients/{ingredientId}")
    public Optional<RecipeIngredient> getRecipeIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
        return recipeIngredientService.getRecipeIngredient(recipeId, ingredientId);
    }

    /**
     * getIngredientsForRecipes method provides an endpoint that will take in:
     * @param recipeIds list
     * @return ingredients that matches the given recipe ids
     */
    @GetMapping("/{recipeIds}/ingredients")
    public List<RecipeIngredient> getIngredientsForRecipes(@PathVariable List<Long> recipeIds) {
        return recipeIngredientService.getIngredientsForRecipes(recipeIds);
    }

}
