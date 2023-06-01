package definitions;

import com.plateplanner.api.ApiApplication;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApiApplication.class)
public class SpringBootCucumberTestDefinitions {

    private static final String BASE_URL = "http://localhost:";

    @LocalServerPort
    String port;

    @Given("A list of recipes are available")
    public void aListOfRecipesAreAvailable() {
    }
}
