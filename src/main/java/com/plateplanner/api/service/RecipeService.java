package com.plateplanner.api.service;

import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    /**
     * getRecipes method will call the recipe repository to
     * @return a list of all recipes
     */
    public List<Recipe> getRecipes() {
        return recipeRepo.findAll();
    }

    /**
     * getRecipe method will call the recipe repository taking in:
     * @param recipeId and
     * @return that recipe by ID
     */
    public Optional<Recipe> getRecipe(Long recipeId) {
        return recipeRepo.findById(recipeId);
    }
}
