package com.redhat.training;

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

}
