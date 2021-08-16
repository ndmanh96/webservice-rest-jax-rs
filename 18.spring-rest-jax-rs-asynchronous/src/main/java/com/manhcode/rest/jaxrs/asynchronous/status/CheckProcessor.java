package com.manhcode.rest.jaxrs.asynchronous.status;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("/check-api")
public interface CheckProcessor {

    // Asynchronous method. So it tells the client that it sends the response back to the client telling it that the actual response
    //will come back at that later point.
    @POST
    @Path("/checks")
    public void processChecks(@Suspended AsyncResponse response, CheckList checkList);

}
