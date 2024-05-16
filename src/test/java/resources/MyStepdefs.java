package resources;

import io.cucumber.java.en.And;
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
        String id = "3";
        String response = Functions.listOfObjectsById(id);
        Assertions.assertNotNull(response);
        JsonPath jp = new JsonPath(response);
        Assertions.assertEquals(id, jp.getString("[0].id"), "ID not the same!");
    }

    @And("Search for a single product with {string}")
    public void searchForASingleProductWithNum(String id) {
        String response = Functions.singleObject(id);
        Assertions.assertNotNull(response);
        JsonPath jp = new JsonPath(response);
        Assertions.assertEquals(id, jp.getString("id"), "ID not the same!");
    }
}
