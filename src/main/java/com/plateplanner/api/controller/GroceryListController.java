package com.plateplanner.api.controller;

import com.plateplanner.api.model.GroceryList;
import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.repository.GroceryListRepo;
import com.plateplanner.api.repository.RecipeRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GroceryListController {

    private RecipeRepo recipeRepo;
    private GroceryListRepo groceryListRepo;

    /**
     * GroceryListController constructor takes the dependencies:
     * @param recipeRepo
     * @param groceryListRepo
     * and injects them into the class
     */
    public GroceryListController(RecipeRepo recipeRepo, GroceryListRepo groceryListRepo) {
        this.recipeRepo = recipeRepo;
        this.groceryListRepo = groceryListRepo;
    }

    /**
     * generateGroceryList method creates an endpoint mapping that takes in multiple:
     * @param recipeIds and
     * @return all ingredients in a list for ALL recipes
     */
    @PostMapping("/grocery-lists")
    public GroceryList generateGroceryList(@RequestBody List<Long> recipeIds) {
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
