package com.plateplanner.api.service;

import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.repository.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private IngredientRepo ingredientRepo;

    @Autowired
    public void setIngredientRepo(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    /**
     * getIngredients method will call on the ingredient repository and:
     * @return a list of all ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredientRepo.findAll();
    }

    /**
     * getIngredient method will call on the ingredient repository, take in:
     * @param ingredientId and
     * @return that ingredient by ID
     */
    public Optional<Ingredient> getIngredient(Long ingredientId) {
        return ingredientRepo.findById(ingredientId);
    }
}
