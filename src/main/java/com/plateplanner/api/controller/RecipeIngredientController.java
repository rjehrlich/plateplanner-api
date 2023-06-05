package com.plateplanner.api.controller;

import com.plateplanner.api.exception.InformationNotFoundException;
import com.plateplanner.api.model.RecipeIngredient;
import com.plateplanner.api.repository.RecipeIngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/recipes/{recipeId}/ingredients")
public class RecipeIngredientController {

    private RecipeIngredientRepo recipeIngredientRepo;

    @Autowired
    public void setRecipeIngredientRepo(RecipeIngredientRepo recipeIngredientRepo) {
        this.recipeIngredientRepo = recipeIngredientRepo;
    }

    /**
     * getRecipeIngredients method provides an endpoint that will take in:
     * @param recipeId and
     * @return the ingredients in a list of that recipe
     */
    @GetMapping
    public List<RecipeIngredient> getRecipeIngredients(@PathVariable Long recipeId) {
        return recipeIngredientRepo.findAllByRecipeId(recipeId);
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
