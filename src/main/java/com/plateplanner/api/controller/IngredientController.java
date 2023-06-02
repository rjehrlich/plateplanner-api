package com.plateplanner.api.controller;

import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.repository.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
