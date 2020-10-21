package com.redhat.training.tdd;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redhat.training.tdd.sensors.IndoorWeatherMeasured;

@Path("/sensors")
public class SensorsResource {

    @Inject
    EventBus bus;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/weather/new/{temperature}/{humidity}")
    public Response weather(@PathParam float temperature, @PathParam float humidity) {
        bus.sendAndForget("weather", new IndoorWeatherMeasured(temperature, humidity));

        return Response
            .accepted()
            .entity(String.format("Weather measured. Temperature: %.2f. Humidity %.2f%%", temperature, humidity))
            .build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/occupancy/new/{occupancy}")
    public Response weather(@PathParam int occupancy) {
        bus.sendAndForget("occupancy", occupancy);

        return Response.accepted().entity("Occupancy event sent: " + occupancy).build();
    }
}