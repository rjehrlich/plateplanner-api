Feature: Rest API Functionalities

# Recipe Cases
  Scenario: User able to view, update, and create recipes
    Given A list of recipes are available
    When I search for a recipe by id
    Then the recipe is displayed

# Ingredient Cases
  Scenario: User able to view, create and update Ingredients
    Given A list of ingredients are available
    When I search for an ingredient by id
    Then the ingredient is displayed

# RecipeIngredient Cases
  Scenario: User able to view ingredients associated to recipes