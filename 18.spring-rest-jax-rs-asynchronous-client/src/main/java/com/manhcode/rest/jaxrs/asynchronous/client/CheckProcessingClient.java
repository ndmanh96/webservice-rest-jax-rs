package com.manhcode.rest.jaxrs.asynchronous.client;

import com.manhcode.rest.jaxrs.asynchronous.client.entity.CheckList;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CheckProcessingClient {
    public static void main(String[] args) {
        postrequest();
    }

    public static void postrequest() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/check-api/checks");

        // async() can then be used to make Async Calls
        AsyncInvoker invoker = target.request().async();

        //Future  is the key for handling asynchronous response
        Future<Boolean> response = invoker.post(Entity.entity(new CheckList(), MediaType.APPLICATION_XML_TYPE), Boolean.class);

        try {
            System.out.println(response.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            if(e.getCause() instanceof BadRequestException) {
                BadRequestException bre = (BadRequestException) e.getCause();
                System.out.println("Please send valid of checks");
            }
        }
    }
}
