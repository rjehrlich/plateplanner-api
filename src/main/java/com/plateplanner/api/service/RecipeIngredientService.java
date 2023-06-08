package com.plateplanner.api.service;

import com.plateplanner.api.exception.InformationNotFoundException;
import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.model.RecipeIngredient;
import com.plateplanner.api.repository.IngredientRepo;
import com.plateplanner.api.repository.RecipeIngredientRepo;
import com.plateplanner.api.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeIngredientService {

    private RecipeIngredientRepo recipeIngredientRepo;

    private RecipeRepo recipeRepo;

    private IngredientRepo ingredientRepo;

    @Autowired
    public void setRecipeIngredientRepo(RecipeIngredientRepo recipeIngredientRepo) {
        this.recipeIngredientRepo = recipeIngredientRepo;
    }

    @Autowired
    public void setRecipeRepo(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Autowired
    public void setIngredientRepo(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    /**
     * getRecipeIngredients method will take in:
     * @param recipeId and
     * @return the ingredients in a list of that recipe
     */
    public List<Ingredient> getRecipeIngredients(Long recipeId) {
        Optional<Recipe> recipe = recipeRepo.findById(recipeId);
        if (recipe.isEmpty()) {
            throw new InformationNotFoundException("Recipe with ID " + recipeId + " not found");
        } else {
            List<RecipeIngredient> recipeIngredients = recipe.get().getRecipeIngredients();
            List<Ingredient> ingredients = new ArrayList<>();
            for (RecipeIngredient recipeIngredient : recipeIngredients) {
                ingredients.add(recipeIngredient.getIngredient());
            }
            return ingredients;
        }
    }

    /**
     * getRecipeIngredient method will take in:
     * @param recipeId
     * @param ingredientId and
     * @return a single ingredient that matches the given id and recipe id
     */
    public Optional<RecipeIngredient> getRecipeIngredient(Long recipeId, Long ingredientId) {
        Optional<RecipeIngredient> ingredient = recipeIngredientRepo.findByRecipeIdAndIngredientId(recipeId, ingredientId);
        if (ingredient.isEmpty()) {
            throw new InformationNotFoundException("Ingredient with id " + ingredientId + " for recipe " + recipeId + " not found");
        } else {
            return ingredient;
        }
    }


    /**
     * getIngredientsForRecipes method will take in a list of recipe IDs and return
     * the aggregated ingredients from those specific recipes.
     *
     * @param recipeIds the list of recipe IDs to fetch ingredients for
     * @return the combined list of ingredients from the specified recipes
     */
//    public List<Ingredient> getIngredientsForRecipes(List<Long> recipeIds) {
//        List<Ingredient> ingredients = new ArrayList<>();
//
//        for (Long recipeId : recipeIds) {
//            Optional<Recipe> recipe = recipeRepo.findById(recipeId);
//            if (recipe.isPresent()) {
//                List<RecipeIngredient> recipeIngredients = recipe.get().getRecipeIngredients();
//                for (RecipeIngredient recipeIngredient : recipeIngredients) {
//                    Ingredient ingredient = recipeIngredient.getIngredient();
//                    if (!ingredients.contains(ingredient)) {
//                        ingredients.add(ingredient);
//
//                    }
//                }
//            } else {
//                throw new InformationNotFoundException("Recipe with ID " + recipeId + " not found");
//            }
//        }
//        return ingredients;
//    }

    public List<RecipeIngredient> getIngredientsForRecipes(List<Long> recipeIds) {
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();

        for (Long recipeId : recipeIds) {
            Optional<Recipe> recipe = recipeRepo.findById(recipeId);
            if (recipe.isPresent()) {
                List<RecipeIngredient> ingredients = recipe.get().getRecipeIngredients();
                recipeIngredients.addAll(ingredients);
            } else {
                throw new InformationNotFoundException("Recipe with ID " + recipeId + " not found");
            }
        }

         // Fetch the ingredient entity for each recipe ingredient and set the name
            for (RecipeIngredient recipeIngredient : recipeIngredients) {
                Ingredient ingredient = ingredientRepo.findById(recipeIngredient.getIngredient().getId()).orElse(null);
                if (ingredient != null) {
                    recipeIngredient.setIngredientName(ingredient.getName());
                }
            }

        return recipeIngredients;
    }
}
