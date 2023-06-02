Feature: Rest API Functionalities

#  Recipe Testing
  Scenario: User able to view all Recipes and associated Ingredients
    Given A list of recipes are available
    When I search for a recipe by id
    Then the recipe is displayed
    When I find a recipe by id
    Then the list of ingredients associated is displayed

#    Ingredient Testing