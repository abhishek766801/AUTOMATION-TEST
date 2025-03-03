package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
import static io.restassured.RestAssured.given;
 
public class APIHelper {
    public APIHelper(String baseUri) {
        RestAssured.baseURI = baseUri;
    }
 
    public Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
 
    public Response postRequest(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
 
    public Response putRequest(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }
}