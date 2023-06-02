Feature: Rest API Functionalities

  Scenario: User able to view all Recipes
    Given A list of recipes are available
    When I search for a recipe by id
    Then the recipe is displayed