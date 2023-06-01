package definitions;

import com.plateplanner.api.ApiApplication;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
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

    @Given("A list of recipes are available")
    public void aListOfRecipesAreAvailable() {
        try {
            ResponseEntity<String> response = new RestTemplate()
                    .exchange(BASE_URL + port + "/api/recipes", HttpMethod.GET, null, String.class);
            List<Map<String, String>> categories = JsonPath
                    .from(String.valueOf(response
                            .getBody())).get();
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
            Assert.assertTrue(categories.size() > 0);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }
}
