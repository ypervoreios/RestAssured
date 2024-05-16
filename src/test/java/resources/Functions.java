package resources;

import io.restassured.RestAssured;

public class Functions {
    static String baseUri = "https://api.restful-api.dev/objects";


    public static String listOfAllObjects(){
        return RestAssured
                .given()
                .baseUri(baseUri)
                .get()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .asString();
    }

    public static String listOfObjectsById(String id){
        return RestAssured
                .given()
                .baseUri(baseUri)
                .queryParam("id", id)
                .get()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .asPrettyString();
    }

    public static String singleObject(String id){
        return RestAssured
                .given()
                .baseUri(baseUri)
                .basePath("/"+id)
                .get()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .asPrettyString();
    }
}
