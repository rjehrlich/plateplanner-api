package definitions;

import com.plateplanner.api.ApiApplication;
import com.plateplanner.api.model.RecipeIngredient;
import com.plateplanner.api.repository.RecipeIngredientRepo;
import com.plateplanner.api.service.RecipeIngredientService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApiApplication.class)
public class SpringBootCucumberTestDefinitions {

    private static final String BASE_URL = "http://localhost:";

    @LocalServerPort
    String port;

    private static Response response;

    @Autowired
    private RecipeIngredientRepo recipeIngredientRepo;

    @Autowired
    private RecipeIngredientService recipeIngredientService;

    private ResponseEntity<List> recipeIngredientsResponse;


    @Given("A list of recipes are available")
    public void aListOfRecipesAreAvailable() {
        try {
            ResponseEntity<String> response = new RestTemplate()
                    .exchange(BASE_URL + port + "/recipes", HttpMethod.GET, null, String.class);
            List<Map<String, String>> recipes = JsonPath
                    .from(String.valueOf(response
                            .getBody())).get();
            assertEquals(response.getStatusCode(), HttpStatus.OK);
            Assert.assertTrue(recipes.size() > 0);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    @When("I search for a recipe by id")
    public void iSearchForARecipeById() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        // states that Request body is a JSON
        request.header("Content-Type", "application/json");
        response = request.get(BASE_URL + port + "/recipes/1");
    }

    @Then("the recipe is displayed")
    public void theRecipeIsDisplayed() {
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Given("A list of ingredients are available")
    public void aListOfIngredientsAreAvailable() {
        try {
            ResponseEntity<String> response = new RestTemplate()
                    .exchange(BASE_URL + port + "/ingredients", HttpMethod.GET, null, String.class);
            List<Map<String, String>> ingredients = JsonPath
                    .from(String.valueOf(response
                            .getBody())).get();
            assertEquals(response.getStatusCode(), HttpStatus.OK);
            Assert.assertTrue(ingredients.size() > 0);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    @When("I search for an ingredient by id")
    public void iSearchForAnIngredientById() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        // states that Request body is a JSON
        request.header("Content-Type", "application/json");
        response = request.get(BASE_URL + port + "/ingredients/1");
    }

    @Then("the ingredient is displayed")
    public void theIngredientIsDisplayed() {
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Given("A recipe has a list of ingredients available")
    public void aRecipeWithAListOfIngredientsIsAvailable() {
        try {
            // use RestTemplate to send GET request to the URL /recipes/1/ingredients and store in type list of recipeingredients
            recipeIngredientsResponse = new RestTemplate()
                    .exchange(BASE_URL + port + "/recipes/1/ingredients", HttpMethod.GET, null, List.class);
            // check if the response code is OK
            Assert.assertEquals(recipeIngredientsResponse.getStatusCode(), HttpStatus.OK);
            // check if the response is not null
            Assert.assertNotNull(recipeIngredientsResponse);
            // get the body of the response and check if there is something there
            List<RecipeIngredient> recipeIngredients = recipeIngredientsResponse.getBody();
            Assert.assertNotNull(recipeIngredients);

            // check if there is a list of ingredients
            Assert.assertTrue(recipeIngredients.size() > 0);
            //System.out.println(recipeIngredients);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    @When("I search for an ingredient by ID and recipe ID")
    public void iSearchForAnIngredientByIdAndRecipeId() {
        try {
            // use RestTemplate to send GET request to the URL /recipes/1/ingredients and store in type list of recipeingredients
            recipeIngredientsResponse = new RestTemplate()
                    .exchange(BASE_URL + port + "/recipes/1/ingredients", HttpMethod.GET, null, List.class);
            // check if the response code is OK
            Assert.assertEquals(recipeIngredientsResponse.getStatusCode(), HttpStatus.OK);
            // check if the response is not null
            Assert.assertNotNull(recipeIngredientsResponse);
            // get the body of the response and check if there is something there
            List<RecipeIngredient> recipeIngredients = recipeIngredientsResponse.getBody();
            Assert.assertNotNull(recipeIngredients);

            // check if ingredient exists
            Assert.assertNotNull(recipeIngredientRepo.findByRecipeIdAndIngredientId(1L, 1L).get().ingredient);
            Assert.assertNotNull(recipeIngredientService.getRecipeIngredient(1L, 1L));
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    @Then("the ingredient by recipe id is displayed")
    public void theIngredientByRecipeIdIsDisplayed() {
        // use RestTemplate to send GET request to the URL /recipes/1/ingredients and store in type list of recipeingredients
        recipeIngredientsResponse = new RestTemplate()
                .exchange(BASE_URL + port + "/recipes/1/ingredients", HttpMethod.GET, null, List.class);

        assertEquals(HttpStatus.OK, recipeIngredientsResponse.getStatusCode());
        assertNotNull(recipeIngredientsResponse.getBody().get(0));
    }


}
