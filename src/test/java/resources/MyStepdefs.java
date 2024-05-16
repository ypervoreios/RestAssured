package resources;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs {
    @Given("Search for all objects")
    public void searchForAllObjects() {
        String response = Functions.listOfAllObjects();
        Assertions.assertNotNull(response);
    }

    @When("Search for object by ID")
    public void searchForObjectByID() {
    }
}
