package resources;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

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

    public static String addObject(){
        return RestAssured
                .given()
                .baseUri(baseUri)
                .body("{\n" +
                        "   \"name\": \"Apple MacBook Pro 16\",\n" +
                        "   \"data\": {\n" +
                        "      \"year\": 2019,\n" +
                        "      \"price\": 1849.99,\n" +
                        "      \"CPU model\": \"Intel Core i9\",\n" +
                        "      \"Hard disk size\": \"1 TB\"\n" +
                        "   }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .post()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .asPrettyString();
    }

    public static String updateObject(String id){
        return RestAssured
                .given()
                .baseUri(baseUri)
                .basePath("/"+id)
                .body("{\n" +
                        "   \"name\": \"Apple MacBook Pro 16\",\n" +
                        "   \"data\": {\n" +
                        "      \"year\": 2019,\n" +
                        "      \"price\": 2049.99,\n" +
                        "      \"CPU model\": \"Intel Core i9\",\n" +
                        "      \"Hard disk size\": \"1 TB\",\n" +
                        "      \"color\": \"silver\"\n" +
                        "   }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .put()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .asPrettyString();
    }

    public static String partialUpdateObject(String id){
        return RestAssured
                .given()
                .baseUri(baseUri)
                .basePath("/"+id)
                .body("{\n" +
                        "   \"name\": \"Apple MacBook Pro 16 (Updated Name)\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .patch()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .asPrettyString();
    }

    public static void deleteObject(String id){
        RestAssured
                .given()
                .baseUri(baseUri)
                .basePath("/"+id)
                .delete()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .asPrettyString();
    }
}
