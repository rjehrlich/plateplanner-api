package definitions;

import com.plateplanner.api.ApiApplication;
import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.repository.RecipeRepo;
import io.cucumber.java.Before;
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


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApiApplication.class)
public class SpringBootCucumberTestDefinitions {

    private static final String BASE_URL = "http://localhost:";

    @LocalServerPort
    String port;

    private static Response response;

    @Autowired
    private RecipeRepo recipeRepo;


    @Given("A list of recipes are available")
    public void aListOfRecipesAreAvailable() {
        try {
            ResponseEntity<String> response = new RestTemplate()
                    .exchange(BASE_URL + port + "/api/recipes", HttpMethod.GET, null, String.class);
            List<Map<String, String>> recipes = JsonPath
                    .from(String.valueOf(response
                            .getBody())).get();
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
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
        response = request.get(BASE_URL + port + "/api/recipes/1");
    }

    @Then("the recipe is displayed")
    public void theRecipeIsDisplayed() {
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
    }

}
