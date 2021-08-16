package com.manhcode.rest.jaxrs.injection.service;

import com.manhcode.rest.jaxrs.injection.entity.Passenger;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.util.List;

@Path(value = "/passenger-api")
@Consumes({"application/xml", "application/json","application/x-www-form-urlencoded"})
@Produces({"application/xml", "application/json"})
public interface PassengerService {
    @GET
    @Path(value = "/passengers")
    public List<Passenger> findAll(@QueryParam("start") int start, @QueryParam("size") int size);

    @POST
    @Path(value = "/passengers")
    public Passenger save(Passenger passenger);

    @POST
    @Path(value = "/passengers2")
    public Passenger save2(@FormParam("firstName") String firstName,@FormParam("lastName") String lastName);

    @POST
    @Path(value = "/passengers3")
    public Passenger save3(@HeaderParam("agent") String agent, Passenger passenger);

    // @Context
    @GET
    @Path("/test")
    public void testContext(@Context HttpHeaders headers);
}
