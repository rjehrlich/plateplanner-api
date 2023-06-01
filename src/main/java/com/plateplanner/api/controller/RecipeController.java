package com.plateplanner.api.controller;

import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RecipeController {

    private RecipeRepo recipeRepo;

    @Autowired
    public void setRecipeRepo(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    /**
     * getRecipes method provides a recipes Endpoint that will:
     * @return a list of all recipes
     */
    @GetMapping(path = "/recipes")
    public List<Recipe> getRecipes() {
        return recipeRepo.findAll();
    }
}
