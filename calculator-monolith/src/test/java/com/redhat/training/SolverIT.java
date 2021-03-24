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

    private static void expectEquationSolution(final String equation, final String body) {
        given().when().get(equation).then().statusCode(200).body(is(body));
    }

    @Test
    public void solve_number() {
        expectEquationSolution("4", "4.0");
    }

    @Test
    public void solve_add() {
        expectEquationSolution("4+2","6.0");
    }

    @Test
    public void solve_substract() {
        expectEquationSolution("4-2","2.0");
    }

    @Test
    public void solve_multiply() {
        expectEquationSolution("4*2","8.0");
    }

    @Test
    public void solve_composed() {
        expectEquationSolution("4+2-1","5.0");
    }

    @Test
    public void solve_composed_multiply() {
         expectEquationSolution("4+2*3","10.0");
    }

    @Test
    public void solve_error() {
        given().when().get("error").then().statusCode(400);
    }
}
