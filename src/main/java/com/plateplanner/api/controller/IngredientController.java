package com.plateplanner.api.controller;

import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.repository.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class IngredientController {

    private IngredientRepo ingredientRepo;

    @Autowired
    public void setIngredientRepo(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    /**
     * getIngredients method provides a get request Endpoint that will:
     * @return a list of all ingredients
     */
    @GetMapping(path = "/ingredients")
    public List<Ingredient> getIngredients() {
        return ingredientRepo.findAll();
    }

    /**
     * getIngredient method provides a get request Endpoint that will take in:
     * @param ingredientId and
     * @return that ingredient by ID
     */
    @GetMapping(path = "ingredients/{ingredientId}")
    public Optional<Ingredient> getRecipe(@PathVariable(value = "ingredientId") Long ingredientId) {
        return ingredientRepo.findById(ingredientId);
    }

}
