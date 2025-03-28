package com.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest {

     @Test
    public void testGreetingsAPI() {

         RestAssured.baseURI = "http://localhost:8081/greet";

         given().when()
                 .get()
                 .then()
                 .body(equalTo("Hello User!"));

    }
}
