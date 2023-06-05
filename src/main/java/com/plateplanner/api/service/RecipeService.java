package com.plateplanner.api.service;

import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    /**
     * getRecipes method will
     * @return a list of all recipes
     */
    public List<Recipe> getRecipes() {
        return recipeRepo.findAll();
    }

    /**
     * getRecipe method provides a get request Endpoint that will take in:
     * @param recipeId and
     * @return that recipe by ID
     */
    public Optional<Recipe> getRecipe(Long recipeId) {
        return recipeRepo.findById(recipeId);
    }
}
