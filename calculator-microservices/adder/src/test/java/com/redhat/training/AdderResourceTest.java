package com.redhat.training;

import java.beans.Transient;

import com.redhat.training.service.SolverService;

import org.eclipse.microprofile.rest.client.inject.RestClient;

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
}}
