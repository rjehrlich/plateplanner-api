Feature: Rest API Functionalities

#  Recipe Testing
  Scenario: User able to view, update, and create Recipes and associated Ingredients
    Given A list of recipes are available
    When I search for a recipe by id
    Then the recipe is displayed
    When I update a recipe by id
    Then the recipe is updated
    When I

#    Ingredient Testing
#  Scenario: User able to view, create and update Ingredients
#    Given A list of ingredients are available