package com.plateplanner.api.seed;

import com.plateplanner.api.model.Ingredient;
import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.model.RecipeIngredient;
import com.plateplanner.api.repository.IngredientRepo;
import com.plateplanner.api.repository.RecipeIngredientRepo;
import com.plateplanner.api.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RecipeDataLoader implements CommandLineRunner {

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    IngredientRepo ingredientRepo;

    @Autowired
    RecipeIngredientRepo recipeIngredientRepo;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (recipeRepo.count() == 0 || ingredientRepo.count() == 0 || recipeIngredientRepo.count() == 0) {

            // Create Ingredients (shared across multiple recipes)
            Ingredient ingredient1 = new Ingredient(1L, "Beef: Chuck Roast");
            Ingredient ingredient2 = new Ingredient(2L, "Dried Ancho Chili(es)");
            Ingredient ingredient3 = new Ingredient(3L, "Dried Guajillo Chili(es)");
            Ingredient ingredient4 = new Ingredient(4L, "New Mexican Dried Chili(es)");
            Ingredient ingredient5 = new Ingredient(5L, "Dried Chile de Arbol(es)");
            Ingredient ingredient6 = new Ingredient(6L, "White Onion");
            Ingredient ingredient7 = new Ingredient(7L, "Garlic Clove(s)");
            Ingredient ingredient8 = new Ingredient(8L, "Bay Leaf");
            Ingredient ingredient9 = new Ingredient(9L, "Cinnamon Stick(s)");
            Ingredient ingredient10 = new Ingredient(10L, "Oregano");
            Ingredient ingredient11 = new Ingredient(11L, "Cumin");
            Ingredient ingredient12 = new Ingredient(12L, "Coriander");
            Ingredient ingredient13 = new Ingredient(13L, "Roma Tomato(es)");
            Ingredient ingredient14 = new Ingredient(14L, "Chicken Stock");
            Ingredient ingredient15 = new Ingredient(15L, "Apple Cider Vinegar");
            Ingredient ingredient16 = new Ingredient(16L, "Soy Sauce");
            Ingredient ingredient17 = new Ingredient(17L, "Fish Sauce");

            // Save the ingredients
            ingredientRepo.saveAll(Arrays.asList(
                    ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6,
                    ingredient7, ingredient8, ingredient9, ingredient10, ingredient11, ingredient12, ingredient13,
                    ingredient14, ingredient15, ingredient16, ingredient17));

            // Create Recipes
            Recipe recipe1 = new Recipe(1L, "Instant Pot Birria", "Cut cooktime by more than half making your meat in the Instant Pot. You can turn this into delicious tacos, meat for rice bowls, or a soup!", "30min", "1hr", "", "https://www.pressurecookrecipes.com/instant-pot-birria/");
//            Recipe recipe2 = new Recipe();
//            Recipe recipe3 = new Recipe();
//            Recipe recipe4 = new Recipe();
//            Recipe recipe5 = new Recipe();

            // Create recipe-ingredient associations
                // recipe1 associations
            RecipeIngredient recipeIngredient1 = new RecipeIngredient(recipe1, ingredient1, "3lbs");
            RecipeIngredient recipeIngredient2 = new RecipeIngredient(recipe1, ingredient2, "3");
            RecipeIngredient recipeIngredient3 = new RecipeIngredient(recipe1, ingredient3, "3");
            RecipeIngredient recipeIngredient4 = new RecipeIngredient(recipe1, ingredient4, "1");
            RecipeIngredient recipeIngredient5 = new RecipeIngredient(recipe1, ingredient5, "1");
            RecipeIngredient recipeIngredient6 = new RecipeIngredient(recipe1, ingredient6, "1");
            RecipeIngredient recipeIngredient7 = new RecipeIngredient(recipe1, ingredient7, "8");
            RecipeIngredient recipeIngredient8 = new RecipeIngredient(recipe1, ingredient8, "2");
            RecipeIngredient recipeIngredient9 = new RecipeIngredient(recipe1, ingredient9, "1/2");
            RecipeIngredient recipeIngredient10 = new RecipeIngredient(recipe1, ingredient10, "3tsp");
            RecipeIngredient recipeIngredient11 = new RecipeIngredient(recipe1, ingredient11, "3tsp");
            RecipeIngredient recipeIngredient12 = new RecipeIngredient(recipe1, ingredient12, "1.5tsp");
            RecipeIngredient recipeIngredient13 = new RecipeIngredient(recipe1, ingredient13, "1.5");
            RecipeIngredient recipeIngredient14 = new RecipeIngredient(recipe1, ingredient14, "3c");
            RecipeIngredient recipeIngredient15 = new RecipeIngredient(recipe1, ingredient15, "2tbsp");
            RecipeIngredient recipeIngredient16 = new RecipeIngredient(recipe1, ingredient16, "1tbsp");
            RecipeIngredient recipeIngredient17 = new RecipeIngredient(recipe1, ingredient17, "1tbsp");
                // recipe2 associations

            // Save the recipes and recipe-ingredient associations
            recipeRepo.saveAll(Arrays.asList(recipe1));
            recipeIngredientRepo.saveAll(Arrays.asList(
                    recipeIngredient1, recipeIngredient2, recipeIngredient3,
                    recipeIngredient4, recipeIngredient5, recipeIngredient6,
                    recipeIngredient7, recipeIngredient8, recipeIngredient9,
                    recipeIngredient10, recipeIngredient11, recipeIngredient12,
                    recipeIngredient13, recipeIngredient14, recipeIngredient15, recipeIngredient16, recipeIngredient17));
        }
    }
}
