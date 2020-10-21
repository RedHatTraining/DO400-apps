package com.redhat.training.tdd;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.training.tdd.control.AirConditioningController;

@Path("/home")
public class HomeResource {

    @Inject
    AirConditioningController home;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getEvents() {
        return home.getEvents().toString();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/ac")
    public String getAcStatus() {
        return home.getAcStatus();
    }
}