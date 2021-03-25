package com.redhat.training;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.redhat.training.service.SolverService;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
@TestHTTPEndpoint(AdderResource.class)
public class AdderResourceTest {

    @InjectMock
    @RestClient
    SolverService solverService;

    @Test
    public void simpleSum() {
        Mockito.when(solverService.solve("2")).thenReturn(Float.valueOf("2"));
        Mockito.when(solverService.solve("3")).thenReturn(Float.valueOf("3"));

        given()
        .when().get("3/2")
        .then()
            .statusCode(200)
            .body(is("5.0"));
    }

    @Test
    public void negativeSum() {
        Mockito.when(solverService.solve("-2")).thenReturn(Float.valueOf("-2"));
        Mockito.when(solverService.solve("3")).thenReturn(Float.valueOf("3"));

        given()
        .when().get("3/-2")
        .then()
            .statusCode(200)
            .body(is("1.0"));
    }

    @Test
    public void wrongValue() {
        WebApplicationException cause = new WebApplicationException("Unknown error", Response.Status.BAD_REQUEST);
        Mockito.when(solverService.solve("a")).thenThrow( new ResteasyWebApplicationException(cause) );
        Mockito.when(solverService.solve("3")).thenReturn(Float.valueOf("3"));

        given()
        .when().get("3/a")
        .then()
            .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

}
