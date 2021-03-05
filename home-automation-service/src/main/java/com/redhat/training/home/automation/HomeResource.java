
package com.redhat.training.home.automation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.redhat.training.home.automation.lights.ConsoleLightSystem;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path( "/home" )
public class HomeResource {

    @Inject
    HomeAutomation home;

    @Inject
    ConsoleLightSystem light;

    @GET
    @Path("/process/daylight/{daylight}")
    public Response setConditions(@PathParam float daylight) {
        RoomConditions conditions = new RoomConditions(daylight, true);

        home.processConditions(conditions);

        return Response.accepted("Room conditions processed").build();
    }

    @GET
    @Path("/lights")
    public Response getLights(@PathParam float daylight) {
        String message = light.isOn() ? "Lights are on" : "Lights are off";

        return Response.accepted(message).build();
    }

}