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
            Recipe recipe1 = new Recipe(1L, "Instant Pot Birria", "Cut cooktime by more than half making your meat in the Instant Pot. You can turn this into delicious tacos, meat for rice bowls, or a soup!", "30min", "1hr", "", "https://www.pressurecookrecipes.com/instant-pot-birria/");

            Ingredient ingredient1 = new Ingredient(1L, "Beef: Chuck Roast");
            Ingredient ingredient2 = new Ingredient(2L, "Beef: Chuck Roast");
            Ingredient ingredient3 = new Ingredient(3L, "Beef: Chuck Roast");
            Ingredient ingredient4 = new Ingredient(4L, "Beef: Chuck Roast");
            Ingredient ingredient5 = new Ingredient(5L, "Beef: Chuck Roast");
            Ingredient ingredient6 = new Ingredient(6L, "Beef: Chuck Roast");
            Ingredient ingredient7 = new Ingredient(7L, "Beef: Chuck Roast");
            Ingredient ingredient8 = new Ingredient(8L, "Beef: Chuck Roast");
            Ingredient ingredient9 = new Ingredient(9L, "Beef: Chuck Roast");
            Ingredient ingredient10 = new Ingredient(10L, "Beef: Chuck Roast");
            Ingredient ingredient11 = new Ingredient(11L, "Beef: Chuck Roast");
            Ingredient ingredient12 = new Ingredient(12L, "Beef: Chuck Roast");
            Ingredient ingredient13 = new Ingredient(13L, "Beef: Chuck Roast");
            Ingredient ingredient14 = new Ingredient(14L, "Beef: Chuck Roast");
            Ingredient ingredient15 = new Ingredient(15L, "Beef: Chuck Roast");
            Ingredient ingredient16 = new Ingredient(16L, "Beef: Chuck Roast");
            Ingredient ingredient17 = new Ingredient(17L, "Beef: Chuck Roast");
            Ingredient ingredient18 = new Ingredient(18L, "Beef: Chuck Roast");

            RecipeIngredient recipeIngredient = new RecipeIngredient();
        }
    }
}
