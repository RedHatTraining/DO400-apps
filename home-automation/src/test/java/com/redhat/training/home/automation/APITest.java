package com.redhat.training.home.automation;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class APITest {

    @Test
    public void testEndpoint() {
        given()
            .pathParam("daylight", "0.15")
            .when().get("/home/conditions/{daylight}")
            .then()
                .statusCode(202)
                .body(is("Room conditions processed"));
    }

}