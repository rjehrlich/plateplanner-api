package definitions;

import com.plateplanner.api.ApiApplication;
import com.plateplanner.api.model.Recipe;
import com.plateplanner.api.repository.RecipeRepo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApiApplication.class)
public class SpringBootCucumberTestDefinitions {

    private static final String BASE_URL = "http://localhost:";

    @LocalServerPort
    String port;

    private static Response response;

    @Autowired
    private RecipeRepo recipeRepo;

    @Before
    public void setUpTestData() {
        // Populate test data before each scenario
        Recipe recipe1 = new Recipe();
        // Set properties for recipe1
        recipeRepo.save(recipe1);

        Recipe recipe2 = new Recipe();
        // Set properties for recipe2
        recipeRepo.save(recipe2);
    }


    @Given("A list of recipes are available")
    public void aListOfRecipesAreAvailable() {

    }

    @When("I search for a recipe by id")
    public void iSearchForARecipeById() {

    }

    @Then("the recipe is displayed")
    public void theRecipeIsDisplayed() {
    }
}
