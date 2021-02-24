package com.redhat.training;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.redhat.training.service.SolverService;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(SolverService.class)
@Tag("integration")
public class SolverIT {

    @Test
    public void solve_number() {
        given()
        .when()
            .get("4")
        .then()
            .statusCode(200)
            .body(is("4.0"));
    }

    @Test
    public void solve_add() {
        given()
        .when()
            .get("4+2")
        .then()
            .statusCode(200)
            .body(is("6.0"));
    }

    @Test
    public void solve_substract() {
        given()
        .when()
            .get("4-2")
        .then()
            .statusCode(200)
            .body(is("2.0"));
    }

    @Test
    public void solve_multiply() {
        given()
        .when()
            .get("4*2")
        .then()
            .statusCode(200)
            .body(is("8.0"));
    }

    @Test
    public void solve_composed() {
        given()
        .when()
            .get("4+2*2-1*3")
        .then()
            .statusCode(200)
            .body(is("5.0"));        
    }

}
