package com.ecommerce.automation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void testPostRequest() {
        RestAssured.baseURI = "https://api.example.com";

        // Create JSON body for POST request
        String requestBody = "{ \"username\": \"testuser\", \"password\": \"testpassword\" }";

        // Perform POST request
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo("Login successful"));
    }
}
