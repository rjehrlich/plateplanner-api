package com.plateplanner.api.service;

import com.plateplanner.api.model.GroceryList;
import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.repository.GroceryListRepo;
import com.plateplanner.api.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroceryListService {

    private RecipeRepo recipeRepo;
    private GroceryListRepo groceryListRepo;

    @Autowired
    public void setRecipeRepo(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Autowired
    public void setGroceryListRepo(GroceryListRepo groceryListRepo) {
        this.groceryListRepo = groceryListRepo;
    }

    /**
     * generateGroceryList method takes in multiple:
     * @param recipeIds and
     * @return all ingredients in a list for ALL recipes
     */
    public GroceryList generateGroceryList(List<Long> recipeIds) {
        // Retrieve the selected recipes from the recipe IDs
        List<Recipe> recipes = recipeRepo.findAllById(recipeIds);

        // Extract the ingredients from the selected recipes
        List<Ingredient> ingredients = new ArrayList<>();
        for (Recipe recipe : recipes) {
            List<Ingredient> recipeIngredients = recipe.getIngredients();
            ingredients.addAll(recipeIngredients);
        }

        // Create the grocery list with the aggregated ingredients
        GroceryList groceryList = new GroceryList();
        groceryList.setIngredients(ingredients);

        // Save the grocery list to the database
        return groceryListRepo.save(groceryList);
    }
}
