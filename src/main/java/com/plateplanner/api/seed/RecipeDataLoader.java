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
            Ingredient ingredient18 = new Ingredient(18L, "Lime(s)");
            Ingredient ingredient19 = new Ingredient(19L, "Cilantro");
            Ingredient ingredient20 = new Ingredient(20L, "Beef: Flank");
            Ingredient ingredient21 = new Ingredient(21L, "Vermicelli Rice Noodles");
            Ingredient ingredient22 = new Ingredient(22L, "Romaine Hearts");
            Ingredient ingredient23 = new Ingredient(23L, "Cucumber");
            Ingredient ingredient24 = new Ingredient(24L, "Carrot(s)");
            Ingredient ingredient25 = new Ingredient(25L, "Mint Leaves");
            Ingredient ingredient26 = new Ingredient(26L, "Avocado(s)");
            Ingredient ingredient27 = new Ingredient(27L, "Fish: Ahi Tuna Steaks");
            Ingredient ingredient28 = new Ingredient(28L, "Ginger");


            // Save the ingredients
            ingredientRepo.saveAll(Arrays.asList(
                    ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6,
                    ingredient7, ingredient8, ingredient9, ingredient10, ingredient11, ingredient12, ingredient13,
                    ingredient14, ingredient15, ingredient16, ingredient17, ingredient18, ingredient19, ingredient20,
                    ingredient21, ingredient22, ingredient23, ingredient24, ingredient25, ingredient26, ingredient27));

            // Create Recipes
            Recipe recipe1 = new Recipe(1L,"https://www.pressurecookrecipes.com/wp-content/uploads/2021/01/instant-pot-birria.webp", "Instant Pot Birria", "Cut cooktime by more than half making your meat in the Instant Pot. You can turn this into delicious tacos, meat for rice bowls, or a soup!", "30min", "1hr", "", "https://www.pressurecookrecipes.com/instant-pot-birria/");
            Recipe recipe2 = new Recipe(2L, "https://i0.wp.com/scruffandsteph.com/wp-content/uploads/2019/05/Vietnamese-Beef-Noodle-Bowl-2-1.jpg?w=1500&ssl=1", "Beef Vermicelli(Bun Bo Xao)", "A refreshing, healthy, and easy to make meal that will not disappoint.", "30min", "5min", "", "https://scruffandsteph.com/2019/05/08/vietnamese-beef-noodle-bowls/");
            Recipe recipe3 = new Recipe(3L, "https://fitfoodiefinds.com/wp-content/uploads/2019/07/poke-bowl-14.jpg", "Ahi Tuna Bowl", "A delicious and nutritious bowl that is so easy to make it will likely be in your weekly rotation.", "45min", "30min", "", "https://fitfoodiefinds.com/seared-ahi-tuna-poke-bowl/");
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
            RecipeIngredient recipeIngredient18 = new RecipeIngredient(recipe1, ingredient18, "3");
            RecipeIngredient recipeIngredient19 = new RecipeIngredient(recipe1, ingredient19, "1bunch");

                // recipe2 associations
            RecipeIngredient recipeIngredient20 = new RecipeIngredient(recipe2, ingredient20, "1.5lbs");
            RecipeIngredient recipeIngredient21 = new RecipeIngredient(recipe2, ingredient21, "10oz");
            RecipeIngredient recipeIngredient22 = new RecipeIngredient(recipe2, ingredient7, "2");
            RecipeIngredient recipeIngredient23 = new RecipeIngredient(recipe2, ingredient22, "1");
            RecipeIngredient recipeIngredient24 = new RecipeIngredient(recipe2, ingredient23, "1");
            RecipeIngredient recipeIngredient25 = new RecipeIngredient(recipe2, ingredient19, "1bunch");
            RecipeIngredient recipeIngredient26 = new RecipeIngredient(recipe2, ingredient25, "3-5");
            RecipeIngredient recipeIngredient27 = new RecipeIngredient(recipe2, ingredient24, "3");

            // recipe3 associations
            RecipeIngredient recipeIngredient28 = new RecipeIngredient(recipe3, ingredient27, "1.5lbs");
            RecipeIngredient recipeIngredient29 = new RecipeIngredient(recipe3, ingredient16, "1/3cup");
            RecipeIngredient recipeIngredient30 = new RecipeIngredient(recipe3, ingredient28, "1tsp");
            RecipeIngredient recipeIngredient31 = new RecipeIngredient(recipe3, ingredient18, "3");
            RecipeIngredient recipeIngredient32 = new RecipeIngredient(recipe3, ingredient19, "1/4c");
            RecipeIngredient recipeIngredient33 = new RecipeIngredient(recipe3, ingredient23, "1");
            RecipeIngredient recipeIngredient34 = new RecipeIngredient(recipe3, ingredient22, "1");
            RecipeIngredient recipeIngredient35 = new RecipeIngredient(recipe3, ingredient15, "2tbsp");
            RecipeIngredient recipeIngredient36 = new RecipeIngredient(recipe3, ingredient26, "2");

            // Save the recipes and recipe-ingredient associations
            recipeRepo.saveAll(Arrays.asList(recipe1, recipe2, recipe3));
            recipeIngredientRepo.saveAll(Arrays.asList(
                    recipeIngredient1, recipeIngredient2, recipeIngredient3,
                    recipeIngredient4, recipeIngredient5, recipeIngredient6,
                    recipeIngredient7, recipeIngredient8, recipeIngredient9,
                    recipeIngredient10, recipeIngredient11, recipeIngredient12,
                    recipeIngredient13, recipeIngredient14, recipeIngredient15,
                    recipeIngredient16, recipeIngredient17, recipeIngredient18,
                    recipeIngredient19, recipeIngredient20, recipeIngredient21, recipeIngredient22,
                    recipeIngredient23, recipeIngredient24, recipeIngredient25, recipeIngredient26,
                    recipeIngredient27, recipeIngredient28, recipeIngredient29, recipeIngredient30,
                    recipeIngredient31, recipeIngredient32, recipeIngredient33, recipeIngredient34,
                    recipeIngredient35, recipeIngredient36));
        }
    }
}
