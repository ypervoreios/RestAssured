package resources;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs {
    public String createdId;

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

    @Given("Add new object to catalog")
    public void addNewObjectToCatalog() {
        String response = Functions.addObject();
        JsonPath jp = new JsonPath(response);
        Assertions.assertEquals("Apple MacBook Pro 16", jp.getString("name"));
        createdId = jp.getString("id");
        System.out.println("Created object id: \""+createdId+"\"");
    }

    @When("Update the object with color")
    public void updateTheObjectWithColor() {
        String response = Functions.updateObject(createdId);
        JsonPath jp = new JsonPath(response);
        Assertions.assertEquals(createdId, jp.getString("id"));
        Assertions.assertEquals("silver", jp.getString("data.color"));
    }

    @And("Partial update the name of the object")
    public void partialUpdateTheNameOfTheObject() {
        String response = Functions.partialUpdateObject(createdId);
        JsonPath jp = new JsonPath(response);
        Assertions.assertEquals(createdId, jp.getString("id"));
        String newName = jp.getString("name");
        System.out.println("New updated name: \""+newName+"\"");
    }

    @Then("Delete object")
    public void deleteObject() {
        Functions.deleteObject(createdId);
    }
}
