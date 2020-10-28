package com.redhat.training.home.automation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path( "/home" )
public class HomeResource {

    @Inject
    HomeAutomation home;

    @GET
    @Path("/conditions/{daylight}")
    public Response setConditions(@PathParam float daylight) {
        RoomConditions conditions = new RoomConditions(daylight, true);

        home.processConditions(conditions);

        return Response.accepted("Room conditions processed").build();
    }

}