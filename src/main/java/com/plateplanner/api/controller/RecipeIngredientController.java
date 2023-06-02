package com.plateplanner.api.controller;

import com.plateplanner.api.repository.RecipeIngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/recipes/{recipeId}/ingredients")
public class RecipeIngredientController {

    private RecipeIngredientRepo recipeIngredientRepo;

    @Autowired
    public void setRecipeIngredientRepo(RecipeIngredientRepo recipeIngredientRepo) {
        this.recipeIngredientRepo = recipeIngredientRepo;
    }


}
